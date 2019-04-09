package com.we.sdk.memsap.controller;

import com.we.sdk.memsap.bean.*;
import com.we.sdk.memsap.service.OrderService;
import com.we.sdk.memsap.service.PhoneService;
import com.we.sdk.memsap.service.SeriesService;
import com.we.sdk.memsap.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PhoneService phoneService;

    private final SeriesService seriesService;

    private final UserService userService;

    private final OrderService orderService;

    @PostMapping("/login")
    public String backLogin(Model model,User user) {
        User user1 = userService.checkUser(user);
        if(user1==null){
            model.addAttribute("msg","账号密码不正确");
        }
        return "login2";
    }


    @GetMapping("/")
    public String index(Model model) {
        List<Brand> brandList = phoneService.getBrandList();
        List<Phone> phoneList = phoneService.getPhoneList();
        List<Fault> faultList = phoneService.getFaultList();
        List<Repair> repairList = phoneService.getRepairList();
        List<Series> seriesList = seriesService.getSeriesList();
        model.addAttribute("brandList", brandList);
        model.addAttribute("phoneList", phoneList);
        model.addAttribute("faultList", faultList);
        model.addAttribute("repairList", repairList);
        model.addAttribute("seriesList", seriesList);
        return "index";
    }

    @GetMapping("/phoneClassification")
    public String des(Model model) {
        List<Brand> brandList = phoneService.getBrandList();
        List<Phone> phoneList = phoneService.getPhoneList();
        model.addAttribute("brandList", brandList);
        model.addAttribute("phoneList", phoneList);
        return "phoneClassification";
    }

    @GetMapping("/detail")
    public String detail(Model model, @RequestParam("id") Integer id) {
        Phone phone = phoneService.getPhoneById(id);
        phone.setPhoneColorList(Arrays.asList(phone.getPhoneColors().split(",")));
        List<Fault> faultList = phoneService.getFaultList();
        List<Repair> repairList = phoneService.getRepairList();
        List<RepairPrice> faultRepairPrice = phoneService.getFaultRepairPriceByCondition(new RepairPrice(id));
        model.addAttribute("phone", phone);
        model.addAttribute("faultList", faultList);
        model.addAttribute("repairList", repairList);
        model.addAttribute("faultRepairPrice", faultRepairPrice);
        return "phoneDetail";
    }


    @PostMapping("/saveOrder")
    @ResponseBody
    public Integer saveOrder(@RequestBody ShoppingCart shoppingCart) {

        return null;
    }

}
