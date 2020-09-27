package com.teavamc.vamcsam.api.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.api.entity.dto
 * @date 2020/9/26 17:43
 */
@Data
public class UserModelDTO implements Serializable {

    /**
     * 邮箱号
     */
    private String mail;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 前缀
     */
    private String prefix;

    /**
     * 用户权限
     */
    private String authority;
}
