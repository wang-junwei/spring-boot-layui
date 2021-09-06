package com.wjw.controller;

import com.wjw.pojo.Menu;
import com.wjw.pojo.User;
import com.wjw.service.MenuService;
import com.wjw.service.UserService;
import com.wjw.utils.MD5Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wjw
 * @Date: 2021/8/8 16:21
 */
@Controller
public class LoginController {
    @Resource
    private UserService userServiceImpl;

    @Resource
    private MenuService menuServiceImpl;

    /**
     * 登录页面
     *
     * @return 登录页
     */
    @GetMapping({"/login", "/"})
    public String loginPage() {
        return "login";
    }

    /**
     * 登录
     * @param userName 用户名
     * @param password 密码
     * @param remember 记住密码
     * @param request 请求
     * @param response 相应
     * @return map
     */
    @PostMapping("/doLogin")
    @ResponseBody
    public Map<String, Object> doLogin(String userName, String password, String remember, HttpServletRequest request,
                                       HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>(16);

        // 查询用户
        User user = userServiceImpl.getUserByUserName(userName);

        if (user != null) {
            // 验证密码
            String md5pwd = user.getPassword();
            boolean saltVerifyMd5 = MD5Utils.getSaltverifyMD5(password, md5pwd);

            if (saltVerifyMd5) {
                // 获取session，将用户信息保存到session
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                Cookie cookie1 = new Cookie("userName", userName);
                Cookie cookie2 = new Cookie("password", password);
                Cookie cookie3 = new Cookie("remember", remember);

                cookie1.setPath("/");
                cookie2.setPath("/");

                String rem = "yes";
                if (rem.equals(remember)) {
                    cookie1.setMaxAge(30 * 60 * 24);
                    cookie2.setMaxAge(30 * 60 * 24);
                    cookie3.setMaxAge(30 * 60 * 24);
                } else {
                    cookie1.setMaxAge(0);
                    cookie2.setMaxAge(0);
                    cookie3.setMaxAge(0);
                }

                response.addCookie(cookie1);
                response.addCookie(cookie2);
                response.addCookie(cookie3);

                map.put("code", "200");
                map.put("msg", "success");
                map.put("url", "/index");
                return map;
            }

        }

        map.put("code", "500");
        map.put("msg", "用户名或密码错误");
        map.put("url", "/login");

        return map;
    }

    /**
     * 主页面
     * @return index
     */
    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // 查询用户权限菜单
        List<Menu> menus = menuServiceImpl.getMenuByRoleId(user.getRoleId());

        // 没有菜单权限
        if (menus.size() == 0) {
            return "403";
        }

        request.setAttribute("menus", menus);
        return "/views/index";
    }

    /**
     * 注销登录
     * @param request 请求
     * @return login
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        // 获取session
        HttpSession session = request.getSession();
        // 销毁session
        session.invalidate();
        // 跳转到登录页
        return "redirect:/login";
    }
}
