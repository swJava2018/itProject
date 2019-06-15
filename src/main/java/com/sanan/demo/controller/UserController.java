package com.sanan.demo.controller;

import java.util.ArrayList;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sanan.demo.data.entity.PTUser;
import com.sanan.demo.exception.SananErrorCode;
import com.sanan.demo.exception.SananException;
import com.sanan.demo.model.Enroll;
import com.sanan.demo.model.Login;
import com.sanan.demo.model.PTResponseMessage;
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
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public PTResponseMessage login(@RequestBody Login login) throws SananException{   
		PTResponseMessage res = new PTResponseMessage();
		
		PTUser user = userService.selectPTUser(login.getId());
		if(user != null) {
			res.setErrCode(SananErrorCode.SUCCESS);
			res.setErrMsg(SananErrorCode.getErrorMessage(SananErrorCode.SUCCESS));
		}
		else {
			throw new SananException(SananErrorCode.USER_NOT_FOUND);
		}
		
		return res;
    }
	
	@RequestMapping(value = "/getProjList", method = RequestMethod.POST)
    public PTResponseMessage getProjList() throws SananException{   
		PTResponseMessage res = new PTResponseMessage();
		res.setErrCode(SananErrorCode.SUCCESS);
		res.setErrMsg(SananErrorCode.getErrorMessage(SananErrorCode.SUCCESS));
		
		{
			ArrayList<String> arr = new ArrayList<String>();
			arr.add("안산대 윈도우프로그래밍 대회");
			arr.add("서울대 해킹 동아리 데프콘 대회");
			arr.add("서울산업대 자유주제 대회");
			res.setResData(arr);
		}
		
		return res;
    }
	
	@ExceptionHandler(SananException.class)
	public PTResponseMessage handleAllException(SananException e) {
		PTResponseMessage res = new PTResponseMessage();
		res.setErrCode(SananErrorCode.FAIL);
		
		String errMsg = SananErrorCode.getErrorMessage(e.getErrorCode());
		errMsg += " (" + e.getErrorCode() + ")";
		res.setErrMsg(errMsg);
		return res;
	}
}
