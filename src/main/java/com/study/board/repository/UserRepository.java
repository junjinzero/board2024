package com.study.board.repository;

import com.study.board.entity.Board;
import com.study.board.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> { //<Entity, PK의 컬럼타입>

}
