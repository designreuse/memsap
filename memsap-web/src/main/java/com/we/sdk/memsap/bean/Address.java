package com.we.sdk.memsap.bean;

import lombok.Data;

@Data
public class Address {
    private Integer id;
    private String userId;
    private String province;
    private String city;
    private String county;
    private String detailAddress;
    private String userName;
}
