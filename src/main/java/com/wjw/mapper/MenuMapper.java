package com.wjw.mapper;

import com.wjw.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: wjw
 * @Date: 2021/8/9 16:00
 */
@Mapper
public interface MenuMapper {

    /**
     * 查询用户权限菜单
     * @param roleId 角色id
     * @param pid 菜单父id
     * @return list
     */
    List<Menu> selectMenuByRoleId(@Param("roleId") Integer roleId, @Param("pid") Integer pid);

    /**
     * 查询所有菜单
     * @param pid 父id
     * @return list
     */
    List<Menu> selectAllMenu( Integer pid);

    /**
     * 根据id查询菜单
     * @param id id
     * @return menu
     */
    Menu selectMenuById(@Param("id") Integer id);
}
