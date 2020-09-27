package com.teavamc.vamcsam.service.local;

import com.alibaba.fastjson.JSONObject;
import com.teavamc.vamcsam.dao.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;

import com.teavamc.vamcsam.dao.entity.UserDO;
import com.teavamc.vamcsam.api.local.UserService;
import com.teavamc.vamcsam.api.entity.UserModel;

import javax.annotation.Resource;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Slf4j
@Component
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    private static final BeanCopier copier = BeanCopier.create(UserModel.class, UserDO.class, false);

    public String getUserName(Long id) {
        UserDO userDO = userMapper.getById(id);
        return userDO != null ? userDO.getName() : null;
    }

    public UserModel addUser(UserModel user) {
        log.info(JSONObject.toJSONString(user));
        UserDO userDO = new UserDO();
        userDO.setName(user.getName());
        userDO.setAge(user.getAge());
        userMapper.insert(userDO);
        return user;
    }
}
