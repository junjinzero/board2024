package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.entity.User;
import com.study.board.service.BoardService;
import com.study.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/write") //  회원가입 화면
    public String userWriteForm(){
        return "user/user_write";
    }


    @ResponseBody
    @PostMapping("user/writepro")  // 회원가입
    public String userWritePro(User user) throws Exception {
        System.out.println("userWriteProd");

        user.setUser_pw_chg_dttm(new Date());
        user.setUse_yn("Y");

        userService.write(user);

//        model.addAttribute("message", "글 작성이 완료되었습니다.");
//        model.addAttribute("searchUrl", "/board/list");

        return user.toString();
    }
}