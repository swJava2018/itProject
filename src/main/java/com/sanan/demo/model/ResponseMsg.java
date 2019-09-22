package com.sanan.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMsg {
	private int resCode;
	private String resMsg;
	private Object result;
	
	
}