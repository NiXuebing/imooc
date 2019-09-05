package com.ice.imooc.rest.method.support;

import com.ice.imooc.rest.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

/**
 * {@link Properties} {@link HandlerMethodReturnValueHandler} 实现
 *
 * @author : ACE
 * @date : 2019/9/5
 */
public class PropertiesHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return Properties.class.equals(returnType.getMethod().getReturnType());
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType,
                                  ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {

        Properties properties = (Properties) returnValue;
        PropertiesHttpMessageConverter converter = new PropertiesHttpMessageConverter();

        ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;

        HttpServletRequest request = servletWebRequest.getRequest();
        MediaType mediaType = MediaType.parseMediaType(request.getHeader(HttpHeaders.CONTENT_TYPE));

        HttpServletResponse response = servletWebRequest.getResponse();
        HttpOutputMessage httpOutputMessage = new ServletServerHttpResponse(response);
        converter.write(properties, mediaType, httpOutputMessage);

        // 告知 SpringMVC 请求已处理完毕
        mavContainer.setRequestHandled(true);
    }
}
