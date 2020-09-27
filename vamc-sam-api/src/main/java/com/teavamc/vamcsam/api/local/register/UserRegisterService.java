package com.teavamc.vamcsam.api.local.register;

import com.teavamc.vamcsam.api.entity.request.RegisterUserAccountRequest;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.api.local.register
 * @date 2020/9/26 16:54
 */
public interface UserRegisterService {

    /**
     * 注册新用户
     * @param registerUserAccountRequest
     * @return
     */
    String doRegisterUser(RegisterUserAccountRequest registerUserAccountRequest);
}
