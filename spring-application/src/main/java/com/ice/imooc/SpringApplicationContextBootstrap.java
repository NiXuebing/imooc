package com.ice.imooc;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring 应用上下文 引导类
 *
 * @author : ACE
 * @date : 2019/9/1
 */
@SpringBootApplication
public class SpringApplicationContextBootstrap {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringApplicationContextBootstrap.class)
                //.web(WebApplicationType.NONE)
                .run(args);

        System.out.println("ConfigurableApplicationContext 类型:" + context.getClass().getName());
        context.close();



    }
}
