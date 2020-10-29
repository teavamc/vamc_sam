package com.teavamc.vamcsam.service.practice.dp.factory;

import com.teavamc.vamcsam.service.practice.tools.PrintTools;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.service.practice.dp.factory
 * @date 2020/10/29 09:15
 */
public class OnlineSettleHandle implements SettleHandle {
    @Override
    public void doSettleOrder() {
        PrintTools.printInfo("处理线上预约挂号结算");
    }
}
