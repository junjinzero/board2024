package com.study.board.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_key;

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String user_id;
//    @Column(name = "boardTitle")

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String user_nm;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}",
            message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String user_pw;

    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$",
            message = "닉네임은 특수문자를 제외한 2~10자리여야 합니다.")
    private String user_nicknm;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$",
            message = "이메일 형식이 올바르지 않습니다.")
    private String user_email;

    @NotBlank(message = "휴대폰 번호는 필수 입력 값입니다.")
    private String user_hpn;

    private Date user_pw_chg_dttm;
    private String use_yn;
    private Integer login_fail_num;

}
