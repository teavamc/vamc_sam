package com.teavamc.vamcsam.core.common.enums;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.api.common.enums
 * @date 2020/9/24 16:06
 */
public enum  OrderTypeEnum {
    ASC("ASC"),
    DESC("DESC");

    private String orderType;

    private OrderTypeEnum(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderType() {
        return this.orderType;
    }
}
