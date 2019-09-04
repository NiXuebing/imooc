package com.ice.imooc.web.config;

import org.springframework.boot.autoconfigure.websocket.servlet.TomcatWebSocketServletWebServerCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.io.File;

/**
 * Web MVC 配置类
 *
 * @author : ACE
 * @date : 2019/9/3
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver myViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setOrder(Ordered.LOWEST_PRECEDENCE - 10);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setContentType("text/xml;charset=UTF-8");
        return viewResolver;
    }


    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer() {
        return ((factory) ->
                factory.addContextCustomizers((context) -> {
                    File docBaseFile = new File("springboot-view/src/main/webapp");
                    if (docBaseFile.exists()) {
                        context.setDocBase(docBaseFile.getAbsolutePath());
                    }
                })
        );
    }


    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(true)
                .favorPathExtension(true);
    }
}
