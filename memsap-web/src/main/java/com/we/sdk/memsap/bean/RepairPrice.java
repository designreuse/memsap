package com.we.sdk.memsap.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepairPrice {

    private Integer phoneId;
    private Integer repairId;
    private Double price;

    public RepairPrice(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public RepairPrice(Integer repairId, Double price) {
        this.repairId = repairId;
        this.price = price;
    }



}
