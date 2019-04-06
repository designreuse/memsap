package com.we.sdk.memsap.controller;

import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.*;
import com.we.sdk.memsap.service.impl.PhoneServiceImpl;
import com.we.sdk.memsap.service.impl.SeriesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/phone")
@RequiredArgsConstructor
public class PhoneController {

    private final PhoneServiceImpl phoneService;

    private final SeriesServiceImpl seriesService;


    @RequestMapping("/listByCondition")
    public String getPhoneListByCondition(Model model, SearchVo searchVo, Page page) {
        Page<Phone> pages = phoneService.getPhoneListByConditions(searchVo, page);
        List<Brand> brands = phoneService.getBrandList();
        List<Series> seriesList = seriesService.getSeriesList();
        List<Phone> phones = pages.getData();
        for (Phone phone : phones) {
            phone.setPhoneColorList(Arrays.asList(phone.getPhoneColors().split(",")));
        }
        model.addAttribute("phoneList", phones);
        model.addAttribute("brands", brands);
        model.addAttribute("seriesList", seriesList);
        model.addAttribute("searchVo", searchVo);
        model.addAttribute("page", pages);
        return "phone/phoneShow";
    }

    @GetMapping("/toEdit")
    public String toEdit(Model model, @RequestParam(value = "id", required = false) Integer id) {
       /* if (ObjectUtils.equals(id, null)) {

        }*/
        Phone phone = phoneService.getPhoneById(id);
        phone.setPhoneColorList(Arrays.asList(phone.getPhoneColors().split(",")));
        List<Brand> brandList = phoneService.getBrandList();
        List<Fault> faultList = phoneService.getFaultList();
        List<Repair> repairList = phoneService.getRepairList();
        List<RepairPrice> repairPriceList = phoneService.getFaultRepairPriceByCondition(new RepairPrice(id));
        List<Series> seriesList = seriesService.getSeriesList();
        model.addAttribute("phone", phone);
        model.addAttribute("brandList", brandList);
        model.addAttribute("seriesList", seriesList);
        model.addAttribute("faultList", faultList);
        model.addAttribute("repairList", repairList);
        model.addAttribute("repairPriceList", repairPriceList);
        return "phone/phoneEdit";
    }

    @GetMapping("/toAdd")
    public String toAdd() {
        return "phone/phoneManage";
    }

    @PostMapping("/edit")
    public String phoneAdd(Model model, @RequestParam("file") MultipartFile file, Phone phone, String[] repairId, String[] price) {
        if (ObjectUtils.isEmpty(phone.getId()) && file.isEmpty()) {
            model.addAttribute("msg", "没有找到相对应的文件");
            return "phoneEdit";
        } else {
            try {
                String fileName = file.getOriginalFilename();
                String type = (fileName.indexOf(".") != -1) ? fileName.substring(fileName.lastIndexOf(".") + 1) : null;
                if (type != null) {
                    if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                        File tempFile = new File(fileName);
                        file.transferTo(tempFile);
                        phone.setPhoneImage(fileName);
                    }
                } else {
                    model.addAttribute("msg", "不是我们想要的文件类型,请按要求重新上传");
                    return "phone/phoneShow";
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                List<RepairPrice> repairPriceList = new ArrayList<>();
                if (!ObjectUtils.isEmpty(repairId) && !ObjectUtils.isEmpty(price)) {
                    for (int i = 0; i < repairId.length; i++) {
                        repairPriceList.add(new RepairPrice(phone.getId(), Integer.parseInt(repairId[i]), Double.parseDouble(price[i])));
                    }
                }
                Integer result = phoneService.update(phone);
                if (result > 0) {
                    phoneService.batchEdit(repairPriceList);
                }
            }
        }
        return "redirect:listByCondition";
    }


    @ResponseBody
    @DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable Integer id) {
        return phoneService.delete(id);
    }

    @PostMapping("/toFaults/{id}")
    public String toFaults(Model model, @PathVariable Integer id) {

        List<RepairPrice> repairPrices = phoneService.getFaultRepairPriceByCondition(new RepairPrice(id));
        model.addAttribute("repairPrices", repairPrices);
        //跳转去维修的页面
        return "/";
    }

}

