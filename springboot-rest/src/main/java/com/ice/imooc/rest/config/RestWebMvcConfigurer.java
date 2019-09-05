package com.ice.imooc.rest.config;

import com.ice.imooc.rest.http.converter.properties.PropertiesHttpMessageConverter;
import com.ice.imooc.rest.method.support.PropertiesHandlerMethodArgumentResolver;
import com.ice.imooc.rest.method.support.PropertiesHandlerMethodReturnValueHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Rest {@link WebMvcConfigurer}
 *
 * @author : ACE
 * @date : 2019/9/5
 */
@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;


    @PostConstruct
    public void init() {
        List<HandlerMethodArgumentResolver> resolverList = requestMappingHandlerAdapter.getArgumentResolvers();
        List<HandlerMethodArgumentResolver> newResolvers = new ArrayList<>(resolverList.size() + 1);
        newResolvers.add(new PropertiesHandlerMethodArgumentResolver());
        newResolvers.addAll(resolverList);
        requestMappingHandlerAdapter.setArgumentResolvers(newResolvers);



        List<HandlerMethodReturnValueHandler> handlers = requestMappingHandlerAdapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> newHandlers = new ArrayList<>(handlers.size() + 1);
        newHandlers.add(new PropertiesHandlerMethodReturnValueHandler());
        newHandlers.addAll(handlers);
        requestMappingHandlerAdapter.setReturnValueHandlers(newHandlers);


    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        // 添加至首位无效，自定义的 HandlerMethodArgument 优先级低于内建 HandlerMethodArgument
//        if (resolvers.isEmpty()) {
//            resolvers.add(new PropertiesHandlerMethodArgumentResolver());
//        } else {
//            resolvers.set(0, new PropertiesHandlerMethodArgumentResolver());
//        }
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        //converters.add(new PropertiesHttpMessageConverter());
        // 添加至首位
        converters.set(0, new PropertiesHttpMessageConverter());
    }
}
