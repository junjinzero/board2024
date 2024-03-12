package com.study.board.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_key;
    private String user_id;
//    @Column(name = "boardTitle")
    private String user_nm;
    private String user_pw;
    private String user_nicknm;
    private String user_email;
    private String user_hpn;
    private Date user_pw_chg_dttm;
    private String use_yn;
    private Integer login_fail_num;

}
