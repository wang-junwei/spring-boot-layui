package com.wjw.service;

import com.wjw.pojo.Menu;
import com.wjw.pojo.RoleMenu;

import java.util.List;

/**
 * @Author: wjw
 * @Date: 2021/8/11 16:31
 */
public interface RoleMenuService {

    /**
     * 查询用户有权限的二级菜单
     * @param roleId 角色id
     * @return list
     */
    List<Menu> getSecondMenuByUser(String roleId);

    /**
     * 删除角色权限
     * @param roleId 角色id
     * @return int
     */
    Integer delRoleMenuByRoleId(Integer roleId);

    /**
     * 插入权限
     * @param roleMenuList 角色-权限list
     * @return int
     */
    Integer addRoleMenu(List<RoleMenu> roleMenuList);

    /**
     * 查询权限表中是否已存在数据
     * @param roleId 角色id
     * @return int
     */
    Integer getPermissionByRoleId(Integer roleId);
}
