package com.gxsx.lostitems.Domain.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;


    @RequestMapping(value = "/")
    public String board(){
        return "board/lolist";
    }
    @RequestMapping(value = "/write")
    public String write(){
        return "board/lowrite";
    }

}
