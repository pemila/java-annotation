package com.pemila.java_annotation.Controller;

import com.pemila.java_annotation.annotation.RecordVisit;
import com.pemila.java_annotation.model.User;

import java.util.Random;

/**
 * @author 月在未央
 * @date 2019/5/23 17:41
 */
@RecordVisit
public class UserController {

    public User register(User user){
        user.setId(new Random().nextInt());
        return user;
    }
}
