package com.teavamc.vamcsam.api.entity.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.api.local.model
 * @date 2020/9/26 15:47
 */
@Data
public class RegisterUserAccountRequest implements Serializable {

    /**
     * 邮箱号
     */
    private String mail;

    /**
     * 密码
     */
    private String password;

    /**
     * 确认密码
     */
    private String confirmPassword;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 验证码
     */
    private String captcha;

    /**
     * 前缀
     */
    private String prefix;
}
