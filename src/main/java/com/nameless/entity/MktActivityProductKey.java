package com.nameless.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//主键类ID注解，调用实体中需要加上@EmbeddedId注解
@Embeddable
public class MktActivityProductKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4548458845164317232L;
	
	@Column(name="product_id")
    private String productId;

	@Column(name="recruit_id")
    private Integer recruitId;

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
}