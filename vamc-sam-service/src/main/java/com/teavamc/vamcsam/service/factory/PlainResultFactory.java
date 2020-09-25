package com.teavamc.vamcsam.service.factory;

import com.teavamc.vamcsam.core.common.response.PlainResult;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.service.factory
 * @date 2020/9/24 16:35
 */
public class PlainResultFactory {

    public static <T> PlainResult<T> successResult(T data) {
        PlainResult<T> plainResult = new PlainResult<>();
        plainResult.setData(data);
        plainResult.setCode(200);
        plainResult.setSuccess(true);
        return plainResult;
    }

    public static PlainResult<Void> successResult() {
        return successResult(null);
    }

    public static <T> PlainResult<T> errorResult(Integer bizCode, String message) {
        PlainResult<T> plainResult = new PlainResult<>();
        plainResult.setSuccess(false);
        plainResult.setCode(bizCode);
        plainResult.setMessage(message);
        return plainResult;
    }

}
