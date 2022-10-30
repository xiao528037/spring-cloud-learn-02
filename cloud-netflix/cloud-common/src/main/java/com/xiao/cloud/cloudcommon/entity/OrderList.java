package com.xiao.cloud.cloudcommon.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @projectName spring-cloud-learn-02
 * @author aloneMan
 * @createTime 2022-10-30 14:05:15
 * @description 
 */
/**
    * 订单信息
    */
public class OrderList {
    private Long id;

    /**
    * 商品数量
    */
    private Integer commodityCount;

    /**
    * 商品总价
    */
    private BigDecimal totalPricel;

    /**
    * 商品ID
    */
    private Long commodityId;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCommodityCount() {
        return commodityCount;
    }

    public void setCommodityCount(Integer commodityCount) {
        this.commodityCount = commodityCount;
    }

    public BigDecimal getTotalPricel() {
        return totalPricel;
    }

    public void setTotalPricel(BigDecimal totalPricel) {
        this.totalPricel = totalPricel;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}