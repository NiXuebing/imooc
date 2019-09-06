package com.ice.imooc.spring.servlet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * HelloWorld 异步 {@link RestController}
 *
 * @author : ACE
 * @date : 2019/9/6
 */
@RestController
public class HelloWorldAsyncController {

    @GetMapping("/hello-world")
    public DeferredResult<String> helloWorld() {

        DeferredResult<String> result = new DeferredResult<>(50L);
       // result.setResult("Hello, World");

        println("Hello, World");
        result.onCompletion(() -> {
           println("执行结束");
        });

        result.onTimeout(() -> {
            println("执行超时");
        });
        return result;
    }

    private static void println(Object object) {
        System.out.println("HelloWorldAsyncController[" + Thread.currentThread().getName() + "]: " + object);
    }
}
