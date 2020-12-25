package com.gxsx.lostitems.Domain.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        List<Comment>comments = new ArrayList<Comment>();

        return commentRepository.findAll();
    }

    @Override
    public Comment findBySeq(long seq) {
        return commentRepository.findById(seq).orElse(null);
    }

    @Override
    public String write(Comment comment) {
        commentRepository.save(comment);

        return "success";
    }

    @Override
    public String delete(Long comment_seq) {
        commentRepository.deleteById(comment_seq);

        return "success";
    }
}
