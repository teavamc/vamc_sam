package com.teavamc.vamcsam.practice.gateway.loadbalance.strategy;

import com.google.common.collect.Lists;
import com.teavamc.vamcsam.practice.gateway.domain.Invoker;
import com.teavamc.vamcsam.practice.gateway.domain.ServerProcessDTO;
import com.teavamc.vamcsam.practice.gateway.loadbalance.AbstractLoadBalance;
import com.teavamc.vamcsam.practice.gateway.loadbalance.ILoadBalance;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;
import java.util.stream.IntStream;

/**
 * 加权随机(一) 复制法
 *
 * 每个机器的性能不同,那么性能更好的机器需要分配更多的流量
 * 为每台机器设置一个权重,按比例进行任务的均分
 * 最简单的思路就是权重是多少,则在候选机器中复制多少
 *
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.gateway.loadbalance.strategy
 * @date 2020/11/2 10:32
 */
public class CopyWeightedRandomStrategy extends AbstractLoadBalance {

    private List<Invoker> weightInvokers = Lists.newArrayList();

    public CopyWeightedRandomStrategy(List<Invoker> invokers) {
        super(invokers);
        if (ObjectUtils.isNotEmpty(invokers) && invokers.size() != 0){
            invokers.forEach(item ->{
                // 如果当前遍历到的机器权重小于 2,那就复制一个到权重集合存放
                if (item.getWeight() < 2){
                    weightInvokers.add(item);
                }
                // 如果当前遍历到的机器大于等于 2,那就复制数量等于权重数的对象放进集合
                IntStream.range(0,item.getWeight()).forEach(i->weightInvokers.add(item));
            });
        }
    }

    @Override
    public List<Invoker> getInvokers(){
        return weightInvokers;
    }

    @Override
    public Invoker doSelect(){
        return null;
    }

}
