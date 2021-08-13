package com.wjw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wjw
 */
@SpringBootApplication
@MapperScan("com.wjw.mapper")
public class SpringBootLayuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLayuiApplication.class, args);
    }

}
