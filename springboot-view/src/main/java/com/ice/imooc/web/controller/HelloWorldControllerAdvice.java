package com.ice.imooc.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * HelloWorldControllerAdvice {@link HelloWorldController}
 *
 * @author : ACE
 * @date : 2019/9/2
 */
@ControllerAdvice(assignableTypes = HelloWorldController.class)
public class HelloWorldControllerAdvice {


    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage) {
        return acceptLanguage;
    }

    @ModelAttribute("jsessionId")
    public String jsessionId(@CookieValue(value = "JSESSIONID", required = false) String jsessionId) {
        return jsessionId;
    }

    @ModelAttribute("message")
    public String message() {
        return "Hello World JSP!";
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> onException(Throwable throwable) {
        return ResponseEntity.of(Optional.of(throwable.getMessage()));
    }
}
