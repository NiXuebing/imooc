package com.ice.imooc.spring.servlet.support;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Spring Web MVC 自动装配 默认实现
 *
 * @author : ACE
 * @date : 2019/9/2
 */
@ComponentScan(basePackages = "com.ice.imooc.spring.servlet.controller")
public class DefaultAnnotationConfigDispatcherServletInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // web.xml
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // DispatcherServlet
        return new Class[]{getClass()};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
