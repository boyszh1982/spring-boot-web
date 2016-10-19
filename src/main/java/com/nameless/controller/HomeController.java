package com.nameless.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/jsp")
	public ModelAndView toJsp(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("message","大家好，欢迎来到技术交流会议！");
		mav.setViewName("hello");
		return mav ;
	}
}
