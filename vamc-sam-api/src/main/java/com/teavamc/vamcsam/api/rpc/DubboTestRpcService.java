package com.teavamc.vamcsam.api.rpc;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.api.rpc
 * @date 2020/9/25 15:08
 */
public interface DubboTestRpcService {

    void logInfo(String level);

    void logError(String level);

    void logDebug(String level);

    void logWarn(String level);

}
