package com.jang.sample.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jang.sample.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findBoardByContent(String content);
    // id > ? ORDER BY id DESC limit ?, ?
    List<Board> findByIdGreaterThanOrderByIdDesc(Long id, Pageable paging);
    // id > ? limit ?, ?
    Page<Board> findByIdGreaterThan(Long id, Pageable paging);

    @Query(value = "select * from board b where b.username like %?1%", nativeQuery = true)
    List<Board> findBoardByUsername(String username);
}