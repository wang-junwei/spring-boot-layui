package com.wjw.controller;

import com.wjw.commons.ResultJson;
import com.wjw.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author: wjw
 * @Date: 2021/8/6 9:59
 */
@Controller
public class PageController {
    @Resource
    private UserService userServiceImpl;

    @GetMapping("/403")
    public String noPermission() {
        return "403";
    }

    /**
     * 主页2
     * @return index2页面
     */
    @GetMapping("/index2")
    public String index2() {
        return "/views/index2";
    }

    /**
     * 插入用户
     * @return bool
     */
    @GetMapping("/insUser")
    @ResponseBody
    public Boolean insUser() {

        return true;
    }
}
