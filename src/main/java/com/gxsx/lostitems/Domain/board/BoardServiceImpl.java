package com.gxsx.lostitems.Domain.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
    public String write(Board board) {//글쓰기 단순해 회원가입이랑 비슷해 그지?

        boardRepository.save(board);

        return "success";
    }

    @Override
    public String deleteById(Long board_seq) {
        boardRepository.deleteById(board_seq);

        return "success";
    }


}
