package com.gxsx.lostitems.Domain.comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    Comment findBySeq(long seq);

    String write(CommentVO comment, String userid);

    String delete(Long comment_seq);

}
