package com.teavamc.vamcsam.service.practice.dp.abstractfactory.order;

import com.teavamc.vamcsam.service.practice.tools.PrintTools;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.service.practice.dp.abstractfactory
 * @date 2020/10/29 09:44
 */
public class DoctorOrderHandle implements OrderHandle {
    @Override
    public void doOrder() {
        PrintTools.printInfo("开立医生医嘱");
    }
}
