package com.teavamc.vamcsam.api.common.enums;

import com.teavamc.vamcsam.api.common.enums.IErrorCode;

import java.beans.ConstructorProperties;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.api.common.response
 * @date 2020/9/24 16:07
 */
public enum CommonResultCode implements IErrorCode {
    SUCCESS(200, "successful"),
    EXCEPTION(-100, "server exception, msg is %s"),
    ILLEGAL_PARAM(-101, "illegal parameter, param is %s"),
    ILLEGAL_PARAM_LENGTH(-102, "illegal paramter length, param is %s"),
    ILLEGAL_AUTH(-103, "illegal auth"),
    ILLEGAL_AUTH_STATUS(-104, "illegal auth status, current status is %s"),
    ERROR_DB(-105, "db error"),
    ERROR_INVOKE_PROXY(-106, "invoke proxy error, proxy result code is %s, msg is %s"),
    ERROR_INVOKE_MESSAGECENTER(-109, "invoke messagecenter error, messagecenter result code is %s, msg is %s"),
    ERROR_DATA_NOT_EXISTS(-107, "%s data not exist"),
    ERROR_DATA_EXISTS(-108, "%s data exist"),
    DUBBO_RPC_ERROR(-109, "Dubbo rpc error,msg is %s"),
    QUOTA_FULL(-110, "quota full, quota is %s"),
    ERROR_BID(-111, "bid error, msg is %s");

    public final int code;
    public final String message;

    @ConstructorProperties({"code", "message"})
    private CommonResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}