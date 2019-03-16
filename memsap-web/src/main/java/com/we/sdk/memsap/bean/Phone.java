package com.we.sdk.memsap.bean;


import lombok.Data;

import java.util.List;

@Data
public class Phone {

    private Integer id;

    private String phoneName;

    private String phoneImage;

    private String phoneColors;

    private List<String> phoneColorList;

    private Integer seriesId;

    private Integer brandId;


}
