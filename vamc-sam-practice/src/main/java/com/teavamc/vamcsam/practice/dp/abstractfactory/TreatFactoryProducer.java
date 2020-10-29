package com.teavamc.vamcsam.practice.dp.abstractfactory;

import com.teavamc.vamcsam.practice.dp.abstractfactory.enums.TreatFactoryTypeEnum;
import com.teavamc.vamcsam.practice.dp.abstractfactory.order.OrderFactory;
import com.teavamc.vamcsam.practice.dp.abstractfactory.settle.SettleFactory;
import org.apache.commons.lang3.StringUtils;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.dp.abstractfactory
 * @date 2020/10/29 10:06
 */
public class TreatFactoryProducer {
    public static AbstractThreatFactory getFactory(String handleType){
        if (StringUtils.isBlank(handleType)){
            return null;
        }
        if (TreatFactoryTypeEnum.Order.name().equals(handleType)){
            return new OrderFactory();
        }else if (TreatFactoryTypeEnum.Settle.name().equals(handleType)){
            return new SettleFactory();
        }
        return null;
    }
}
