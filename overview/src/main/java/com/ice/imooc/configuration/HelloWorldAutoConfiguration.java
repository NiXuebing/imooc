package com.ice.imooc.configuration;

import com.ice.imooc.annotation.EnableHelloWorld;
import com.ice.imooc.conditional.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * HelloWorld 自动装配
 *
 * @author : ACE
 * @date : 2019/8/29
 */
@Configuration //Spring 模式注解
@EnableHelloWorld //Spring @Enable 模块装配
@ConditionalOnSystemProperty(name = "user.name", value = "Administrator") //条件装配
public class HelloWorldAutoConfiguration {
}
