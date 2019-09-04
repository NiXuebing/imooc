package com.ice.imooc.rest.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Rest 引导类
 *
 * @author : ACE
 * @date : 2019/9/4
 */
@SpringBootApplication(scanBasePackages = "com.ice.imooc.rest")
public class SpringBootRestBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestBootstrap.class, args);
    }
}
