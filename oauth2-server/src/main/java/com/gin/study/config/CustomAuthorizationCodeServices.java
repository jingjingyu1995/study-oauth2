package com.gin.study.config;

import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 自定义验证码服务
 */
@Component
public class CustomAuthorizationCodeServices extends RandomValueAuthorizationCodeServices {

    private RandomValueStringGenerator generator = new RandomValueStringGenerator();
    @Override
    public String createAuthorizationCode(OAuth2Authentication authentication) {
        String code = "yjj-"+generator.generate();
        store(code, authentication);
        return code;
    }

    protected final ConcurrentHashMap<String, OAuth2Authentication> authorizationCodeStore = new ConcurrentHashMap<String, OAuth2Authentication>();

    @Override
    protected void store(String code, OAuth2Authentication authentication) {
        this.authorizationCodeStore.put(code, authentication);
    }

    @Override
    public OAuth2Authentication remove(String code) {
        return this.authorizationCodeStore.remove(code);
    }
}
