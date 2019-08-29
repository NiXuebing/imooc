package com.ice.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.CollectionUtils;

import java.util.Collections;

/**
 * {@link SpringApplication} 引导类
 *
 * @author : ACE
 * @date : 2019/8/29
 */

public class SpringApplicationBootstrap {

    public static void main(String[] args) {
        //SpringApplication.run(ApplicationConfiguration.class, args);
        SpringApplication springApplication = new SpringApplication();
        //springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.setSources(Collections.singleton(ApplicationConfiguration.class.getName()));
        ConfigurableApplicationContext context = springApplication.run(args);

        System.out.println("Main Bean: " + context.getBean(ApplicationConfiguration.class));
    }

    @SpringBootApplication
    public static class ApplicationConfiguration {

    }
}
