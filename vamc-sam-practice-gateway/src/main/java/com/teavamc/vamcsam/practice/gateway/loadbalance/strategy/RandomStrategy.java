package com.teavamc.vamcsam.practice.gateway.loadbalance.strategy;

import com.teavamc.vamcsam.practice.gateway.domain.Invoker;
import com.teavamc.vamcsam.practice.gateway.domain.ServerProcessDTO;
import com.teavamc.vamcsam.practice.gateway.loadbalance.AbstractLoadBalance;
import com.teavamc.vamcsam.practice.gateway.loadbalance.ILoadBalance;

import java.util.List;
import java.util.Random;

/**
 * 完全随机法, 使用随机数, 随机获取候选机器上的任意一台
 *
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.gateway.loadbalance.strategy
 * @date 2020/11/2 10:31
 */
public class RandomStrategy extends AbstractLoadBalance {

    public RandomStrategy(List<Invoker> invokers) {
        super(invokers);
    }

    @Override
    public Invoker doSelect(){
        Random random = new Random(getInvokers().size());
        int index = random.nextInt();
        return getInvokers().get(index);
    }

    @Override
    public List<Invoker> getInvokers(){
        return invokers;
    }

}
