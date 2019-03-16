package com.we.sdk.memsap.bean;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RepairPrice {

  private Integer phoneId;
  private Integer repairId;
  private Double price;

  public RepairPrice(Integer phoneId) {
    this.phoneId = phoneId;
  }
}
