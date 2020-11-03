package com.teavamc.vamcsam.practice.gateway.loadbalance.strategy;

import com.teavamc.vamcsam.practice.gateway.domain.Invoker;
import com.teavamc.vamcsam.practice.gateway.loadbalance.AbstractLoadBalance;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * 加权随机(一) 区间法
 *
 * 计算总的权重,升生成权重区间
 * 例如:如果权重分别为: 1/9/1/9/4/6/1/9/1/9 , 权重求和为 50, 则权重区间为 [0,50)
 * 每台服务器对应的区间为: [0，1，10，11，20，24，30，31，40，41，50)
 * 区间选择包左不包右
 *
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.gateway.loadbalance.strategy
 * @date 2020/11/2 11:37
 */
public class SectionWeightedRandomStrategy extends AbstractLoadBalance {

    // 判断是否平均分流量
    private boolean averageWeight = true;
    private int totalWeight;

    public SectionWeightedRandomStrategy(List<Invoker> invokers) {
        super(invokers);
        // 获取权重累加后的汇总值
        for (int i=0;i<invokers.size();i++){
            Invoker invoker = invokers.get(i);
            // 如果出现一个不一样的权重则不平均分
            // 候选机器不止一台 && 出现候选机器权重不一样的情况
            if (averageWeight && i > 0 && invoker.getWeight() != invokers.get(i-1).getWeight()){
                averageWeight = false;
            }
            // 权重求和
            totalWeight += invoker.getWeight();
        }
    }

    @Override
    public Invoker doSelect(){

        // 如果平均分或只有一台就直接返回
        if (averageWeight || totalWeight < 1){
            return super.doSelect();
        }
        // 生成范围内的数字
        int index = new Random().nextInt(totalWeight);
        // 如果在范围内就返回
        for (Invoker invoker:invokers){
            if (index < invoker.getWeight()){
                return invoker;
            }
            index -= invoker.getWeight();
        }
        return super.doSelect();
    }


}
