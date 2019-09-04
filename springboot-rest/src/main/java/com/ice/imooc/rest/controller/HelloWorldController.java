package com.ice.imooc.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorld {@link RestController}
 *
 * @author : ACE
 * @date : 2019/9/4
 */
@RestController
public class HelloWorldController {

    @GetMapping(value = "/hello-world")
    public String helloWorld() {
        return "Hello, World";
    }
}
