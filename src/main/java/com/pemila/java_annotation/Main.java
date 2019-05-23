package com.pemila.java_annotation;

import com.pemila.java_annotation.Controller.UserController;
import com.pemila.java_annotation.model.User;

import javax.annotation.PostConstruct;

/**
 * 模拟服务器调用
 * @author 月在未央
 * @date 2019/5/23 18:30
 */
public class Main {

    public static void main(String[] args) {

        User user = new User("天天");
        UserController userController = new UserController();
        // 用户账号注册
        user = userController.register(user);
        System.out.println(user.toString());
    }
}
