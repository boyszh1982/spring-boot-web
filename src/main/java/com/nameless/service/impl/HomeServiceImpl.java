package com.nameless.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nameless.bean.MktActivityProduct;
import com.nameless.bean.MktActivityProductKey;
import com.nameless.dao.IDBTest;
import com.nameless.mapper.MktActivityProductMapper;
import com.nameless.service.IHomeService;

@Service("homeServiceImpl")
public class HomeServiceImpl implements IHomeService {

	@Autowired
	@Qualifier("DBTestImpl")
	private IDBTest dbtest;
	
	@Autowired
	private MktActivityProductMapper activityProductMapper ;
	
	@Override
	public String toHome(String msg) {
		StringBuffer result = new StringBuffer(msg);
		result.append("Hello World !");
		result.append(new java.util.Date());
		result.append(".....");
		result.append(dbtest.hello("abc"));
		result.append("[");
		
		MktActivityProductKey key = new MktActivityProductKey();
		key.setProductId("1000010205-9052724");
		key.setRecruitId(34414);
		MktActivityProduct product = activityProductMapper.selectByPrimaryKey(key);
		result.append(product.getProductName());
		result.append("]");
		return result.toString();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String toTrans() {

		MktActivityProduct product = new MktActivityProduct();
		product.setProductId("1000010205-9052724");
		product.setRecruitId(34414);
		product.setWfStatus("PA_START");
		int cnt = activityProductMapper.updateByPrimaryKeySelective(product);
		
		MktActivityProduct product2 = new MktActivityProduct();
		product2.setProductId("0");
		product2.setRecruitId(0);
		product2.setWfStatus("PA_START");
		int cnt2 = activityProductMapper.updateByPrimaryKeySelective(product2);
		
		System.out.println("cnt2="+cnt2);
		
		if(cnt2 != 1){
			throw new RuntimeException("事物异常！");
		}
		return "success";
		
	}

	@Override
	public MktActivityProduct getProductAndStock(MktActivityProductKey key) {
		// TODO Auto-generated method stub
		return activityProductMapper.getProductAndStock(key);
	}
	
	

}
