package com.ice.imooc.bootstrap;

import com.ice.imooc.repository.MyFirstLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 仓储的引导类
 *
 * @author : ACE
 * @date : 2019/8/28
 */
@ComponentScan(basePackages = "com.ice.imooc.repository")
public class RepositoryBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        MyFirstLevelRepository repository = context.getBean("myFirstLevelRepository", MyFirstLevelRepository.class);

        System.out.println("myFirstLevelRepository Bean: " + repository.toString());

        context.close();
    }
}
