package com.ice.imooc.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link EnableAutoConfiguration} 引导类
 *
 * @author : ACE
 * @date : 2019/8/29
 */
@EnableAutoConfiguration
public class EnableAutoConfigurationBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloWorld = context.getBean("helloWorld", String.class);

        System.out.println("helloWorld Bean: " + helloWorld);

        context.close();
    }
}
