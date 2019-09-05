package com.ice.imooc.rest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorld {@link RestController}
 *
 * @author : ACE
 * @date : 2019/9/4
 */
@RestController
public class HelloWorldRestController {

    @GetMapping(value = "/hello-world")
    public String helloWorld(@RequestParam(required = false) String message) {
        return "Hello: " + message;
    }

    //@CrossOrigin("*")
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
