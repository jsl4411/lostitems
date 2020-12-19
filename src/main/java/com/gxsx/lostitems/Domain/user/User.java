package com.gxsx.lostitems.Domain.user;

import com.gxsx.lostitems.Domain.board.Board;
import com.gxsx.lostitems.Domain.comment.Comment;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name ="user")

public class User {
    @Id
    @Column(name = "userid",length = 30,nullable = false)
    private String id;

    @Column(length = 30, nullable = false)
    private String pwd;

    @Column(length = 30,nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String email;

    @Column(length = 30, nullable = false)
    private String phone;

    @OneToMany(mappedBy = "user",targetEntity = Board.class)
    private List<Board> boards = new ArrayList<Board>();
    @OneToMany(mappedBy = "user",targetEntity = Comment.class)
    private List<Comment> comments = new ArrayList<Comment>();
}
