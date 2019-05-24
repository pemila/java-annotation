package com.pemila.annotationdemo;

import com.pemila.annotationdemo.model.User;
import com.pemila.annotationdemo.service.UserService;
import com.pemila.annotationdemo.service.UserServiceImpl;

/**
 * 模拟服务器调用
 * @author 月在未央
 * @date 2019/5/23 18:30
 */
public class Main {

    public static void main(String[] args) {
        UserService target = new UserServiceImpl();
        // 创建代理
        UserService proxy = (UserService) new ProxyFactory(target).getProxyInstance();
        User user = new User("天天");
        // 账号注册
        user = proxy.register(user);
        System.out.println(user);
    }
}
