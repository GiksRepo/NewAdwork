package org.giks.controllers;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.giks.serviceInterfaces.StudentServiceIn;
import org.giks.viewobject.HomePageVO;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
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
			HomePageVO homePageVO = new HomePageVO();
			homePageVO.setAdmissionNo(studentAdmissionNO);
			HomePageVO homePageVO2 = studentService.getStudentDetails(homePageVO);
			
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
	public String searchStudentDetails(ModelMap model,@ModelAttribute HomePageVO homepageVo, HttpServletRequest request)
	{
		homepageVo = studentService.getStudentDetails(homepageVo); 
		if(!StringUtils.isEmpty(homepageVo.getError()))
		{
			model.addAttribute("home", homepageVo);
			model.addAttribute("curl", "home");
			return "Home";
		}else
		{
			createSession(request, homepageVo.getAdmissionNo());
			model.addAttribute("studentDetails", homepageVo);
			model.addAttribute("curl", "studentDetails");
			return "StudentDetails";
		}
	}
	
	private void createSession(HttpServletRequest request, String studentAdmissionNO)
	{
		HttpSession session = request.getSession(true);
		String sessionAdmission = (String) session.getAttribute("studentAdmissionNO");
			if(!StringUtils.isEmpty(sessionAdmission) && !sessionAdmission.equals(studentAdmissionNO))
			{
				session.invalidate();
				session = request.getSession(true);
			}
			session.setAttribute("studentAdmissionNO", studentAdmissionNO);
	}
}
