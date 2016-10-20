package com.nameless.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.nameless.bean.MktActivityProduct;
import com.nameless.bean.MktActivityProductKey;

public interface MktActivityProductMapper {
    int deleteByPrimaryKey(MktActivityProductKey key);

    int insert(MktActivityProduct record);

    int insertSelective(MktActivityProduct record);

    MktActivityProduct selectByPrimaryKey(MktActivityProductKey key);

    int updateByPrimaryKeySelective(MktActivityProduct record);

    int updateByPrimaryKey(MktActivityProduct record);

	MktActivityProduct getProductAndStock(MktActivityProductKey key);
	
	@Select("select product_name as productName from mkt_activity_product where recruit_id = #{p1}")
	List<MktActivityProduct> getProductList(@Param("p1") int recruitId);
}