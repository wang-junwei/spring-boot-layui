package com.wjw.config;

import com.wjw.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: wjw
 * @Date: 2021/8/7 21:13
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置拦截路径以及放行路径，放行静态资源及登录路径
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/static/**", "/login", "/doLogin", "/user/registerPage", "/user/register",
                        "/logout", "/getMenu");
    }
}