package com.teavamc.vamcsam.api.rpc;


import com.teavamc.vamcsam.api.entity.UserModel;
import com.teavamc.vamcsam.core.common.response.PlainResult;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
public interface UserRpcService {

    PlainResult<String> getUserName(Long id);

    PlainResult<UserModel> addUser(UserModel user);
}
