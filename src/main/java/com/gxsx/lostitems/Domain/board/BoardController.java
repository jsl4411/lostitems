package com.gxsx.lostitems.Domain.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;


    @RequestMapping(value = "/")
    public String board(Model model, HttpServletRequest request){
        List<Board> boardList = boardService.findAll();

        model.addAttribute("loginUser",request.getSession().getAttribute("loginUser"));
        model.addAttribute("boardlist",boardList);

        return "board/lolist";
    }

    @GetMapping(value = "/write")
    public String getwrite(){
        return "board/lowrite";
    }

    @PostMapping("/write")
    public String write(Board board, BindingResult result){
        boardService.write(board);
        return "redirect:/";
    }

    @RequestMapping(value = "/content")
    public  String content(){
        return "board/locontent";
    }
}
