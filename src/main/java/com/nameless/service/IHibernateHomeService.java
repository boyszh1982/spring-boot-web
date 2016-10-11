package com.nameless.service;

import java.util.List;

import com.nameless.entity.MktActivityProduct;
import com.nameless.entity.MktActivityProductKey;

public interface IHibernateHomeService {
	public MktActivityProduct findOne(MktActivityProductKey id);
	public List<MktActivityProduct> findMoreByProductName(String productName);
}
