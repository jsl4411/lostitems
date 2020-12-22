package com.gxsx.lostitems.Domain.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardRepository boardRepository;

    @Override
    public List<Board> findAll() {
        List<Board> boardList = boardRepository.findAll();

        return boardRepository.findAll();
    }

    @Override
    public Board findById(long board_seq) {

        return boardRepository.findById(board_seq).orElse(null);
    }

    @Override
    @Transactional
    public Long write(Board board) {

        return boardRepository.save(board).getBoard_seq();
    }


}
