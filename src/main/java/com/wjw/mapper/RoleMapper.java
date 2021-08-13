package com.wjw.mapper;

import com.wjw.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: wjw
 * @Date: 2021/8/11 8:50
 */
@Mapper
public interface RoleMapper {

    /**
     * 查询角色
     * @param roleName 角色名
     * @return list
     */
    List<Role> selectAllRole(@Param("roleName") String roleName);
}
