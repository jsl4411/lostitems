package com.gxsx.lostitems.Domain.board;

import com.gxsx.lostitems.Domain.user.User;
import com.gxsx.lostitems.Domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static sun.misc.Version.println;

@RestController
@RequestMapping(value = "/board/api")

public class BoardApiController {
    @Autowired
    BoardService boardService;

    @RequestMapping(value = "")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "findall", method = RequestMethod.GET)
    public List<Board> findAll(){
            Board board1 = new Board();
            System.out.println("@@@@@@@@@@@@@@@@"+board1.getUser());


        return (List<Board>) boardService.findAll();
    }

    @RequestMapping(value = "/findone/{board_seq}")
    public Board findById(@PathVariable("board_seq") long board_seq){
        Board boardData = boardService.findById(board_seq);

        return boardData;
    }
    @RequestMapping(value = "/write")
    public String write(Board board){


        return boardService.write(board);
    }
    @RequestMapping(value = "/delete/{board_seq}")
    public String delete(@PathVariable("board_seq") Long board_seq){

        return boardService.deleteById(board_seq);

    }


}
