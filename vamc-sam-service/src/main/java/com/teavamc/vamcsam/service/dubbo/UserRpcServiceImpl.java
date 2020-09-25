package com.teavamc.vamcsam.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.teavamc.vamcsam.core.common.response.PlainResult;
import com.teavamc.vamcsam.api.local.UserService;
import com.teavamc.vamcsam.api.local.model.UserModel;
import com.teavamc.vamcsam.api.rpc.UserRpcService;
import com.teavamc.vamcsam.service.factory.PlainResultFactory;
import com.teavamc.vamsam.dubboutils.annotation.EnableErrorHandle;
import com.teavamc.vamsam.dubboutils.annotation.EnableLogging;
import com.teavamc.vamsam.dubboutils.annotation.EnableValidation;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.service.dubbo
 * @date 2020/9/24 15:35
 */
@Slf4j
@Service
@EnableLogging
@EnableErrorHandle
@EnableValidation
public class UserRpcServiceImpl implements UserRpcService {

    @Resource
    private UserService userService;

    @Override
    public PlainResult<String> getUserName(Long id) {
        log.info("getUserName-request:{}",id);
        return PlainResultFactory.successResult(userService.getUserName(id));
    }

    @Override
    public PlainResult<UserModel> addUser(UserModel user) {
        log.info("addUser-request:{}", JSONObject.toJSON(user));
        return PlainResultFactory.successResult(userService.addUser(user));
    }
}
