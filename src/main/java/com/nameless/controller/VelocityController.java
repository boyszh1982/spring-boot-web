package com.nameless.controller;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/velocity")
@Log4j2
public class VelocityController {

	@RequestMapping("hello")
	public ModelAndView hello(HttpServletRequest request){
		String ctx = request.getContextPath();
		log.info("/*****************/");
		log.info("/*****************/");
		log.info("/*****************/");
		log.info("/*****************/");
		log.info(ctx);
		log.info("/*****************/");
		log.info("/*****************/");
		log.info("/*****************/");
		log.info("/*****************/");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("welcome");
		mav.addObject("message", new java.util.Date());
		return mav;
	}
}
