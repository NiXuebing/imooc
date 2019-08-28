package com.ice.imooc.annotation;

import com.ice.imooc.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;
/**
 * 激活 HelloWorld 模块
 *
 * @author : ACE
 * @date : 2019/8/28
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HelloWorldConfiguration.class)
public @interface EnableHelloWorld {
}
