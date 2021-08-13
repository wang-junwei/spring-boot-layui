package com.wjw.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: wjw
 * @Date: 2021/8/9 16:21
 */
@Getter
@Setter
public class Role implements Serializable {
    private Integer id;
    private String roleName;

    public Role() {
    }

    public Role(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
