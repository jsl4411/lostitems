package com.gxsx.lostitems.Domain.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


public interface BoardService {

    List<Board> findAll();

    Board findById(long board_seq);

    String write(Board board, String userid);

    String deleteById(Long board_seq);
}
