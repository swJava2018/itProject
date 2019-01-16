package com.sanan.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sanan.demo.data.entity.User;
import com.sanan.demo.exception.SananErrorCode;
import com.sanan.demo.exception.SananException;
import com.sanan.demo.model.Enroll;
import com.sanan.demo.model.Login;
import com.sanan.demo.service.UserService;

@Controller
public class PageController {

	@Autowired
	UserService userService;
	
	private static final String SESSION_ID = "user_id";
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	
	@RequestMapping(value = {"", "/", "/index"}, method = {RequestMethod.GET})
	public String index(HttpSession session) {
		if (session.getAttribute(SESSION_ID) == null) {
			return "login";
		}
		
		return "index";
	}
	
	@RequestMapping(value="/logout", method = {RequestMethod.GET})
	public String logout(HttpSession session) {
		session.removeAttribute(SESSION_ID);
		return "login";
	}
	
	@RequestMapping(value="/login", method = {RequestMethod.POST})
	public ModelAndView loginPost(Login login, HttpSession session) throws SananException {
		session.removeAttribute(SESSION_ID);
		
		ModelAndView modelAndView;
		
		User selected_user = userService.selectUser(login.getId());
		if(selected_user == null) 
			throw new SananException(SananErrorCode.USER_NOT_FOUND);		
		
		if (passwordEncoder.matches(login.getPassword(), selected_user.getPassword())) {
			modelAndView = new ModelAndView("redirect:index");
			session.setAttribute(SESSION_ID, login.getId());
			return modelAndView;
			
		} else {
			throw new SananException(SananErrorCode.USER_LOGIN_FAIL);
		}
	}
	
	@RequestMapping(value = "/login", method = {RequestMethod.GET})
	public ModelAndView login(HttpSession session) {		
		ModelAndView modelAndView;		
		if (session.getAttribute(SESSION_ID) != null) {
			modelAndView = new ModelAndView("redirect:index");
			return modelAndView;
		}
		
		modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@RequestMapping(value="/enroll", method = {RequestMethod.POST})
	public ModelAndView enrollPost(Enroll enroll, HttpSession session) throws SananException {
		session.removeAttribute(SESSION_ID);
		
		ModelAndView modelAndView;
		
		User user = new User();
		user.setId(enroll.getId());
		user.setPassword(passwordEncoder.encode(enroll.getPassword()));					
		userService.insertUser(user);
		modelAndView = new ModelAndView("redirect:index");
		session.setAttribute(SESSION_ID, enroll.getId());
		return modelAndView;
	}
	
	@RequestMapping(value = "/enroll", method = {RequestMethod.GET})
	public String enroll(Model model) {
		return "enroll";
	}
	
	@ExceptionHandler(SananException.class)
	public ModelAndView handleAllException(HttpServletRequest request, SananException e) {
		String view = request.getRequestURI().replace("/", "");
		ModelAndView modelAndView = new ModelAndView(view);
		modelAndView.addObject("error", e.getMessage());
		return modelAndView;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception e) {
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("error", SananErrorCode.getErrorMessage(SananErrorCode.INTERNAL_ERROR));
		return modelAndView;
	}
}
