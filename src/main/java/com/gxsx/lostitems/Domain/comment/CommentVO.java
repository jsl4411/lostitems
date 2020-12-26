package com.gxsx.lostitems.Domain.comment;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentVO {
    String content;
    Long comment_seq;
    Date date;
    Long board_seq;
    String userid;
}
