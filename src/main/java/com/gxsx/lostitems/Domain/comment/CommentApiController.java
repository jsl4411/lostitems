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
    public String write(CommentVO comment){
        System.out.println("in comment write");

        //getBoard 가 다 들어와야됨
        return commentService.write(comment);
    }
    @RequestMapping(value = "/delete/{comment_seq}")
    public String delete(@PathVariable("comment_seq") Long comment_seq){

        return commentService.delete(comment_seq);
    }

}
