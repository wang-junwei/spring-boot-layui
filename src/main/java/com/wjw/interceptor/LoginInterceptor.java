package com.wjw.interceptor;

import com.wjw.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * @Author: wjw
 * @Date: 2021/8/7 21:10
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取session中用户
        User user = (User) request.getSession().getAttribute("user");

        // 如果用户不为空，说明用户已登录，放行
        if (user != null) {
            return true;
        } else { // 否则，跳转到登录页面
            String head = "x-requested-with";
            // 判断是否为ajax请求，如果是ajax请求，将session状态置为
            if (request.getHeader(head) != null && "XMLHttpRequest".equals(request.getHeader(head))) {
                response.setHeader("sessionStatus", "timeout");
                return false;
            }
            response.sendRedirect("/login");
            return false;
        }
    }
}
