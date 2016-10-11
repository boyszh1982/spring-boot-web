package com.nameless.bean;

import java.util.Date;

public class MktActivityProduct extends MktActivityProductKey {
    private String productName;

    private String merchant;

    private String bmerchant;

    private String plaza;

    private String store;

    private Long productPrice;

    private Long merchantSubsidy;

    private Long platformSubsidy;

    private Long activityPrice;

    private String productSource;

    private Date submitTime;

    private String addUser;

    private Date addTime;

    private String wfStatus;

    private String currUser;

    private Date lastUpdate;

    private String wfMsg;

    private String productSku;

    private String productSn;

    private String merchantId;

    private String bmerchantId;

    private String plazaId;

    private String storeId;

    private String cityId;

    private String groupId;

    private String productCode;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant == null ? null : merchant.trim();
    }

    public String getBmerchant() {
        return bmerchant;
    }

    public void setBmerchant(String bmerchant) {
        this.bmerchant = bmerchant == null ? null : bmerchant.trim();
    }

    public String getPlaza() {
        return plaza;
    }

    public void setPlaza(String plaza) {
        this.plaza = plaza == null ? null : plaza.trim();
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store == null ? null : store.trim();
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public Long getMerchantSubsidy() {
        return merchantSubsidy;
    }

    public void setMerchantSubsidy(Long merchantSubsidy) {
        this.merchantSubsidy = merchantSubsidy;
    }

    public Long getPlatformSubsidy() {
        return platformSubsidy;
    }

    public void setPlatformSubsidy(Long platformSubsidy) {
        this.platformSubsidy = platformSubsidy;
    }

    public Long getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(Long activityPrice) {
        this.activityPrice = activityPrice;
    }

    public String getProductSource() {
        return productSource;
    }

    public void setProductSource(String productSource) {
        this.productSource = productSource == null ? null : productSource.trim();
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser == null ? null : addUser.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getWfStatus() {
        return wfStatus;
    }

    public void setWfStatus(String wfStatus) {
        this.wfStatus = wfStatus == null ? null : wfStatus.trim();
    }

    public String getCurrUser() {
        return currUser;
    }

    public void setCurrUser(String currUser) {
        this.currUser = currUser == null ? null : currUser.trim();
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getWfMsg() {
        return wfMsg;
    }

    public void setWfMsg(String wfMsg) {
        this.wfMsg = wfMsg == null ? null : wfMsg.trim();
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku == null ? null : productSku.trim();
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn == null ? null : productSn.trim();
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public String getBmerchantId() {
        return bmerchantId;
    }

    public void setBmerchantId(String bmerchantId) {
        this.bmerchantId = bmerchantId == null ? null : bmerchantId.trim();
    }

    public String getPlazaId() {
        return plazaId;
    }

    public void setPlazaId(String plazaId) {
        this.plazaId = plazaId == null ? null : plazaId.trim();
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }
}