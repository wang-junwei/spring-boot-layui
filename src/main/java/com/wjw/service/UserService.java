package com.wjw.service;

import com.wjw.commons.ResultJson;
import com.wjw.pojo.User;

/**
 * @Author: wjw
 * @Date: 2021/8/6 16:01
 */
public interface UserService {

    /**
     * 用户注册
     * @param user 用户对象
     * @return int
     */
    int registerUser(User user);

    /**
     * 获取用户
     * @param userName 用户名
     * @param realName 姓名
     * @param page 页码
     * @param pageSize 条数
     * @return list
     */
    ResultJson getUser(String userName, String realName, Integer page, Integer pageSize);

    /**
     * 用户查重
     * @param userName 用户名
     * @param id 用户id
     * @return int
     */
    Integer getRepeatUser(String userName, Integer id);

    /**
     * 从插入用户
     * @param user 插入用户
     * @return int
     */
    Integer insUser(User user);

    /**
     * 用户登录查询
     * @param userName 用户名
     * @return 用户
     */
    User getUserByUserName(String userName);
}
