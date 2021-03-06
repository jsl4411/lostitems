package com.gxsx.lostitems.Domain.comment;

import com.gxsx.lostitems.Domain.board.BoardRepository;
import com.gxsx.lostitems.Domain.user.User;
import com.gxsx.lostitems.Domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BoardRepository boardRepository;

    @Override
    public List<Comment> findAll() {
        List<Comment>comments = new ArrayList<Comment>();

        return commentRepository.findAll();
    }

    @Override
    public List<Comment> findBySeq(long seq) {


        return commentRepository.findBySeq(seq);
    }

    @Override
    public String write(CommentVO comment, String userid) {
        System.out.println("in comment write service");
        Optional<User> user = Optional.ofNullable(userRepository.findUserByUserid(userid));
        Comment comment1 = new Comment();
        comment1.setUser(user.get());
        comment1.setContent(comment.content);
        comment1.setSeq(comment.board_seq);
        comment1.setDate(new Date());

        commentRepository.save(comment1);

        return "success";
    }

    @Override
    public String delete(Long comment_seq) {
        commentRepository.deleteById(comment_seq);

        return "success";
    }

    @Override
    public String update(Comment comment, String userid) {
        Optional<User> user = Optional.ofNullable(userRepository.findUserByUserid(userid));
        Comment comment1 = new Comment();
        comment1.setSeq(comment.getSeq());
        comment1.setDate(comment.getDate());
        comment1.setComment_seq(comment.getComment_seq());
        comment1.setContent(comment.getContent());
        comment1.setUser(user.get());

        System.out.println("@@@@serviceCommentEdit"+ comment1);
        commentRepository.save(comment1);

        return "success";
    }

}
