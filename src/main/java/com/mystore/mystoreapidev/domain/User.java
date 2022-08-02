package com.mystore.mystoreapidev.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("userinfo")
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String question;
    private String answer;
    private Integer role;
}
