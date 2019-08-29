package com.ice.imooc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * HelloWorld 配置
 *
 * @author : ACE
 * @date : 2019/8/28
 */
//@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld() {
        return "hello world";
    }
}
