package com.wjw.mapper;

import com.wjw.pojo.Menu;
import com.wjw.pojo.RoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: wjw
 * @Date: 2021/8/11 16:27
 */
public interface RoleMenuMapper {

    /**
     * 查询用户有权限的二级菜单
     * @param roleId 角色id
     * @return list
     */
    List<Menu> selectSecondMenuByUser(String roleId);

    /**
     * 删除角色权限
     * @param roleId 角色id
     * @return int
     */
    Integer deleteRoleMenuByRoleId(@Param("roleId") Integer roleId);

    /**
     * 插入权限
     * @param roleMenuList 角色-权限list
     * @return int
     */
    Integer insertRoleMenu(List<RoleMenu> roleMenuList);

    /**
     * 查询权限表中是否已有数据
     * @param roleId 角色id
     * @return int
     */
    Integer selectPermissionByRoleId(Integer roleId);
}
