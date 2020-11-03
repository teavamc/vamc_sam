package com.teavamc.vamcsam.practice.gateway.loadbalance;

import com.teavamc.vamcsam.practice.gateway.domain.Invoker;
import com.teavamc.vamcsam.practice.gateway.domain.ServerProcessDTO;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.gateway.loadbalance
 * @date 2020/11/2 10:30
 */
public interface ILoadBalance {

    /**
     * 获取服务器
     * @return
     */
    Invoker selectServer();

}
