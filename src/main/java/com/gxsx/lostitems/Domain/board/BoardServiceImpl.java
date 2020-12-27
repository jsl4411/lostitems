package com.gxsx.lostitems.Domain.board;

import com.gxsx.lostitems.Domain.user.User;
import com.gxsx.lostitems.Domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private UserRepository userRepository;

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
    public String write(Board board, String userid) {//글쓰기 단순해 회원가입이랑 비슷해 그지?
        System.out.println("asdfhjkasashjfklasldjhfkjahlshdfjklahskdjfh");

        Optional<User> user = Optional.ofNullable(userRepository.findUserByUserid(userid));
        Board board1 = new Board();
        board1.setUser(user.get());
        board1.setBoard_group(board.getBoard_group());
        board1.setBoard_sub(board.getBoard_sub());
        board1.setDate(board.getDate());
        board1.setContent(board.getContent());
        board1.setAno(board.getAno());
        board1.setPlace(board.getPlace());
        board1.setCategory(board.getCategory());

        System.out.println("@@"+board1);
        boardRepository.save(board1);

        return "success";
    }

    @Override
    public String deleteById(Long board_seq) {
        boardRepository.deleteById(board_seq);

        return "success";
    }


}
