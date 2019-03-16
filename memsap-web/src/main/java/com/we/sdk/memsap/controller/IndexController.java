package com.we.sdk.memsap.controller;

import com.we.sdk.memsap.bean.Brand;
import com.we.sdk.memsap.bean.Fault;
import com.we.sdk.memsap.bean.Phone;
import com.we.sdk.memsap.bean.Repair;
import com.we.sdk.memsap.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class IndexController {

    private final PhoneService phoneService;

//    private final SeriesService seriesService;


    @GetMapping("")
    public String index(Model model) {
        List<Brand> brandList = phoneService.getBrandList();
        List<Phone> phoneList = phoneService.getPhoneList();
        List<Fault> faultList = phoneService.getFaultList();
        List<Repair> repairList = phoneService.getRepairList();
//        List<Series> seriesList = seriesService.getSeriesList();
        model.addAttribute("brandList", brandList);
        model.addAttribute("phoneList", phoneList);
        model.addAttribute("faultList", faultList);
        model.addAttribute("repairList", repairList);
//        model.addAttribute("seriesList", seriesList);
        return "index";
    }
}
