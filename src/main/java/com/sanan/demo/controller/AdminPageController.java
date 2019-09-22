package com.sanan.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminPageController {
	
	@RequestMapping(value = {"register"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String join(Model model) {
		
		return "sb/register";
	}
}
