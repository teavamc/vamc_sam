package com.teavamc.vamsam.dubboutils;

import lombok.Getter;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package PACKAGE_NAME
 * @date 2020/9/24 16:52
 */
@Getter
public class BizException extends RuntimeException {

    private int code;

    public BizException(int code) {
        this.code = code;
    }

    public BizException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BizException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public BizException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
