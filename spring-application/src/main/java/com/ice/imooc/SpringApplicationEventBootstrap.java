package com.ice.imooc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spirng 应用事件 引导类
 *
 * @author : ACE
 * @date : 2019/8/30
 */
public class SpringApplicationEventBootstrap {

    public static void main(String[] args) {
        //创建上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.addApplicationListener(event -> {
            System.out.println("监听到事件:" + event);
        });


        context.refresh();

        context.publishEvent("HelloWorld");
        context.publishEvent("2018");
        context.publishEvent("ICE");

        context.close();
    }
}
