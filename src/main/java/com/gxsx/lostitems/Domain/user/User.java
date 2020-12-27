package com.gxsx.lostitems.Domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gxsx.lostitems.Domain.board.Board;
import com.gxsx.lostitems.Domain.comment.Comment;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name ="user")
@Data
public class User {
    @Id
    @Column(name="userid" ,length = 30,nullable = false)
    private String userid;

    @Column(length = 30, nullable = false)
    private String pwd;

    @Column(length = 30,nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String email;

    @Column(length = 30, nullable = false)
    private String phone;

    public User(String userid, String pwd, String name, String email, String phone) {
        this.userid = userid;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
