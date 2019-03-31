package com.we.sdk.memsap.controller;

import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.Brand;
import com.we.sdk.memsap.bean.Phone;
import com.we.sdk.memsap.bean.RepairPrice;
import com.we.sdk.memsap.service.impl.PhoneServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/phone")
@RequiredArgsConstructor
public class PhoneController {

    private final PhoneServiceImpl phoneService;

    @RequestMapping("/listByCondition")
    public String getPhoneListByCondition(Model model, SearchVo searchVo, Page page) {
        Page<Phone> pages = phoneService.getPhoneListByConditions(searchVo, page);
        List<Brand> brands = phoneService.getBrandList();
        List<Phone> phones = pages.getData();
        for (Phone phone : phones) {
            phone.setPhoneColorList(Arrays.asList(phone.getPhoneColors().split(",")));
        }
        model.addAttribute("phoneList", phones);
        model.addAttribute("brands", brands);
        model.addAttribute("searchVo", searchVo);
        model.addAttribute("page",pages);
        return "phone/phoneShow";
    }

    @GetMapping("/toEdit")
    public String toEdit(Model model, @RequestParam("id") Integer id) {
        Phone phone = phoneService.getPhoneById(id);
        phone.setPhoneColorList(Arrays.asList(phone.getPhoneColors().split(",")));
        model.addAttribute("phone", phone);
        return "phone/phoneEdit";
    }

    @GetMapping("/toAdd")
    public String toAdd() {
        return "phone/phoneManage";
    }

    @PostMapping("/edit")
    public String phoneAdd(Model model, Phone phone, @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            model.addAttribute("msg", "没有找到相对应的文件");
            return "phoneManage";
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
                    return "phoneManage";
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                phoneService.update(phone);
            }
        }
        return "redirect:list";
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

