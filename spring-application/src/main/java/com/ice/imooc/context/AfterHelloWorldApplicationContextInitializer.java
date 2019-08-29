package com.ice.imooc.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * After HelloWorldApplicationContextInitializer
 *
 * @author : ACE
 * @date : 2019/8/29
 */
public class AfterHelloWorldApplicationContextInitializer<C extends ConfigurableApplicationContext> implements ApplicationContextInitializer<C>, Ordered {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        System.out.println("AfterApplicationContext.id = " + applicationContext.getId());
    }


    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
