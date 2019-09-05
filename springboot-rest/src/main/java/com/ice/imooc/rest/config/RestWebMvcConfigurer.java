package com.ice.imooc.rest.config;

import com.ice.imooc.rest.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Rest {@link WebMvcConfigurer}
 *
 * @author : ACE
 * @date : 2019/9/5
 */
@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        //converters.add(new PropertiesHttpMessageConverter());
        // 添加至首位
        converters.set(0, new PropertiesHttpMessageConverter());
    }
}
