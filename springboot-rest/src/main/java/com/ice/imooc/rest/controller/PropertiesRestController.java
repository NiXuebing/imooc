package com.ice.imooc.rest.controller;

import com.ice.imooc.rest.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * Properties {@link RestController}
 *
 * @author : ACE
 * @date : 2019/9/5
 */
//@RestController
@Controller
public class PropertiesRestController {

    @PostMapping(value = "/add/pops",
            consumes = "text/properties;charset=UTF-8"
            )
    public Properties addProperties(
                    //@RequestBody
                    Properties properties) {
        return properties;
    }
}
