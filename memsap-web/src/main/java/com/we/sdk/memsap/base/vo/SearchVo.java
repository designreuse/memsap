package com.we.sdk.memsap.base.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchVo {

    private String phoneNumber;

    private String userName;

    private String sex;

    private String brandName;

    private String seriesName;

    private String phoneName;

    private Page page;

}
