package com.nameless.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
//@IdClass(MktActivityProductKey.class) 这个注解用法是什么
@Table(name="mkt_activity_product")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class MktActivityProduct implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5201651683836045709L;

	@EmbeddedId
	private MktActivityProductKey mktActivityProductKey;
	
	public MktActivityProductKey getMktActivityProductKey() {
		return mktActivityProductKey;
	}

	public void setMktActivityProductKey(MktActivityProductKey mktActivityProductKey) {
		this.mktActivityProductKey = mktActivityProductKey;
	}

	@Column(name="product_name")
    private String productName;
	
	@Column(name="merchant")
    private String merchant;

	@Column(name="bmerchant")
    private String bmerchant;

	@Column(name="plaza")
    private String plaza;

	@Column(name="store")
    private String store;

	@Column(name="product_price")
    private Long productPrice;

	@Column(name="merchant_subsidy")
    private Long merchantSubsidy;

	@Column(name="platform_subsidy")
    private Long platformSubsidy;

	@Column(name="activity_price")
    private Long activityPrice;

	@Column(name="product_source")
    private String productSource;

	@Column(name="submit_time")
    private Date submitTime;

	@Column(name="add_user")
    private String addUser;

	@Column(name="add_time")
    private Date addTime;

	@Column(name="wf_status")
    private String wfStatus;

	@Column(name="curr_user")
    private String currUser;

	@Column(name="last_update")
    private Date lastUpdate;

	@Column(name="wf_msg")
    private String wfMsg;

	@Column(name="product_sku")
    private String productSku;

	@Column(name="product_sn")
    private String productSn;

	@Column(name="merchant_id")
    private String merchantId;

	@Column(name="bmerchant_id")
    private String bmerchantId;

	@Column(name="plaza_id")
    private String plazaId;

	@Column(name="store_id")
    private String storeId;

	@Column(name="city_id")
    private String cityId;

	@Column(name="group_id")
    private String groupId;

	@Column(name="product_code")
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