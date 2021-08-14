package com.wjw.mapper;

import com.wjw.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: wjw
 * @Date: 2021/8/6 15:51
 */
@Mapper
public interface UserMapper {
    /**
     * 获取用户
     * @param uerName 用户名
     * @param realName 姓名
     * @return List
     */
    List<User> getUser(@Param("userName") String uerName, @Param("realName") String realName);

    /**
     * 插入用户
     * @param user 用户对象
     * @return int
     */
    Integer insUser(User user);

    /**
     * 用户查重
     * @param userName 用户名
     * @param id 用户id
     * @return int
     */
    Integer selectRepeatUser(@Param("userName") String userName, @Param("id") Integer id);

    /**
     * 用户登录查询
     * @param userName 用户名
     * @return 用户
     */
    User selectUserByUserName(@Param("userName") String userName);
}
