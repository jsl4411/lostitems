package com.gxsx.lostitems.Domain.comment;

import com.gxsx.lostitems.Domain.board.Board;
import com.gxsx.lostitems.Domain.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column(nullable = false)
    private Long comment_seq;

    @ManyToOne
    @JoinColumn(name="seq",nullable = false)
    private Board board;

    @ManyToOne
    @JoinColumn(name = "userid",nullable = false)
    private User user;

    @Temporal(TemporalType.DATE)
    Date date;

    @Column(length = 200, nullable = false)
    private String content;

}