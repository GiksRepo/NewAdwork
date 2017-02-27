package org.giks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController 
{
	@RequestMapping(value = "/405")
	public String handleAllException(Exception ex) 
	{
		return "Error";
	}
}
