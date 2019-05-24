package com.pemila.annotationdemo.service;

import com.pemila.annotationdemo.annotation.RecordVisit;
import com.pemila.annotationdemo.model.User;

import java.util.Random;

/**
 * @author 月在未央
 * @date 2019/5/24 10:21
 */
@RecordVisit
public class UserServiceImpl implements UserService{

    @Override
    public User register(User user) {
        user.setId(new Random().nextInt());
        return user;
    }

    @Override
    public User login(User user) {
        return null;
    }

    @Override
    public User logout(User user) {
        return null;
    }
}
