package com.gxsx.lostitems.Domain.board;

import com.gxsx.lostitems.Domain.user.User;
import com.gxsx.lostitems.Domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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


    @PostMapping(value = "/write")
    public String write(@RequestBody Board board, HttpServletRequest request){

        String userid = (String) request.getSession().getAttribute("loginUser");
        System.out.println("@@@@@@@"+board);

        return boardService.write(board,userid);

    }
    @GetMapping(value = "/delete/{board_seq}")
    public String delete(@PathVariable("board_seq") Long board_seq){

        return boardService.deleteById(board_seq);
    }
    @PostMapping("/edit/{board_seq}")
    public String update(Board board, HttpServletRequest request){
        String userid = (String) request.getSession().getAttribute("loginUser");

        return boardService.update(board,userid);
    }

}
