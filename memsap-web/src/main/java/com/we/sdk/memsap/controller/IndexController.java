package com.we.sdk.memsap.controller;

import com.we.sdk.memsap.bean.*;
import com.we.sdk.memsap.service.AddressService;
import com.we.sdk.memsap.service.OrderService;
import com.we.sdk.memsap.service.PhoneService;
import com.we.sdk.memsap.service.SeriesService;
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

    private final AddressService addressService;

    private final OrderService orderService;

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
        List<Series> seriesList = seriesService.getSeriesList();
        model.addAttribute("seriesList", seriesList);
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
        Order order = shoppingCart.getOrder();
        List<OrderDetail> orderDetailList = shoppingCart.getOrderDetailList();
        Integer result = orderService.save(order);
        if (result > 0) {
            for (OrderDetail orderDetail : orderDetailList) {
                orderDetail.setOrderId(result);
            }
            result = orderService.saveOrderDetails(orderDetailList);
        }
        return result;
    }


    @PostMapping("/toPay")
    public String toPay(@RequestBody ShoppingCart shoppingCart,Model model) {
        Order order = shoppingCart.getOrder();
        List<OrderDetail> orderDetailList = shoppingCart.getOrderDetailList();
        List<Address> addressList = addressService.getAddressByPhoneNumber(order.getUserPhone());
        model.addAttribute("order",order);
        model.addAttribute("orderDetailList",orderDetailList);
        model.addAttribute("addressList",addressList);
        return "新地址";
    }




    @PostMapping("/getRepairPrice")
    @ResponseBody
    public List<RepairPrice> geetRepairPrice(Integer phoneId) {
        List<RepairPrice> repairPriceList = phoneService.getFaultRepairPriceByCondition(new RepairPrice(phoneId));
        return repairPriceList;

    }

}
