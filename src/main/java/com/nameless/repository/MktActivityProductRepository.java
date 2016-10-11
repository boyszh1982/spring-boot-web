package com.nameless.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nameless.entity.MktActivityProduct;
import com.nameless.entity.MktActivityProductKey;

public interface MktActivityProductRepository extends CrudRepository<MktActivityProduct , MktActivityProductKey>{
	
	@Override
	public MktActivityProduct findOne(MktActivityProductKey id);
	
	@Query("select T from MktActivityProduct T where T.productName like %:productName%")
	public List<MktActivityProduct> findMoreByProductName(@Param("productName") String productName);
	
}
