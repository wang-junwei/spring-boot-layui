package com.wjw.controller;

import com.wjw.commons.ResultJson;
import com.wjw.pojo.User;
import com.wjw.service.UserService;
import com.wjw.utils.MD5Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Author: wjw
 * @Date: 2021/8/8 15:54
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userServiceImpl;

    @GetMapping("/registerPage")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public Map<String, Object> register(User user) {
        Map<String, Object> map = new HashMap<>(16);
        // 校验重复用户
        Integer repeatUser = userServiceImpl.getRepeatUser(user.getUserName(), user.getId());
        if (repeatUser > 0) {
            map.put("code", "100");
            map.put("msg", "用户名已存在");
            return map;
        }

        // 校验密码复杂度
        String regex = "^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9_\\W]{8,14}$";
        if (!Pattern.matches(regex, user.getPassword())) {
            map.put("code", "300");
            map.put("msg", "密码必须包含大小写字母、数字、特殊字符或下划线，且长度不能小于8位");
            return map;
        }

        // 校验联系方式
        String phoneRegex = "^(?:(?:\\+|00)86)?1(?:(?:3[\\d])|(?:4[5-7|9])|(?:5[0-3|5-9])|(?:6[5-7])|(?:7[0-8])|(?:8[\\d])|(?:9[1|8|9]))\\d{8}$";
        String phoneRegex2 = "^\\d{3}-\\d{8}$|^\\d{4}-\\d{7}$";

        if (!Pattern.matches(phoneRegex, user.getPhone()) && !Pattern.matches(phoneRegex2, user.getPhone())) {
            map.put("code", "500");
            map.put("msg", "联系方式不符合规范");
            return map;
        }
        
        // 密码加密
        String saltPwd = MD5Utils.getSaltMD5(user.getPassword());
        user.setPassword(saltPwd);
        // 设置用户权限
        user.setRoleId(-1);

        Integer registerUser = userServiceImpl.insUser(user);

        if (registerUser > 0) {
            map.put("code", "200");
            map.put("msg", "注册成功");
        } else {
            map.put("code", "400");
            map.put("msg", "注册失败");
        }
        return map;

    }

    /**
     * 获取用户页面
     * @return 用户页面
     */
    @GetMapping("/userManager")
    public String user() {
        return "/views/user";
    }

    /**
     * 获取用户
     * @return 用户
     */
    @PostMapping("/getUser")
    @ResponseBody
    public ResultJson getUser(String userName, String realName,@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "20") Integer limit) {

        return userServiceImpl.getUser(userName, realName, page, limit);
    }
}
