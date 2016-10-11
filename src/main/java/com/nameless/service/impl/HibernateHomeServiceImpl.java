package com.nameless.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nameless.entity.MktActivityProduct;
import com.nameless.entity.MktActivityProductKey;
import com.nameless.repository.MktActivityProductRepository;
import com.nameless.service.IHibernateHomeService;

@Service("hibernateHomeServiceImpl")
public class HibernateHomeServiceImpl implements IHibernateHomeService {

	@Autowired
	private MktActivityProductRepository mktActivityProductRepository;
	
	@Override
	public MktActivityProduct findOne(MktActivityProductKey id) {
		return mktActivityProductRepository.findOne(id);
	}

	@Override
	public List<MktActivityProduct> findMoreByProductName(String productName) {
		return mktActivityProductRepository.findMoreByProductName(productName);
	}

}
