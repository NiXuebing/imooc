package com.ice.imooc.web.servlet.support;

import com.ice.imooc.web.configuration.DispatcherServletConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * Spring Web MVC 自动装配 默认实现
 *
 * @author : ACE
 * @date : 2019/9/2
 */
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
        return new Class[]{DispatcherServletConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
