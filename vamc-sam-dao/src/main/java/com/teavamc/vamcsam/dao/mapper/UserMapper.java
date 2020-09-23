package com.teavamc.vamcsam.dao.mapper;

import com.teavamc.vamcsam.dao.entity.UserDO;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
public interface UserMapper {

    UserDO getByName(String name);

    UserDO getById(Long id);

    void insert(UserDO userDO);
}
