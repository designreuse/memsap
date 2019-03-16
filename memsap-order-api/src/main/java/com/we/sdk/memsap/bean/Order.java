package com.we.sdk.memsap.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private Integer id;
    private Double payment;

    @ApiModelProperty(hidden = true,example = "2018-11-11 11:11:11")
    private Date creatTime;

    private String userName;

    private String userPhone;

    private String userAddress;
}
