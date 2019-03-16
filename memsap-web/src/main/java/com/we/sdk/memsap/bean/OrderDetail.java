package com.we.sdk.memsap.bean;

import lombok.Data;

@Data
public class OrderDetail {
    private Integer id;
    private Integer orderId;
    private String phoneDetail;
    private String repairDetails;
    private Double price;
}
