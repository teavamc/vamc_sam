package com.teavamc.vamcsam.practice.dp.abstractfactory;

import com.teavamc.vamcsam.practice.dp.abstractfactory.order.OrderHandle;
import com.teavamc.vamcsam.practice.dp.abstractfactory.settle.SettleHandle;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.dp.abstractfactory
 * @date 2020/10/29 09:47
 */
public abstract class AbstractThreatFactory {

    /**
     * 获得医嘱订单的实例
     * @param orderType
     * @return
     */
    public abstract OrderHandle getOrder(String orderType);

    /**
     * 获得订单结算的实例
     * @param settleType
     * @return
     */
    public abstract SettleHandle getSettle(String settleType);

}
