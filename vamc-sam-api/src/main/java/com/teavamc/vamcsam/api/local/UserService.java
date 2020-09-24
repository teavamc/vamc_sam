package com.teavamc.vamcsam.api.local;


import com.teavamc.vamcsam.api.local.model.UserModel;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
public interface UserService {

    String getUserName(Long id);

    UserModel addUser(UserModel user);
}
