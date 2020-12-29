package com.gxsx.lostitems.Domain.board;

import com.gxsx.lostitems.Domain.comment.Comment;
import com.gxsx.lostitems.Domain.comment.CommentService;
import com.gxsx.lostitems.Domain.comment.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;
    @Autowired
    private CommentService commentService;


    @RequestMapping(value = "/{boardGroup}")
    public String board(Model model, HttpServletRequest request, @PathVariable String boardGroup){

        System.out.println(boardGroup);

        List<Board> boardList = boardService.findByBoardGroup(Long.parseLong(boardGroup));

        model.addAttribute("loginUser",request.getSession().getAttribute("loginUser"));
        model.addAttribute("boardlist",boardList);
        if(boardGroup.equals("0")){
            return "board/findlist";
        }else {
            return "board/lolist";
        }
    }

    @GetMapping(value = "/write")
    public String getwrite(Model model, HttpServletRequest request){

        model.addAttribute("loginUser",request.getSession().getAttribute("loginUser"));

        return "board/lowrite";
    }

    @PostMapping("/write")
    public String write(Board board, BindingResult result){

        System.out.println("@@@@@@@@" + board);

        return "redirect:/";
    }

    @GetMapping(value = "/content/{board_seq}")
    public String content(@PathVariable("board_seq") String board_seq, Model model, HttpServletRequest request ){
        System.out.println(board_seq);

       Board boardcontant = boardService.findById(Long.parseLong(board_seq));

        model.addAttribute("loginUser",request.getSession().getAttribute("loginUser"));

        model.addAttribute("boardcontant", boardcontant );

        return "board/locontent";
    }
    @GetMapping(value = "/edit/{board_seq}")
    public String edit(@PathVariable("board_seq") Long board_seq,Model model, HttpServletRequest request){

        Board boardedit = boardService.findById(board_seq);

         model.addAttribute("loginUser",request.getSession().getAttribute("loginUser"));

         model.addAttribute("boardedit", boardedit);

        return "board/updatef";
    }



}
