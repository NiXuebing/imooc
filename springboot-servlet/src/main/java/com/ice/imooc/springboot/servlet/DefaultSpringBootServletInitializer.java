package com.ice.imooc.springboot.servlet;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * {@link SpringBootServletInitializer} 默认实现
 *
 * @author : ACE
 * @date : 2019/9/7
 */
public class DefaultSpringBootServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        builder.sources(SpringBootServletBootstrap.class);
        return builder;
    }
}
