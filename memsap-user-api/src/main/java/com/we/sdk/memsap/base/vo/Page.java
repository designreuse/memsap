package com.we.sdk.memsap.base.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class Page<T> {
    /**
     * 当前页数
     */
    private int pn = 1;

    /**
     * 当前显示条数
     */
    private Integer pageSize = 10;

    /**
     * 总页数
     */
    @ApiModelProperty(hidden = true)
    private int totalPage;
    /**
     * 总条数
     */
    @ApiModelProperty(hidden = true)
    private int totalCount;

    @ApiModelProperty(hidden = true)
    private List<T> data;

    public Page() {
    }

    public Page(int pn, Integer pageSize) {
        this.pn = pn;
        this.pageSize = pageSize;
    }


    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calculate();
    }

    /**
     * 根据当前对象中的属性值计算并设置相关属性值
     */
    private void calculate() {
        //计算总页数
        int totalPage = this.totalCount / this.pageSize;
        int plusPage = this.totalCount % this.pageSize == 0 ? 0 : 1;
        totalPage += plusPage;
        if (totalPage <= 0) {
            totalPage = 1;
        }
        this.totalPage = totalPage;

        //设置当前页数
        //总页数小于当前页数，应将当前页数设置为总页数
        if (this.totalPage < this.pn) {
            this.pn = this.totalPage;
        }

        //当前页数小于1则设为1
        if (this.pn < 1) {
            this.pn = 1;
        }
    }

    public static Page initPage(Page page) {
        if (page == null) {
            page = new Page();
        }
        if (page.pageSize == null || page.pageSize <= 0) {
            page.setPageSize(10);
        }
        if (page.pn <= 0) {
            page.setPn(1);
        }
        return page;
    }

}
