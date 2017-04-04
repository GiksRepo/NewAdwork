package org.giks.controllers;



import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.giks.serviceInterfaces.FeeServiceIn;

import org.giks.daos.StandardDaoImpl;
import org.giks.serviceInterfaces.StandardServiceIn;
import org.giks.serviceInterfaces.StudentServiceIn;
import org.giks.services.FeeService;
import org.giks.viewobject.FeeVO;
import org.giks.viewobject.HomePageVO;
import org.giks.viewobject.PayMonthVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController 
{
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private StudentServiceIn studentService;

	@Autowired
	private FeeServiceIn feeService;
	
	@Autowired
	private StandardServiceIn standardService;

		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap model, HttpServletRequest request) 
	{	
		System.out.println("cont : "+studentService.getAcademicSession());
		request.getSession(true).setAttribute("academicSession", studentService.getAcademicSession());;
		HomePageVO home = new HomePageVO();
		home.setStandardList(standardService.getAllStandard());
		model.addAttribute("home", home);
		model.addAttribute("curl", "home");
		return "Home";
	}
	
	@RequestMapping(value = "/payment-month", method = RequestMethod.GET)
	public String paymentMonth(ModelMap model, HttpServletRequest request)
	{	
		HttpSession session = request.getSession();
		String studentAdmissionNO = (String) session.getAttribute("studentAdmissionNO");
		if(!StringUtils.isEmpty(studentAdmissionNO))
		{
			PayMonthVO payMonthVo = new PayMonthVO();
			payMonthVo.setAdmissionNo(studentAdmissionNO);
			try{
			payMonthVo = feeService.getFromFee(payMonthVo);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(!StringUtils.isEmpty(payMonthVo.getError()))
			{
				model.addAttribute("studentDetails", payMonthVo);
				model.addAttribute("curl", "paymentMonth");
				return "PaymentMonth";
			}else
			{
				model.addAttribute("studentDetails", payMonthVo);
				model.addAttribute("curl", "paymentMonth");
				return "PaymentMonth";
			}
		}
		else
		{
			HomePageVO homePageVO = new HomePageVO();
			homePageVO.setError("Session expired!");
			model.addAttribute("home", homePageVO);
			model.addAttribute("curl", "home");
			return "Home";
		}
	}
	
	@RequestMapping(value = "/payment-month", method = RequestMethod.POST)
	public String findPayment(ModelMap model, @ModelAttribute PayMonthVO payMonthVo, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		String studentAdmissionNO = (String) session.getAttribute("studentAdmissionNO");
		if(!StringUtils.isEmpty(studentAdmissionNO))
		{
			payMonthVo.setAdmissionNo(studentAdmissionNO);
			FeeVO feeVO = feeService.getAllFees(payMonthVo); 
			if(!StringUtils.isEmpty(feeVO.getError()))
			{
				payMonthVo.setError(feeVO.getError());
				model.addAttribute("studentDetails", payMonthVo);
				model.addAttribute("curl", "paymentMonth");
				return "PaymentMonth";
			}else
			{
				try{
				String toMonth = (String) session.getAttribute("toMonthSession");
				String toMonthUI = payMonthVo.getToMonth() + "";
				if(StringUtils.isEmpty(toMonth))
					session.setAttribute("toMonthSession", toMonthUI);
				else{
					if(!toMonthUI.equalsIgnoreCase(toMonth))
						session.setAttribute("toMonthSession", toMonthUI);
				}
				model.addAttribute("studentDetails", feeVO);
				model.addAttribute("curl", "studentFees");
				}catch (Exception e) {
					e.printStackTrace();
				}
				return "StudentFees";
			}
		}
		else
		{
			HomePageVO homepageVo = new HomePageVO();
			homepageVo.setError("Session expired!");
			homepageVo.setStandardList(standardService.getAllStandard());
			model.addAttribute("home", homepageVo);
			model.addAttribute("curl", "home");
			return "Home";
		}
	}
	
	@RequestMapping(value = "/student-fees", method = RequestMethod.GET)
	public String getStudentFees(ModelMap model, HttpServletRequest request)
	{
		try{
		PayMonthVO payMonthVO = new PayMonthVO();
		HttpSession session = request.getSession();
		String studentAdmissionNO = (String) session.getAttribute("studentAdmissionNO");
		String toMonth = (String) session.getAttribute("toMonthSession");
		payMonthVO.setAdmissionNo(studentAdmissionNO);
		FeeVO feeVO = new FeeVO();
		if(!StringUtils.isEmpty(studentAdmissionNO))
		{
			if(!StringUtils.isEmpty(toMonth)){
				payMonthVO.setToMonth(Integer.valueOf(toMonth));
				feeVO = feeService.getAllFees(payMonthVO);
				if(!StringUtils.isEmpty(feeVO.getError()))
				{
					System.out.println("err : "+feeVO.getError());
					payMonthVO.setError(feeVO.getError());
					payMonthVO.setFromMonth(feeVO.getFromMonth());
					model.addAttribute("studentDetails", feeVO);
					model.addAttribute("curl", "StudentFees");
					return "StudentFees";
				}
			}
			model.addAttribute("studentDetails", feeVO);
			model.addAttribute("curl", "studentFees");
			return "StudentFees";
		}
		else
		{
			HomePageVO homePageVO = new HomePageVO();
			homePageVO.setError("Session expired!");
			model.addAttribute("home", homePageVO);
			model.addAttribute("curl", "home");
			return "Home";
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Home";
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
				homepageVo.setStandardList(standardService.getAllStandard());
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
			homepageVo.setStandardList(standardService.getAllStandard());
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
			homepageVo.setStandardList(standardService.getAllStandard());
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
	
	@ExceptionHandler({Exception.class})
	public ModelAndView handleException(Exception exception)
	{
		exception.printStackTrace();
		ModelAndView model = new ModelAndView("Exception");
		model.addObject("errorMessage", exception.getCause());
		return model;
	}
}
