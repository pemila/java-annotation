package com.pemila.annotationdemo.service;

import com.pemila.annotationdemo.model.User;

/**
 * @author 月在未央
 * @date 2019/5/24 10:19
 */
public interface UserService {
    /** 注册*/
    User register(User user);
    /** 登陆*/
    User login(User user);
    /** 退出*/
    User logout(User user);
}
