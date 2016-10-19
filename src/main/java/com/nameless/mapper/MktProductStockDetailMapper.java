package com.nameless.mapper;

import com.nameless.bean.MktProductStockDetail;
import com.nameless.bean.MktProductStockDetailKey;

public interface MktProductStockDetailMapper {
    int deleteByPrimaryKey(MktProductStockDetailKey key);

    int insert(MktProductStockDetail record);

    int insertSelective(MktProductStockDetail record);

    MktProductStockDetail selectByPrimaryKey(MktProductStockDetailKey key);

    int updateByPrimaryKeySelective(MktProductStockDetail record);

    int updateByPrimaryKey(MktProductStockDetail record);
}