package com.hexgen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hexgen.model.Customer;
import com.hexgen.services.CustomerService;


@Controller
public class UploadedDataController {
	
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/UploadedData.htm",method=RequestMethod.GET)
	public ModelAndView processUploadData(){
		List<Customer> customerList=customerService.getAllCustomer();
		ModelAndView mav=new ModelAndView("uploaddata");
		mav.addObject("custList", customerList);
		return mav;
		
	}

}
