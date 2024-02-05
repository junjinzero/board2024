package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") //  웹 주소
    public String boardWriteFrom(){
        return "board_write";
    }

    @PostMapping("board/writepro")
    public String boardWritePro(@ModelAttribute Board board) {
        System.out.println("boardWriteProd");
        boardService.write(board);

        return "";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {

        model.addAttribute("list", boardService.boardList());

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
    public String boardUpdate(@PathVariable("board_id") Integer board_id, Board board) {
        System.out.println("board_id = " + board_id);
        System.out.println(board.getBoard_title());
        Board boardTemp = boardService.boardView(board_id);
        boardTemp.setBoard_title(board.getBoard_title());
        boardTemp.setBoard_cont(board.getBoard_cont());

        boardService.write(boardTemp);

        return "redirect:/board/list";
    }

}