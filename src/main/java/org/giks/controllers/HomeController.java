package org.giks.controllers;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String paymentMonth(ModelMap model, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		String studentAdmissionNO = (String) session.getAttribute("studentAdmissionNO");
		HomePageVO homepageVo = new HomePageVO();
		if(!StringUtils.isEmpty(studentAdmissionNO))
		{
			homepageVo.setAdmissionNo(studentAdmissionNO);
			homepageVo = studentService.getStudentDetails(homepageVo); 
			if(!StringUtils.isEmpty(homepageVo.getError()))
			{
				session.invalidate();
				homepageVo.setError("Session expired!");
				model.addAttribute("home", homepageVo);
				model.addAttribute("curl", "home");
				return "Home";
			}else
			{
				model.addAttribute("studentDetails", homepageVo);
				model.addAttribute("curl", "paymentMonth");
				return "PaymentMonth";
			}
		}
		else
		{
			homepageVo.setError("Session expired!");
			model.addAttribute("home", homepageVo);
			model.addAttribute("curl", "home");
			return "Home";
		}
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
		HttpSession session = request.getSession();
		String studentAdmissionNO = (String) session.getAttribute("studentAdmissionNO");
		HomePageVO homepageVo = new HomePageVO();
		if(!StringUtils.isEmpty(studentAdmissionNO))
		{
			homepageVo.setAdmissionNo(studentAdmissionNO);
			homepageVo = studentService.getStudentDetails(homepageVo); 
			if(!StringUtils.isEmpty(homepageVo.getError()))
			{
				session.invalidate();
				homepageVo.setError("Session expired!");
				model.addAttribute("home", homepageVo);
				model.addAttribute("curl", "home");
				return "Home";
			}else
			{
				model.addAttribute("studentDetails", homepageVo);
				model.addAttribute("curl", "studentDetails");
				return "StudentDetails";
			}
		}
		else
		{
			homepageVo.setError("Session expired!");
			model.addAttribute("home", homepageVo);
			model.addAttribute("curl", "home");
			return "Home";
		}
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
			HttpSession session = request.getSession();
			session.invalidate();
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
	
	private void destroySession(HttpServletRequest request){
		
	}
}
