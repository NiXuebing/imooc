package com.ice.imooc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HelloWorld {@link Controller}
 *
 * @author : ACE
 * @date : 2019/9/3
 */
@Controller
public class HelloWorldController {

    @RequestMapping("")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello-world";
    }

    @ModelAttribute("message")
    public String message() {
        return "HelloWorld";
    }
}
