package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    // 글 작성 처리
    @Autowired
    private BoardRepository boardRepository;

    public void write(Board board) {
        boardRepository.save(board);
    }

    // 게시물 리스트 처리
    public List<Board> boardList() {
        return boardRepository.findAll();
    }

    public Board boardView(Integer board_id) {
        return boardRepository.findById(board_id).get();
        // findById 으로 받아오면 optional 로 받기 때문에, .get() 을 넣어 Board 를 넘길 수 있게 한다.
    }

    public void boardDelete(Integer board_id) {
        boardRepository.deleteById(board_id);
    }
}
