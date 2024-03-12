package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.entity.User;
import com.study.board.repository.BoardRepository;
import com.study.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class UserService {

    // 글 작성 처리
    @Autowired
    private UserRepository userRepository;

    public void write(User user) throws IOException {
        userRepository.save(user);
    }
}
