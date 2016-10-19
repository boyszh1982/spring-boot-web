package com.nameless.bean;

public class MktProductStockDetail extends MktProductStockDetailKey {
    private Long stockNum;

    private Long agreeNum;

    private String skuId;

    private String skuSn;

    public Long getStockNum() {
        return stockNum;
    }

    public void setStockNum(Long stockNum) {
        this.stockNum = stockNum;
    }

    public Long getAgreeNum() {
        return agreeNum;
    }

    public void setAgreeNum(Long agreeNum) {
        this.agreeNum = agreeNum;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId == null ? null : skuId.trim();
    }

    public String getSkuSn() {
        return skuSn;
    }

    public void setSkuSn(String skuSn) {
        this.skuSn = skuSn == null ? null : skuSn.trim();
    }
}