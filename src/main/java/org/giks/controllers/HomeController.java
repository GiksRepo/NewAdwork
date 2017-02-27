package org.giks.controllers;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.giks.serviceInterfaces.StudentServiceIn;
import org.giks.viewobject.HomePageVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("studentAdmissionNO")
public class HomeController 
{
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private StudentServiceIn studentService;
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap model) 
	{
		HomePageVO home = new HomePageVO();
		
		model.addAttribute("home", home);
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
	public String getStudentDetails(ModelMap model, HttpServletRequest request)
	{
		String studentAdmissionNO = (String) request.getSession().getAttribute("studentAdmissionNO");
		if(!StringUtils.isEmpty(studentAdmissionNO))
		{
			Long studentAdmissionNo = Long.valueOf(0);
			try
			{
				studentAdmissionNo = Long.valueOf(studentAdmissionNO);
			}
			catch(Exception e)
			{
				logger.error("error message "+e.getMessage());
				model.addAttribute("error", "Invalid Admission No");
				
				return "StudentDetails";
			}
			
			HomePageVO homePageVO2 = studentService.getStudentDetails(studentAdmissionNo);
			
			if(homePageVO2 == null)
				model.addAttribute("error", "Record Not Found for Admission No : "+studentAdmissionNo);
			else
				model.addAttribute("studentDetails", homePageVO2);
		}
		else
		{
			model.addAttribute("error", "Your Session is Expired.");
		}
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
	
	@RequestMapping(value = "/search-Details", method = RequestMethod.POST)
	public String searchStudentDetails(ModelMap model,@ModelAttribute HomePageVO homepageVo)
	{
		HomePageVO homePageVO2 = null;
		if(homepageVo != null)
		{
			if(!StringUtils.isEmpty(homepageVo.getAdmissionNo()))
			{
				model.addAttribute("studentAdmissionNO", homepageVo.getAdmissionNo());
				String admissionNo = homepageVo.getAdmissionNo();
				Long studentAdmissionNo = Long.valueOf(0);
				try
				{
					studentAdmissionNo = Long.valueOf(admissionNo);
				}
				catch(Exception e)
				{
					logger.error("error message "+e.getMessage());
					model.addAttribute("error", "Incorrect Admisssion No");
					
					return "StudentDetails";
				}
				homePageVO2 = studentService.getStudentDetails(studentAdmissionNo);
			
				if(homePageVO2 == null)
					model.addAttribute("error", "Record Not Found for Admission No :"+homepageVo.getAdmissionNo());
				else
					model.addAttribute("studentDetails", homePageVO2);
			}
		}
		else
		{
			logger.error("homepageVo object is null while searching date :"+new Date().getTime());
			model.addAttribute("error", "Record Not Found 404");
		}
		
			
		model.addAttribute("curl", "studentDetails");
		return "StudentDetails";
	}
}
