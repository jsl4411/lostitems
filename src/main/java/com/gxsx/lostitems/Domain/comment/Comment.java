package com.gxsx.lostitems.Domain.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gxsx.lostitems.Domain.board.Board;
import com.gxsx.lostitems.Domain.user.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Entity
@Data
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long comment_seq;

    @Column(name="seq",nullable = false)
    private Long seq;

    @ManyToOne
    @JoinColumn(name = "userid",nullable = false)
    private User user;

    @Temporal(TemporalType.DATE)
    Date date;

    @Column(length = 200, nullable = false)
    private String content;

}
