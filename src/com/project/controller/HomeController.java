package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	// 포탈 홈페이지
	@RequestMapping(value = "/Portal", method = RequestMethod.GET)
	public ModelAndView index() {
	   
		ModelAndView mav = new ModelAndView();
		mav.setViewName("website/tpl-layout");
		
		return mav;
	   
	}
	
}
