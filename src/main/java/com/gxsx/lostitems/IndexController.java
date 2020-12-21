package com.gxsx.lostitems;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping(value = "/")
    public String main(){
        return "main/domain";
    }
    @RequestMapping(value = "/login")
    public String login(){
        return "main/login";
    }

}