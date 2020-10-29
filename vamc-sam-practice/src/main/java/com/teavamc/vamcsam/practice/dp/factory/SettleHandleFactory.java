package com.teavamc.vamcsam.practice.dp.factory;

import org.apache.commons.lang3.ObjectUtils;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.dp.factory
 * @date 2020/10/29 09:19
 */
public class SettleHandleFactory {

    public static SettleHandle getHandle(SettleHandleEnum type){
        if (ObjectUtils.isEmpty(type)){
            return null;
        }
        switch (type){
            case Online:
                return new OnlineSettleHandle();
            case Medical:
                return new MedicalSettleHandle();
            case Machine:
                return new SelfMachineSettleHandle();
            default:
                return null;
        }
    }
}
