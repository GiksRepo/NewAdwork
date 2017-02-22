package org.giks.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController 
{
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
			
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap model) 
	{
		
		model.addAttribute("curl", "home");
		return "Home";
	}
	
	@RequestMapping(value = "/payment-month", method = RequestMethod.GET)
	public String paymentMonth(ModelMap model)
	{
		
		model.addAttribute("curl", "paymentMonth");
		return "PaymentMonth";
	}
	
	@RequestMapping(value = "/student-fees", method = RequestMethod.GET)
	public String getStudentFees(ModelMap model)
	{
		
		model.addAttribute("curl", "studentFees");
		return "StudentFees";
	}
	
	@RequestMapping(value = "/student-details", method = RequestMethod.GET)
	public String getStudentDetails(ModelMap model)
	{
		
		model.addAttribute("curl", "studentDetails");
		return "StudentDetails";
	}
	
	@RequestMapping(value = "/payment-type", method = RequestMethod.GET)
	public String paymentMethod(ModelMap model)
	{
		
		model.addAttribute("curl", "paymentType");
		return "PaymentType";
	}
	
	@RequestMapping(value = "/payment-verified", method = RequestMethod.GET)
	public String paymentVerified(ModelMap model)
	{
		
		model.addAttribute("curl", "paymentVerify");
		return "PaymentVerify";
	}
}
