package com.wjw.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjw.commons.ResultJson;
import com.wjw.mapper.UserMapper;
import com.wjw.pojo.User;
import com.wjw.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wjw
 * @Date: 2021/8/6 16:02
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 用户注册
     * @param user 用户对象
     * @return int
     */
    @Override
    public int registerUser(User user) {
        return userMapper.insUser(user);
    }

    /**
     * 分页查询用户
     * @param userName 用户名
     * @param realName 姓名
     * @param page 页码
     * @param pageSize 条数
     * @return resultJson
     */
    @Override
    public ResultJson getUser(String userName, String realName, Integer page, Integer pageSize) {
        // 开启分页
        PageHelper.startPage(page, pageSize);
        // 查询用户
        List<User> users = userMapper.getUser(userName, realName);
        // 创建分页对象
        PageInfo<User> pageInfo = new PageInfo<>(users);
        // 获取数据总数
        long count = pageInfo.getTotal();
        // 获取当前页数据
        List<User> list = pageInfo.getList();
        // 创建返回对象
        ResultJson resultJson = new ResultJson();
        // 设置返回信息
        resultJson.setMsg("success");
        // 总条数
        resultJson.setCount((int) count);
        // 返回码
        resultJson.setCode("0");
        // 当页用户信息
        resultJson.setData(list);
        return resultJson;
    }

    /**
     * 用户查重
     * @param userName 用户名
     * @param id 用户id
     * @return int
     */
    @Override
    public Integer getRepeatUser(String userName, Integer id) {
        return userMapper.selectRepeatUser(userName, id);
    }

    /**
     * 插入用户
     * @param user 用户
     * @return int
     */
    @Override
    public Integer insUser(User user) {
        return userMapper.insUser(user);
    }

    /**
     * 用户登录查询
     * @param userName 用户名
     * @return 用户
     */
    @Override
    public User getUserByUserName(String userName) {
        return userMapper.selectUserByUserName(userName);
    }
}
