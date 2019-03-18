package com.we.sdk.memsap.controller;

import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.bean.Address;
import com.we.sdk.memsap.bean.AddressDic;
import com.we.sdk.memsap.bean.User;
import com.we.sdk.memsap.service.AddressService;
import com.we.sdk.memsap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String addressList(Model model) {
        List<Address> addressList = addressService.getAddressList();
        List<User> userList = userService.getUserList();
        for (Address address : addressList) {
            for (User user : userList) {
                if (address.getUserId().equals(user.getPhoneNumber())) {
                    address.setUserName(user.getUserName());
                }
            }
        }
        model.addAttribute("addressList", addressList);
        return "address/list";
    }


    @GetMapping("/toAddress")
    public String toAddress(Model model, @RequestParam("userName") String userName, @RequestParam("phoneNumber") String phoneNumber) {
        List<Address> addressList = addressService.getAddressByPhoneNumber(phoneNumber);
        for (Address address : addressList) {
            address.setUserName(userName);
        }
        model.addAttribute("addressList", addressList);
        return "address/list";
    }


    @GetMapping("/toUpdate")
    public String toUpdate(Model model, @RequestParam(required = false) Integer id) {
        if (id == null) {
            return "address/add";
        } else {
            Address address = addressService.getAddressById(id);
            model.addAttribute("address", address);
            return "address/edit";
        }
    }

    @PostMapping("/update")
    public String update(Address address) {
        if (address.getId() == null) {
            addressService.save(address);
        } else {
            addressService.update(address);
        }
        return "redirect:list";
    }

    @ResponseBody
    @PostMapping("/delete")
    public Integer delete(@RequestParam("id") Integer id) {
        return addressService.delete(id);
    }

    @PostMapping("/dicList")
    public String getAddressDicList(Model model, @RequestParam("address") String address, @RequestBody(required = false) Page<AddressDic> page) {
        Page<AddressDic> addressDicList = addressService.getAddressDicListByCondition(address, page);
        model.addAttribute("userList", addressDicList.getData());
        model.addAttribute("searchVo", address);
        model.addAttribute("page", addressDicList);
        return "address/dicList";
    }

    @PostMapping("/updateDic")
    public String updateDic(AddressDic addressDic) {
        if (addressDic.getId() == null) {
            addressService.save(addressDic);
        } else {
            addressService.update(addressDic);
        }
        return "redirect:dicList";
    }

    @ResponseBody
    @PostMapping("/deleteDic")
    public Integer deleteDic(@RequestParam("id") Integer id) {
        return addressService.deleteAddressDic(id);
    }

    @GetMapping("/getAddressDicByParentId/{parentId}")
    @ResponseBody
    public List<AddressDic> getAddressDicByParentId(@PathVariable("parentId") Integer parentId) {
        parentId = parentId < 0 ? 0 : parentId;
        List<AddressDic> addressDicList = addressService.getAddressDicByParentId(parentId);
        return addressDicList;
    }

}

