package com.ice.imooc.web.template;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * Thymeleaf 模板引擎 引导类
 *
 * @author : ACE
 * @date : 2019/9/3
 */
public class ThymeleafTemplateEngineBootstrap {

    public static void main(String[] args) throws IOException {
        //构建引擎
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        // 创建渲染上下文
        Context context = new Context();
        context.setVariable("message", "Hello World");

        //模板的内容
        //String content = "<p th:text=\"${message}\">!!!</p>";
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:/templates/thymeleaf/hello-world.html");
        File templateFile = resource.getFile();
        FileInputStream inputStream = new FileInputStream(templateFile);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOUtils.copy(inputStream, outputStream);
        String content = outputStream.toString("UTF-8");
        inputStream.close();

        //渲染结果
        String  result = templateEngine.process(content, context);

        System.out.println(result);

    }
}
