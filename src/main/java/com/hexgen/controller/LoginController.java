package com.hexgen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hexgen.model.Login;


@Controller
public class LoginController {
	
	@RequestMapping(value="/login.htm", method=RequestMethod.GET)
	public ModelAndView showLogin(){
		ModelAndView mav=new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}
	
	
	@RequestMapping(value="/loginProcess.htm",method=RequestMethod.POST)
	public ModelAndView processLogin(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("login") Login login){
		ModelAndView mav=new ModelAndView("dashboard");
		return mav;
	}
	
	@RequestMapping(value="/dashBoardData.htm",method=RequestMethod.GET)
	public ModelAndView showDashBoard(){
		ModelAndView mav=new ModelAndView("dashboard");
		return mav;
	}

}
