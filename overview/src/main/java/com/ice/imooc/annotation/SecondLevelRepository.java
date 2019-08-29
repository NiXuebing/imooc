package com.ice.imooc.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * 二级 {@link Repository}
 *
 * @author : ACE
 * @date : 2019/8/28
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@FirstLevelRepository
public @interface SecondLevelRepository {

    String value() default "";
}
