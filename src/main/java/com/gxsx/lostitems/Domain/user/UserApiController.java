package com.gxsx.lostitems.Domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "user/api")
public class UserApiController {
    @Autowired //
    UserService userService;

    @PostMapping(value = "/login")
    public String login(@RequestBody User user, HttpSession session,
                        HttpServletRequest request, HttpServletResponse response){

        session = request.getSession();
        session.setAttribute("loginUser", user.getUserid());

        return userService.findUserByUserid(user);
    }


    @RequestMapping(value = "/signup")
    public String signUp(User user){

        return userService.createUser(user);
    }
}
