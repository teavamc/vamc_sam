package com.teavamc.vamcsam.api.common.enums;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.api.common.enums
 * @date 2020/9/24 16:06
 */
public interface IErrorCode {
    /**
     * 拿到错误码
     * @return
     */
    int getCode();

    /**
     * 拿到错误信息
     * @return
     */
    String getMessage();
}
