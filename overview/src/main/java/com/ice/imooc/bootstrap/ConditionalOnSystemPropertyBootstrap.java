package com.ice.imooc.bootstrap;

import com.ice.imooc.conditional.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 系统属性条件引导类
 *
 * @author : ACE
 * @date : 2019/8/29
 */
public class ConditionalOnSystemPropertyBootstrap {

    @Bean
    @ConditionalOnSystemProperty(name = "user.name", value = "Administrator")
    public String helloWorld() {
        return "Hello World ICE.";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloWorld = context.getBean("helloWorld", String.class);

        System.out.println(helloWorld);

        context.close();
    }

}
