package com.gxsx.lostitems.Domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user/api")
public class UserApiController {
    @Autowired //
    UserService userService;

    @RequestMapping(value = "/login")
    public String login(User user){

        User user1 = new User();
        user1.setUserid("june");
        user1.setPwd("1234");

        return userService.findUserByUserid(user1);

    }
    @RequestMapping(value = "/signup")
    public String signUp(User user){

        User user1 = new User();
        user1.setUserid("mondaygirl");
        user1.setEmail("1@2");
        user1.setName("jj");
        user1.setPhone("1111");
        user1.setPwd("1234");

        return userService.createUser(user1);

    }
}
