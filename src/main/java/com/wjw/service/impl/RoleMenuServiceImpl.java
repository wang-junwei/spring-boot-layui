package com.wjw.service.impl;

import com.wjw.mapper.RoleMenuMapper;
import com.wjw.pojo.Menu;
import com.wjw.pojo.RoleMenu;
import com.wjw.service.RoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wjw
 * @Date: 2021/8/11 16:32
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    @Resource
    private RoleMenuMapper roleMenuMapper;

    /**
     * 查询用户有权限的二级菜单
     * @param roleId 角色id
     * @return list
     */
    @Override
    public List<Menu> getSecondMenuByUser(String roleId) {
        return roleMenuMapper.selectSecondMenuByUser(roleId);
    }

    /**
     * 删除角色权限
     * @param roleId 角色id
     * @return int
     */
    @Override
    public Integer delRoleMenuByRoleId(Integer roleId) {
        return roleMenuMapper.deleteRoleMenuByRoleId(roleId);
    }

    /**
     * 插入权限
     * @param roleMenuList 角色-权限list
     * @return int
     */
    @Override
    public Integer addRoleMenu(List<RoleMenu> roleMenuList) {
        return roleMenuMapper.insertRoleMenu(roleMenuList);
    }

    /**
     * 查询权限表中是否已存在数据
     * @param roleId 角色id
     * @return int
     */
    @Override
    public Integer getPermissionByRoleId(Integer roleId) {
        return roleMenuMapper.selectPermissionByRoleId(roleId);
    }
}
