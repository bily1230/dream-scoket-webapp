package com.dream.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-5 下午3:57
 **/
public class PasswordEncoderSecurity implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
