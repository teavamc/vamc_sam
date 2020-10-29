package com.teavamc.vamcsam.practice.dp.abstractfactory.order;

import com.teavamc.vamcsam.practice.tools.PrintTools;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.dp.abstractfactory
 * @date 2020/10/29 09:44
 */
public class DoctorOrderHandle implements OrderHandle {
    @Override
    public void doOrder() {
        PrintTools.printInfo("开立医生医嘱");
    }
}
