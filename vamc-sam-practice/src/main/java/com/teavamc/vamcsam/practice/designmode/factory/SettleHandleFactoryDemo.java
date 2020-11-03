package com.teavamc.vamcsam.practice.designmode.factory;

/**
 * 工厂模式实现
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.dp.factory
 * @date 2020/10/29 09:27
 */
public class SettleHandleFactoryDemo {

    public static void main(String[] args) {

        SettleHandle settleHandle;

        settleHandle = SettleHandleFactory.getHandle(SettleHandleEnum.Machine);
        settleHandle.doSettleOrder();

        settleHandle = SettleHandleFactory.getHandle(SettleHandleEnum.Online);
        settleHandle.doSettleOrder();

        settleHandle = SettleHandleFactory.getHandle(SettleHandleEnum.Medical);
        settleHandle.doSettleOrder();

    }
}
