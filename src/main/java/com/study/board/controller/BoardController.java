package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") //  웹 주소
    public String boardWriteFrom(){
        return "board_write";
    }

    @PostMapping("board/writepro")
    public String boardWritePro(Model model, Board board, @RequestParam(value="file") MultipartFile file) throws Exception {
        System.out.println("boardWriteProd");

        boardService.write(board, file);

        model.addAttribute("message", "글 작성이 완료되었습니다.");
        model.addAttribute("searchUrl", "/board/list");

        return "message";
    }

    @GetMapping("/board/list")
    public String boardList(Model model
            , @PageableDefault(page = 0
                             , size = 10
                             //, sort = "board_id"  //  이게 있으면 에러남
                             , direction = Sort.Direction.DESC) Pageable pageable) {

        model.addAttribute("list", boardService.boardList(pageable));

        return "board_list";
    }

    @GetMapping("/board/view")  // localhost:8080/board/view?id=1
    public String boardView(Model model, @RequestParam(value="board_id") Integer board_id) {

        model.addAttribute("board", boardService.boardView(board_id));

        return "board_view";
    }

    @GetMapping("/board/delete")
    public String boardDelete(@RequestParam(value="board_id") Integer board_id) {

        boardService.boardDelete(board_id);
        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{board_id}")
    public String boardModify(@PathVariable("board_id")  Integer board_id, Model model) {
        model.addAttribute("board", boardService.boardView(board_id));
        System.out.println("board_id = " + board_id);
        return "board_modify";
    }

    @PostMapping("/board/update/{board_id}")
    public String boardUpdate(@PathVariable("board_id") Integer board_id, Board board, Model model, MultipartFile file) throws Exception {

        Board boardTemp = boardService.boardView(board_id);
        boardTemp.setBoard_title(board.getBoard_title());
        boardTemp.setBoard_cont(board.getBoard_cont());

        boardService.write(boardTemp, file);

        model.addAttribute("message", "글 수정이 완료되었습니다.");
        model.addAttribute("searchUrl", "/board/list");

        return "message";

    }

}