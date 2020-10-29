package com.teavamc.vamcsam.practice.dp.factory;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.dp.factory
 * @date 2020/10/29 09:20
 */
public enum SettleHandleEnum {

    Online("Online"),
    Machine("Machine"),
    Medical("Medical");

    String Code;

    SettleHandleEnum(String code) {
        this.Code = code;
    }
}
