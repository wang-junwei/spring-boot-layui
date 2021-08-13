package com.wjw.service;

import com.wjw.pojo.Menu;

import java.util.List;

/**
 * @Author: wjw
 * @Date: 2021/8/9 16:27
 */
public interface MenuService {
    /**
     * 查询用户权限菜单
     * @param roleId 角色id
     * @return list
     */
    List<Menu> getMenuByRoleId(Integer roleId);

    /**
     * 查询所有菜单
     * @return list
     */
    List<Menu> getAllMenu();

    /**
     * 根据id查询菜单
     * @param id id
     * @return menu
     */
    Menu getMenuById(Integer id);
}
