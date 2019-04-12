package com.we.sdk.memsap.bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class ShoppingCart {
    private Order order;
    private List<OrderDetail> orderDetailList;
}
