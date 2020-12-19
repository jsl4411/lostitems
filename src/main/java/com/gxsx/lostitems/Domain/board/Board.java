package com.gxsx.lostitems.Domain.board;

import com.gxsx.lostitems.Domain.comment.Comment;
import com.gxsx.lostitems.Domain.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "board")
public class Board {
    @Id
    @Column(nullable = false)
    private Long board_seq;

    @ManyToOne
    @JoinColumn(name="userid", nullable = false)
    private User user;

    @Column(length = 100,nullable = false)
    private String board_sub;

    @Column(length = 200, nullable = false)
    private String content;

    @Temporal(TemporalType.DATE)
    Date date;

    @Column
    private Long ano;

    @Column(length = 100)
    private String place;

    @Column(length = 100)
    private String category;

    @Column(nullable = false)
    private Long board_group;

    @OneToMany(mappedBy = "board",targetEntity = Comment.class)
    private List<Comment> comments = new ArrayList<Comment>();


}
