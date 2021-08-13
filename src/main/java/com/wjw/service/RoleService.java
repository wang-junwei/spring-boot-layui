package com.wjw.service;

import com.wjw.commons.ResultJson;

/**
 * @Author: wjw
 * @Date: 2021/8/11 8:53
 */
public interface RoleService {

    /**
     * 查询角色
     * @param roleName 角色名
     * @param page 页码
     * @param limit 条数
     * @return resultJson
     */
    ResultJson getAllRole(String roleName, Integer page, Integer limit);
}
