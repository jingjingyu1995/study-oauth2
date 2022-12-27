package com.gin.study.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 自定义密码服务
 */
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return (String) charSequence;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {

        return charSequence.toString().equals(s);
    }
}
