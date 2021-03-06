package com.gxsx.lostitems.Domain.board;

import com.gxsx.lostitems.Domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.List;


public interface BoardRepository extends JpaRepository<Board,Long> {
    List<Board> findByBoardGroup(long boardGroup);
}
