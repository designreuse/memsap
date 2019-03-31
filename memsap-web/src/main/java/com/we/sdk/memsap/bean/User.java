package com.we.sdk.memsap.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
public class User {
//    @NotBlank(message = "手机号码不能为空")
//    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误")
    private String phoneNumber;
//    @NotBlank
    private String password;

//    @NotBlank
    private String userName;

    private String sex;

//    @Email(message = "邮箱格式错误")
    private String email;

    private Date registerDate;

    private String salt;                    // 用于加密的盐


    private String plainPassword;           // 登录时的密码，不持久化到数据库

}
