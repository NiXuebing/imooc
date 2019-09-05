package com.ice.imooc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * HelloWorld Controller
 *
 * @author : ACE
 * @date : 2019/9/1
 */
@Controller
public class HelloWorldController {


    @RequestMapping("")
    public String index(Model model) {
        return "index";
    }


}
