package com.we.sdk.memsap.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;


@Data
public class User {
    @NotBlank(message = "手机号码不能为空")
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式错误")
    private String phoneNumber;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "用户名不能为空")
    private String userName;

    private String sex;

    @Email(message = "邮箱格式错误")
    @NotBlank(message = "邮箱不能为空")
    private String email;

    @ApiModelProperty(hidden = true)
    private Date registerDate;

    private String salt;

    private String plainPassword;
}
