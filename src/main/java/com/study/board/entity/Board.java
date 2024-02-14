package com.study.board.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer board_id;
    @Column(name = "boardTitle")
    private String boardTitle;
    private String board_cont;
    private String file_nm;
    private String file_path;

}
