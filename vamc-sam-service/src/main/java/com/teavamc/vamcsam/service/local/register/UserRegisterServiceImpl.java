package com.teavamc.vamcsam.service.local.register;

import com.alibaba.fastjson.JSONObject;
import com.teavamc.vamcsam.api.entity.request.RegisterUserAccountRequest;
import com.teavamc.vamcsam.api.local.register.UserRegisterService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.service.local.register
 * @date 2020/9/26 16:55
 */
@Slf4j
@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    @Override
    public String doRegisterUser(RegisterUserAccountRequest registerUserAccountRequest) {
        if (ObjectUtils.isEmpty(registerUserAccountRequest)){
            log.warn("createNewUser warn, because request param is empty !");
        }else{
            log.info("createNewUser request param:[{}]", JSONObject.toJSON(registerUserAccountRequest));
        }
        return "true";
    }

}
