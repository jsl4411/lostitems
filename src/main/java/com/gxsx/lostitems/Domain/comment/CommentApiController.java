package com.gxsx.lostitems.Domain.comment;

import com.gxsx.lostitems.Domain.board.Board;
import com.gxsx.lostitems.Domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/comment/api")
public class CommentApiController {

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/{board_seq}",method = RequestMethod.GET)
    public List<Comment> findAll(@PathVariable("board_seq") String board_seq){

        System.out.println(commentService.findBySeq(Long.parseLong(board_seq)));

        return commentService.findBySeq(Long.parseLong(board_seq));
    }


    @PostMapping(value = "/write")
    public String write(@RequestBody CommentVO comment, HttpServletRequest request){

        String userid = (String) request.getSession().getAttribute("loginUser");
        System.out.println("@@@@@@@@@"+comment.comment_seq);
        return commentService.write(comment,userid);
    }
    @GetMapping(value = "/delete/{comment_seq}")
    public String delete(@PathVariable("comment_seq") String comment_seq){

        return commentService.delete(Long.parseLong(comment_seq));
    }
    @PostMapping(value ="/edit/{comment_seq}")
    public String update(@RequestBody Comment comment, HttpServletRequest request){
        String userid = (String) request.getSession().getAttribute("loginUser");
        System.out.println("@@@@@@editComment"+comment);

        return commentService.update(comment,userid);
    }

}
