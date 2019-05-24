package com.pemila.annotationdemo.model;

import lombok.Data;

/**
 * @author 月在未央
 * @date 2019/5/23 17:38
 */
@Data
public class User {
    private int id;
    private String name;
    private String password;
    private String status;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
