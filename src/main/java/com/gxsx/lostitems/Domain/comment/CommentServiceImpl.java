package com.gxsx.lostitems.Domain.comment;

import com.gxsx.lostitems.Domain.board.Board;
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
    public Comment findBySeq(long seq) {
        return commentRepository.findById(seq).orElse(null);
    }

    @Override
    public String write(CommentVO comment) {
        System.out.println("in comment write service");
        Optional<User> user = Optional.ofNullable(userRepository.findUserByUserid(comment.userid));
        Optional<Board> board = boardRepository.findById(comment.board_seq);
        Comment comment1 = new Comment();
        comment1.setUser(user.get());
        comment1.setContent(comment.content);
        comment1.setBoard(board.get());
        comment1.setDate(comment.date);

        commentRepository.save(comment1);

        return "success";
    }

    @Override
    public String delete(Long comment_seq) {
        commentRepository.deleteById(comment_seq);

        return "success";
    }
}
