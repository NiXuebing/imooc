package com.ice.imooc.rest.method.support;

import com.ice.imooc.rest.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
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
        PropertiesHttpMessageConverter converter = new PropertiesHttpMessageConverter();

        HttpServletRequest request = ((ServletWebRequest) webRequest).getRequest();
        HttpInputMessage httpInputMessage = new ServletServerHttpRequest(request);
        return converter.read(Properties.class, httpInputMessage);
    }
}
