package com.teavamc.vamcsam.practice.gateway.loadbalance;

import com.google.common.collect.Lists;
import com.teavamc.vamcsam.practice.gateway.domain.Invoker;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.platform.commons.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.gateway.loadbalance
 * @date 2020/11/2 10:55
 */
public abstract class AbstractLoadBalance implements ILoadBalance{

    protected List<Invoker> invokers;

    protected List<Invoker> results = Lists.newArrayList();

    public AbstractLoadBalance(List<Invoker> invokers){
        this.invokers = invokers;
    }

    public List<Invoker> getInvokers(){
        return invokers;
    }

    @Override
    public Invoker selectServer(){
        // 拿到待选列表
        List<Invoker> list = getInvokers();
        if (ObjectUtils.isEmpty(list) || list.size()==0){
            return null;
        }
        // 如果只有一个候选就直接返回
        if (list.size() == 1){
            return list.get(0);
        }
        // 大于一个结果就进行 loadbalance
        return doSelect();
    }

    public Invoker doSelect(){
        return null;
    }




}
