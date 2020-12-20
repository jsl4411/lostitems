package com.gxsx.lostitems.Domain.board;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.List;


public interface BoardRepository extends JpaRepository<Board,Long> {
}
