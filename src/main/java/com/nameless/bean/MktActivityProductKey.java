package com.nameless.bean;

import org.apache.ibatis.type.Alias;
/**
 * mybatis 中可以给 BEAN起个别名在XML中使用，如key1在
 * <select id="getProductAndStock" parameterType="key1" resultMap="BaseResultMap">中使用
 */
@Alias("key1")
public class MktActivityProductKey {
    private String productId;

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