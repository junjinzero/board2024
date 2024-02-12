package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {

    // 글 작성 처리
    @Autowired
    private BoardRepository boardRepository;

    public void write(Board board, MultipartFile file) throws IOException {

        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files/";

        UUID uuid = UUID.randomUUID(); // random uuid 를 만든다.

        String fileName = uuid + "_" + file.getOriginalFilename();

        File saveFile = new File(projectPath, fileName);
        //  projectPath 에 “name” 이라는 이름으로 파일을 저장한다
        file.transferTo(saveFile);

        board.setFile_nm(fileName);
        board.setFile_path("/files/" + fileName);


        boardRepository.save(board);
    }

    // 게시물 리스트 처리
    public Page<Board> boardList(Pageable pageable) {

        return boardRepository.findAll(pageable);
    }

    public Board boardView(Integer board_id) {
        return boardRepository.findById(board_id).get();
        // findById 으로 받아오면 optional 로 받기 때문에, .get() 을 넣어 Board 를 넘길 수 있게 한다.
    }

    public void boardDelete(Integer board_id) {
        boardRepository.deleteById(board_id);
    }
}
