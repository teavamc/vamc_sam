package com.teavamc.vamcsam.service.dubbo;

import com.teavamc.vamcsam.core.common.response.PlainResult;
import com.teavamc.vamcsam.api.local.UserService;
import com.teavamc.vamcsam.api.local.model.UserModel;
import com.teavamc.vamcsam.api.rpc.UserRpcService;
import com.teavamc.vamcsam.service.factory.PlainResultFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.service.dubbo
 * @date 2020/9/24 15:35
 */
@Slf4j
@Service
public class UserRpcServiceImpl implements UserRpcService {

    @Resource
    private UserService userService;

    @Override
    public PlainResult<String> getUserName(Long id) {
        return PlainResultFactory.successResult(userService.getUserName(id));
    }

    @Override
    public PlainResult<UserModel> addUser(UserModel user) {
        return PlainResultFactory.successResult(userService.addUser(user));
    }
}
