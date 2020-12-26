package com.gxsx.lostitems.Domain.board;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gxsx.lostitems.Domain.comment.Comment;
import com.gxsx.lostitems.Domain.user.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Data
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="seq")
    List<Comment> comments = new ArrayList<Comment>();

}
