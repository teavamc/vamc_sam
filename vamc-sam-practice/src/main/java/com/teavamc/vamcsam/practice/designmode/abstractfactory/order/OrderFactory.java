package com.teavamc.vamcsam.practice.designmode.abstractfactory.order;

import com.teavamc.vamcsam.practice.designmode.abstractfactory.AbstractThreatFactory;
import com.teavamc.vamcsam.practice.designmode.abstractfactory.settle.SettleHandle;
import com.teavamc.vamcsam.practice.designmode.abstractfactory.enums.OrderTypeEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.dp.abstractfactory
 * @date 2020/10/29 09:56
 */
public class OrderFactory extends AbstractThreatFactory {
    @Override
    public OrderHandle getOrder(String orderType) {
        if (StringUtils.isBlank(orderType)){
            return null;
        }
        if (OrderTypeEnum.Doctor.name().equals(orderType)){
            return new DoctorOrderHandle();
        }else if (OrderTypeEnum.Mediacal.name().equals(orderType)){
            return new MedicalOrderHandle();
        }
        return null;
    }

    @Override
    public SettleHandle getSettle(String settleType) {
        return null;
    }
}
