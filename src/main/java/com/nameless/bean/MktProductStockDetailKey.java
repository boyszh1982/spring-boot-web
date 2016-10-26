package com.nameless.bean;

import java.io.Serializable;

public class MktProductStockDetailKey implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7094218428400519034L;

	private String productId;

    private Integer recruitId;

    private String stockCode;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public Integer getRecruitId() {
        return recruitId;
    }

    public void setRecruitId(Integer recruitId) {
        this.recruitId = recruitId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode == null ? null : stockCode.trim();
    }
}