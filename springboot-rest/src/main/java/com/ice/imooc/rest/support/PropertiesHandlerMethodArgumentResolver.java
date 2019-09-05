package com.ice.imooc.rest.support;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * {@link Properties 类型} 实现 {@link HandlerMethodArgumentResolver}
 *
 * @author : ACE
 * @date : 2019/9/5
 */
public class PropertiesHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Properties.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = ((ServletWebRequest) webRequest).getRequest();
        // 字节流
        InputStream inputStream = request.getInputStream();
        // 字节流 -> 字符流
        MediaType mediaType = MediaType.parseMediaType(request.getHeader(HttpHeaders.CONTENT_TYPE));
        Charset charset = mediaType.getCharset();
        charset = charset == null ? Charset.forName("UTF-8") : charset;

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        Properties properties = new Properties();
        properties.load(inputStreamReader);
        return properties;
    }
}
