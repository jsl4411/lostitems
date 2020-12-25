package com.gxsx.lostitems.Domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;


    @Override
    public String findUserByUserid(User loginUser) {
        User userData = userRepository.findUserByUserid(loginUser.getUserid());
        if(userData == null){
            return "fail";
        }
        if(loginUser.getPwd().equals(userData.getPwd())){
            return "success";
        }

        return "fail";
    }

    @Override
    public String createUser(User signipUser) {

        User userData = userRepository.findUserByUserid(signipUser.getUserid());
        if(userData != null){
            return "fail";
        }
        userRepository.save(signipUser);

        return "success";
    }

}
