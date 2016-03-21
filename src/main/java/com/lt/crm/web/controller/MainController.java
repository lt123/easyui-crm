package com.lt.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController{
	@RequestMapping("/main")
	public ModelAndView main(){
		System.err.println("MainController.main()");
		ModelAndView m = new ModelAndView();
		m.setViewName("main");
		return m;
	}
}
