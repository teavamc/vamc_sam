package com.teavamc.vamcsam.practice.gateway.domain;

import lombok.Data;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.gateway.domain
 * @date 2020/11/2 10:49
 */
@Data
public class Invoker {

    /**
     * 服务器进程对象
     */
    private ServerProcessDTO server;

    /**
     * 权重
     * 默认权重等于 1
     */
    private int weight = 1;

    /**
     * 当前权重
     * 默认当前权重为 0
     */
    private int currentWeight = 0;

    public Invoker(ServerProcessDTO server){
        this.server = server;
    }

    public Invoker(ServerProcessDTO server,int weight){
        this.server = server;
        this.weight = weight;
    }

}
