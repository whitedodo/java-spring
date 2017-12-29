package com.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.OrclMemberDAOImpl;
import com.project.model.Member;
import com.project.validator.LoginValidator;

@Controller
public class MemberController {

	//static Logger log = Logger.getLogger(MemberController.class.getName());
	
	// 로그인 페이지
	@GetMapping("/Member/Login")
	public String viewLogin( Model m ) {
	   
		//ModelAndView mav = new ModelAndView();
		
		//mav.setViewName("member/login");
		//mav.addObject("command", new Member() );
		
		//log.info("Hello");
		m.addAttribute("loginValidated", new Member() );
		
		return "member/login";
	    
	}
	
	
	@PostMapping("/Member/Login")
	public String doLogin(@Valid Member member, BindingResult result,
									Model m) {
	   
	    new LoginValidator().validate(member, result);
	    
	    m.addAttribute("loginValidated", member);
	    
	    if ( result.hasErrors() )
	    {
	    	List<String> errorMessage = new ArrayList<String>();
	    	List<ObjectError> allErrors = result.getAllErrors(); 
	    	
	    	for ( ObjectError objError : allErrors ) {
	    		
	    		String message = objError.getCode();
	    		errorMessage.add(message);
	    		//System.out.print(message);
			}
	    	
	    	return "member/login";
	    }
	    	
	    m.addAttribute("message", "Successfully saved phone:");	
	    
	    return "member/login";
		
	}
	
	
	
	// 회원가입 페이지
	@RequestMapping(value = "/Member/Join", method = RequestMethod.GET)
	public ModelAndView join() {
	   
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/join");
		
		return mav;
	   
	}
}
