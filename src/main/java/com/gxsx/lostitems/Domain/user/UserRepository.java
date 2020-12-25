package com.gxsx.lostitems.Domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {
    User findUserByUserid(String userid);
}
