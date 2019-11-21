package com.sanan.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminPageController {
	
	@RequestMapping(value = {"register"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String join(Model model) {
		// 등록
		return "register";
	}
	
	@RequestMapping(value = {"list"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String list(Model model) {
		
		return "list";
	}
	
	@RequestMapping(value = {"list_one/{id}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView list_one(Model model, @PathVariable("id") int id) {
		
		ModelAndView modelAndView = new ModelAndView("list_one");
		modelAndView.addObject("id", id);
		
		return modelAndView;
	}
}
