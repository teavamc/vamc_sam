package com.teavamc.vamcsam.service.practice.dp.factory;

import com.teavamc.vamcsam.service.practice.tools.PrintTools;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.service.practice.dp.factory
 * @date 2020/10/29 09:17
 */
public class MedicalSettleHandle implements SettleHandle {
    @Override
    public void doSettleOrder() {
        PrintTools.printInfo("处理医保结算");
    }
}
