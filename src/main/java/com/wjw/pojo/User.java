package com.wjw.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: wjw
 * @Date: 2021/8/6 10:15
 */
@Getter
@Setter
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String realName;
    private String gender;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private Integer roleId;
    private Role role;

    public User() {
    }

    public User(Integer id, String userName, String password, String realName, String gender, String phone, Date birth, Integer roleId, Role role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.gender = gender;
        this.phone = phone;
        this.birth = birth;
        this.roleId = roleId;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", birth=" + birth +
                ", roleId=" + roleId +
                ", role=" + role +
                '}';
    }
}
