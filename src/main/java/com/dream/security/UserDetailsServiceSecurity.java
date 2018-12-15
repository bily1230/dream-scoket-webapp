package com.dream.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-5 下午3:29
 **/
public class UserDetailsServiceSecurity implements UserDetailsService {

    private final UserServiceSecurity userServiceSecurity;

    public UserDetailsServiceSecurity(UserServiceSecurity userServiceSecurity) {
        this.userServiceSecurity = userServiceSecurity;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userServiceSecurity.finadUserByUserName(userName);
        if (null != user) {
            return user;
        }
        throw new UsernameNotFoundException("User name" + userName + "not find");
    }
}
