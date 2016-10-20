package com.nameless.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.nameless.bean.MktActivityProduct;
import com.nameless.bean.MktActivityProductKey;
import com.nameless.properties.JdbcProp;
import com.nameless.service.IHomeService;

@RestController
@RequestMapping("/")
public class HomeController {

	/**
	 * 用@Value读取配置文件
	 */
	@Value("${spring.application.helloworld}") 
	private String hello;
	
	/**
	 * 用@Component @ConfigurationProperties(locations = "classpath:jdbc.properties",prefix="jdbc")
	 * 见JdbcProp.java
	 * 读取配置文件
	 */
	@Autowired
	@Qualifier("jdbcProp")
	private JdbcProp jdbcProp ;
	
	@Autowired
	@Qualifier("homeServiceImpl")
	private IHomeService homeService;
	
	@RequestMapping("/home")
	public String toHome(){
		homeService.toTrans();
		return homeService.toHome("Sunzhenhua") + "," + hello + " <<<< " + jdbcProp.getHelloworld();
	}
	
	//http://www.mybatis.org/mybatis-3/zh/dynamic-sql.html
	@RequestMapping("/jsp")
	public ModelAndView toJsp(){
		MktActivityProductKey key = new MktActivityProductKey();
		key.setProductId("1000010205-9052724");
		key.setRecruitId(34414);
		MktActivityProduct product = homeService.getProductAndStock(key);
		System.out.println(JSON.toJSONString(product));
		ModelAndView mav = new ModelAndView();
		mav.addObject("message","大家好，欢迎来到技术交流会议！");
		mav.addObject("product", product);
		mav.setViewName("hello");
		return mav ;
	}
	
	@RequestMapping("/jsp2")
	public ModelAndView toJsp2(){
		List<MktActivityProduct> productList = homeService.getProductList(34414);
		System.out.println(JSON.toJSONString(productList));
		ModelAndView mav = new ModelAndView();
		mav.addObject("productList",productList);
		mav.setViewName("hello2");
		return mav;
	}
	
}
