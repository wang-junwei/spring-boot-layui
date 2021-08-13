package com.wjw.service.impl;

import com.wjw.mapper.MenuMapper;
import com.wjw.pojo.Menu;
import com.wjw.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wjw
 * @Date: 2021/8/9 16:29
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;
    
    /**
     * 查询用户权限菜单
     * @param roleId 角色id
     * @return list
     */
    @Override
    public List<Menu> getMenuByRoleId(Integer roleId) {
        // 先查询一级菜单
        List<Menu> menus = menuMapper.selectMenuByRoleId(roleId, 0);

        // 遍历一级菜单，查询二级菜单
        for (Menu menu : menus) {
            // 获取一级菜单id
            Integer mid = menu.getId();
            // 查询二级菜单
            List<Menu> secondMenus = menuMapper.selectMenuByRoleId(roleId, mid);
            // 将二级菜单装入一级菜单
            menu.setChildren(secondMenus);
        }
        return menus;
    }

    /**
     * 查询所有菜单
     * @return list
     */
    @Override
    public List<Menu> getAllMenu() {
        // 查询一级菜单
        List<Menu> oneMenus = menuMapper.selectAllMenu(0);

        // 遍历一级菜单，查询二级菜单
        for (Menu menu : oneMenus) {
            List<Menu> secondMenus = menuMapper.selectAllMenu(menu.getId());
            menu.setChildren(secondMenus);
        }

        return oneMenus;
    }

    /**
     * 根据id查询菜单
     * @param id id
     * @return menu
     */
    @Override
    public Menu getMenuById(Integer id) {
        return menuMapper.selectMenuById(id);
    }
}
