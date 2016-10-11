package com.nameless.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nameless.entity.MktActivityProduct;
import com.nameless.entity.MktActivityProductKey;
import com.nameless.service.impl.HibernateHomeServiceImpl;

@RestController
@RequestMapping("/hibernate")
public class HibernateHomeController {

	@Autowired
	private HibernateHomeServiceImpl hibernateHomeServiceImpl;
	
	@RequestMapping("/home")
	public @ResponseBody MktActivityProduct toHome(){
		MktActivityProductKey mktActivityProductKey = new MktActivityProductKey();
		mktActivityProductKey.setRecruitId(34414);
		mktActivityProductKey.setProductId("1000010205-9052724");
		return hibernateHomeServiceImpl.findOne(mktActivityProductKey);
	}
	
	@RequestMapping("/like")
	public @ResponseBody List<MktActivityProduct> toLike(
			@RequestParam(value="productName", required=true) String productName
			){
		return hibernateHomeServiceImpl.findMoreByProductName(productName);
	}
}
