package com.ice.imooc.rest.controller;

import com.ice.imooc.rest.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * User {@link RestController}
 *
 * @author : ACE
 * @date : 2019/9/5
 */
@RestController
public class UserRestController {

    @PostMapping(value = "/echo/user", produces = "application/json;charset=UTF-8",
            consumes = "application/json")
    public User user(@RequestBody User user) {
        return user;
    }
}
