package com.quaiantique.quaiantique.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping(value = "/user")
public class UserController {
    

    @RequestMapping(method=RequestMethod.GET)
    public String getUser() {
        return "coucou";
    }
}
