package com.wjw.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjw.commons.ResultJson;
import com.wjw.mapper.RoleMapper;
import com.wjw.pojo.Role;
import com.wjw.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wjw
 * @Date: 2021/8/11 8:54
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    /**
     * 查询角色
     * @param roleName 角色名
     * @param page 页码
     * @param limit 条数
     * @return resultJson
     */
    @Override
    public ResultJson getAllRole(String roleName, Integer page, Integer limit) {
        // 开启分页
        PageHelper.startPage(page, limit);
        // 查询角色信息
        List<Role> roles = roleMapper.selectAllRole(roleName);
        // 创建分页对象
        PageInfo<Role> pageInfo = new PageInfo<Role>(roles);
        // 获取当前页对象
        List<Role> data = pageInfo.getList();
        // 创建返回对象
        ResultJson resultJson = new ResultJson();
        resultJson.setCode("0");
        resultJson.setMsg("success");
        resultJson.setCount((int) pageInfo.getTotal());
        resultJson.setData(data);

        return resultJson;
    }
}
