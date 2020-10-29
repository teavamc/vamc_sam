package com.teavamc.vamcsam.service.practice.dp.abstractfactory;

import com.teavamc.vamcsam.service.practice.dp.abstractfactory.enums.OrderTypeEnum;
import com.teavamc.vamcsam.service.practice.dp.abstractfactory.enums.SettleTypeEnum;
import com.teavamc.vamcsam.service.practice.dp.abstractfactory.enums.TreatFactoryTypeEnum;
import com.teavamc.vamcsam.service.practice.dp.abstractfactory.order.OrderHandle;
import com.teavamc.vamcsam.service.practice.dp.abstractfactory.settle.SettleHandle;

/**
 * 抽象工厂模式
 *
 * 抽象工厂模式（Abstract Factory Pattern）是围绕一个超级工厂创建其他工厂。该超级工厂又称为其他工厂的工厂。
 *
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.service.practice.dp.abstractfactory
 * @date 2020/10/29 10:12
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        // 选择抽象工厂下的工厂类 - 通过工厂生成器选择 order 业务场景的下的工厂
        AbstractThreatFactory threatFactory = TreatFactoryProducer.getFactory(TreatFactoryTypeEnum.Order.name());
        // 选择工厂的具体实现类
        OrderHandle orderHandle = threatFactory.getOrder(OrderTypeEnum.Doctor.name());
        orderHandle.doOrder();
        orderHandle = threatFactory.getOrder(OrderTypeEnum.Mediacal.name());
        orderHandle.doOrder();
        // 选择抽象工厂下的工厂类 - 通过工厂生成器选择 settle 业务场景的下的工厂
        threatFactory = TreatFactoryProducer.getFactory(TreatFactoryTypeEnum.Settle.name());
        SettleHandle settleHandle = threatFactory.getSettle(SettleTypeEnum.Online.name());
        settleHandle.doSettle();
        settleHandle = threatFactory.getSettle(SettleTypeEnum.Offline.name());
        settleHandle.doSettle();
    }
}
