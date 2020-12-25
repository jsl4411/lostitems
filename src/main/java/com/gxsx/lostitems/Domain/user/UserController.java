package com.gxsx.lostitems.Domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login")
    public String login(){
        return "main/login";
    }
    @RequestMapping(value = "/signup")
    public String signUp(){
        return "main/signup";
    }


}
