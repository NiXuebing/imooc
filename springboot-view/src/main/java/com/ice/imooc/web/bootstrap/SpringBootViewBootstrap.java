package com.ice.imooc.web.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot 视图引导类
 *
 * @author : ACE
 * @date : 2019/9/3
 */
@SpringBootApplication(scanBasePackages = "com.ice.imooc.web")
public class SpringBootViewBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootViewBootstrap.class, args);
    }
}
