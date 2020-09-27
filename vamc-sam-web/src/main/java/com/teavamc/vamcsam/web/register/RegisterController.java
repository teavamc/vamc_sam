package com.teavamc.vamcsam.web.register;

import com.teavamc.vamcsam.api.entity.request.RegisterUserAccountRequest;
import com.teavamc.vamcsam.api.local.register.UserRegisterService;
import com.teavamc.vamcsam.api.rpc.UserRpcService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.web.register
 * @date 2020/9/26 17:05
 */
@Component
@RestController
@RequestMapping(value = "/register")
public class RegisterController {

    @Resource
    private UserRegisterService userRegisterService;

    @PostMapping(value = "/doRegister")
    public String doRegisterUser(@RequestBody RegisterUserAccountRequest registerUserAccountRequest){
        return userRegisterService.doRegisterUser(registerUserAccountRequest);
    }


}
