package com.gxsx.lostitems.Domain.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/board")

public class BoardCotroller {
    @Autowired
    BoardService boardService;
    BoardRepository boardRepository;

    @RequestMapping(value = "")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "findall", method = RequestMethod.GET)
    public List<Board> findAll(){

        return (List<Board>) boardService.findAll();
    }

    @RequestMapping(value = "/findone/{board_seq}")
    public Board findone(@PathVariable("board_seq") long board_seq){
        Board boardData = boardService.findById(board_seq);

        return boardData;

    }
   /* @RequestMapping(value = "/create")
    public String createBoard(Board board){
        Board newBoard = boardRepository.save(board);

        return board.();
    }*/

}
