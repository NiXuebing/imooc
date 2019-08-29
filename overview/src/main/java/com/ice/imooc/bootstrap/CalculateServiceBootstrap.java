package com.ice.imooc.bootstrap;

import com.ice.imooc.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link CalculateService} 引导类
 *
 * @author : ACE
 * @date : 2019/8/29
 */
@SpringBootApplication(scanBasePackages = "com.ice.imooc.service")
public class CalculateServiceBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateServiceBootstrap.class)
                .web(WebApplicationType.NONE)
                .profiles("Java8")
                .run(args);

        CalculateService service = context.getBean(CalculateService.class);

        System.out.println("Calculate 1 ~ 3 = " + service.sum(1, 2, 3));

        context.close();
    }

}
