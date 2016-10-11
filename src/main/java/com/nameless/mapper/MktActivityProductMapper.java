package com.nameless.mapper;

import com.nameless.bean.MktActivityProduct;
import com.nameless.bean.MktActivityProductKey;

public interface MktActivityProductMapper {
    int deleteByPrimaryKey(MktActivityProductKey key);

    int insert(MktActivityProduct record);

    int insertSelective(MktActivityProduct record);

    MktActivityProduct selectByPrimaryKey(MktActivityProductKey key);

    int updateByPrimaryKeySelective(MktActivityProduct record);

    int updateByPrimaryKey(MktActivityProduct record);
}