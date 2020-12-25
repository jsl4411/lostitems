package com.gxsx.lostitems.Domain.comment;

import com.gxsx.lostitems.Domain.board.Board;
import com.gxsx.lostitems.Domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/comment/api")
public class CommentApiController {

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Comment> findAll(){
        Comment comment = new Comment();
        System.out.println("@@@@@@@@@"+comment.getBoard());

        return (List<Comment>) commentService.findAll();
    }
    @RequestMapping(value = "/findone/{seq}")
    public Comment findBySeq(@PathVariable("seq")long seq){
        Comment comment = commentService.findBySeq(seq);

        return comment;
    }


    @RequestMapping(value = "/write")
    public String write(Comment comment){
        Comment comment1 = new Comment();
        User user = new User();
        Board board = new Board();

        user.setUserid("june");
        comment1.setBoard(board);
        board.setBoard_seq(2L);
        comment1.setUser(user);
        comment1.setContent("여기있어요!");
        comment1.setDate(new Date());

        return commentService.write(comment);
    }

}
