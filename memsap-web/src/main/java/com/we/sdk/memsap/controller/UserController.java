package com.we.sdk.memsap.controller;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.util.CookieUtils;
import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.User;
import com.we.sdk.memsap.service.UserService;
import com.we.sdk.memsap.service.impl.SSOService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final JavaMailSender mailSender;

    private final SSOService ssoService;

    @Value("${spring.mail.from}")
    private String Sender;

    @GetMapping("/toLogin")
    public String toLogin(String redirect, Model model) {
        model.addAttribute("redirect", redirect);
        return "login";
    }


    @PostMapping("/login")
    @ResponseBody
    public RestResult<String> backLogin(@RequestParam("phoneNumber") String phoneNumber, @RequestParam("password") String password,
                                        HttpServletRequest request, HttpServletResponse response) {
        RestResult<String> result = ssoService.userLogin(phoneNumber, password, request, response);
        return result;
    }

    @RequestMapping("/background/list")
    public String getUserListByCondition(Model model, SearchVo searchVo, Page page) {
        Page<User> userList = userService.getUserListByCondition(searchVo, page);
        model.addAttribute("userList", userList.getData());
        model.addAttribute("searchVo", searchVo);
        model.addAttribute("page", userList);
        return "user/list";
    }

    @PostMapping("/register")
    public String registerPost(User user, Model model) {
        User user1 = userService.getUserByPhoneNumber(user.getPhoneNumber());
        if (user1 != null) {
            model.addAttribute("msg", "该账号已存在！");
        } else {
            RestResult<Integer> result = userService.save(user);
            if (result.getCode() == 0) {
                model.addAttribute("msg", "恭喜您，注册成功！");
                return "login";
            } else {
                model.addAttribute("msg", result.getMsg());
            }
        }
        return "register";
    }

    @PostMapping("/forget")
    public String forget(User user, Model model) {
        User user1 = userService.checkUser(user);
        if (user1 == null) {
            model.addAttribute("msg", 1);
        } else {
            String email = user.getEmail();
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(Sender);
            message.setTo(email); //接收者邮箱
            message.setSubject("WE后台信息管理系统-密码找回");
            StringBuilder sb = new StringBuilder();
            sb.append(user1.getUserName() + "用户您好！您的注册密码是：" + user1.getPassword() + "。感谢您使用WE信息管理系统！");
            message.setText(sb.toString());
            mailSender.send(message);
            model.addAttribute("msg", 0);
        }
        return "forget";

    }

    @GetMapping("/toEdit")
    public String toEdit(Model model, @RequestParam("phoneNumber") String phoneNumber) {
        User user = userService.getUserByPhoneNumber(phoneNumber);
        model.addAttribute("user", user);
        return "user/edit";
    }

    @PostMapping("/edit")
    public String userManagePost(Model model, User user) {
        RestResult<Integer> result = userService.update(user);
        if (result.getCode() == 1) {
            model.addAttribute("user", user);
            model.addAttribute("msg", result.getMsg());
            return "user/edit";
        }
        model.addAttribute("msg", "修改成功");
        return "redirect:background/list";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        String token = CookieUtils.getCookieValue(request, "USER_TOKEN");
        ssoService.logout(token); // 思路是从Redis中删除key，实际情况请和业务逻辑结合
        return "login";
    }


    @ResponseBody
    @PostMapping("/delete")
    public Integer delete(@RequestParam("phoneNumber") String phoneNumber) {
        return userService.delete(phoneNumber);
    }

}

