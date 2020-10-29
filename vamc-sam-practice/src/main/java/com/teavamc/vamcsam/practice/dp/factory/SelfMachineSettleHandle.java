package com.teavamc.vamcsam.practice.dp.factory;

import com.teavamc.vamcsam.practice.tools.PrintTools;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.dp.factory
 * @date 2020/10/29 09:16
 */
public class SelfMachineSettleHandle implements SettleHandle {
    @Override
    public void doSettleOrder() {
        PrintTools.printInfo("处理自助机结算");
    }
}
