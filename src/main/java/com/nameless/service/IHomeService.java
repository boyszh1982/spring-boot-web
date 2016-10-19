package com.nameless.service;

import com.nameless.bean.MktActivityProduct;
import com.nameless.bean.MktActivityProductKey;

public interface IHomeService {

	public String toHome(String msg);
	
	public String toTrans();
	
	public MktActivityProduct getProductAndStock(MktActivityProductKey key);
}
