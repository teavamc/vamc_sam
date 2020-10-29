package com.teavamc.vamcsam.service.practice.dp.abstractfactory.settle;

import com.teavamc.vamcsam.service.practice.dp.abstractfactory.AbstractThreatFactory;
import com.teavamc.vamcsam.service.practice.dp.abstractfactory.enums.SettleTypeEnum;
import com.teavamc.vamcsam.service.practice.dp.abstractfactory.order.OrderHandle;
import org.apache.commons.lang3.StringUtils;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.service.practice.dp.abstractfactory
 * @date 2020/10/29 10:01
 */
public class SettleFactory extends AbstractThreatFactory {

    @Override
    public OrderHandle getOrder(String orderType) {
        return null;
    }

    @Override
    public SettleHandle getSettle(String settleType) {
        if (StringUtils.isBlank(settleType)){
            return null;
        }
        if (SettleTypeEnum.Online.name().equals(settleType)){
            return new OnlineSettleHandle();
        }else if (SettleTypeEnum.Offline.name().equals(settleType)){
            return new OfflineSettleHandle();
        }
        return null;
    }
}
