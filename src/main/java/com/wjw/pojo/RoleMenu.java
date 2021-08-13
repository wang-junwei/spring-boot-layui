package com.wjw.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: wjw
 * @Date: 2021/8/13 9:54
 */
@Getter
@Setter
public class RoleMenu {
    private Integer id;
    private Integer roleId;
    private Integer menuId;
    private Integer sort;

    public RoleMenu() {
    }

    public RoleMenu(Integer id, Integer roleId, Integer menuId, Integer sort) {
        this.id = id;
        this.roleId = roleId;
        this.menuId = menuId;
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", menuId=" + menuId +
                ", sort=" + sort +
                '}';
    }
}
