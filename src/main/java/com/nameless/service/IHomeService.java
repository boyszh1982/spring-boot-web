package com.nameless.service;

import java.util.List;

import com.nameless.bean.MktActivityProduct;
import com.nameless.bean.MktActivityProductKey;

public interface IHomeService {

	public String toHome(String msg);
	
	public String toTrans();
	
	public MktActivityProduct getProductAndStock(MktActivityProductKey key);
	
	public List<MktActivityProduct> getProductList(int recruitId);
}
