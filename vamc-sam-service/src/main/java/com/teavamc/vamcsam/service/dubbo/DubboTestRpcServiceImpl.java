package com.teavamc.vamcsam.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.teavamc.vamcsam.api.rpc.DubboTestRpcService;
import com.teavamc.vamsam.dubboutils.annotation.EnableErrorHandle;
import com.teavamc.vamsam.dubboutils.annotation.EnableLogging;
import com.teavamc.vamsam.dubboutils.annotation.EnableValidation;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.service.dubbo
 * @date 2020/9/25 15:11
 */
@Slf4j
@Service
@EnableLogging
@EnableErrorHandle
@EnableValidation
public class DubboTestRpcServiceImpl implements DubboTestRpcService {
    @Override
    public void logInfo(String level) {
        log.info("logInfo:{}",level);
    }

    @Override
    public void logError(String level) {
        log.error("logError:{}",level);
    }

    @Override
    public void logDebug(String level) {
        log.debug("logDebug:{}",level);
    }

    @Override
    public void logWarn(String level) {
        log.warn("logWarn:{}",level);
    }
}