package com.gxsx.lostitems.Domain.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


public interface BoardService {

    List<Board> findAll();
    
    List<Board> findByBoardGroup(long boardGroup);
    Board findById(long board_seq);

    String write(Board board, String userid);

    String deleteById(Long board_seq);

    String update(Board board, String userid);
}
