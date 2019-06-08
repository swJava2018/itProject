package com.sanan.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sanan.demo.data.entity.Keyword;
import com.sanan.demo.data.entity.PTUser;
import com.sanan.demo.data.entity.User;
import com.sanan.demo.exception.SananErrorCode;
import com.sanan.demo.exception.SananException;
import com.sanan.demo.model.Enroll;
import com.sanan.demo.model.OpenAPIQuery;
import com.sanan.demo.model.OpenAPIResultResponse;
import com.sanan.demo.model.PTResponseMessage;
import com.sanan.demo.model.ResponseMessage;
import com.sanan.demo.service.PTUserService;

@RestController
public class UserController {
	
	@Autowired
	PTUserService userService;
	
	@RequestMapping(value = "/enroll", method = RequestMethod.POST)
    public PTResponseMessage enroll(@RequestBody Enroll enroll) throws SananException{   
		
		PTUser user = new PTUser();
		user.setId(enroll.getId());
		user.setPassword(enroll.getPwd());					
		userService.insertPTUser(user);
		
		PTResponseMessage res = new PTResponseMessage();
		res.setErrCode(SananErrorCode.SUCCESS);
		res.setErrMsg(SananErrorCode.getErrorMessage(SananErrorCode.SUCCESS));
		return res;
    }
}
