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

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Comment> findAll(){
        Comment comment = new Comment();

        return (List<Comment>) commentService.findAll();
    }
    @RequestMapping(value = "/findone/{seq}")
    public Comment findBySeq(@PathVariable("seq")long seq){
        Comment comment = commentService.findBySeq(seq);

        return comment;
    }


    @PostMapping(value = "/write")
    public String write(@RequestBody CommentVO comment, HttpServletRequest request){

        String userid = (String) request.getSession().getAttribute("loginUser");

        return commentService.write(comment,userid);
    }
    @RequestMapping(value = "/delete/{comment_seq}")
    public String delete(@PathVariable("comment_seq") Long comment_seq){

        return commentService.delete(comment_seq);
    }

}
