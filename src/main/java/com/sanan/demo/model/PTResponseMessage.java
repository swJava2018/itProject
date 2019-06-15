package com.sanan.demo.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class PTResponseMessage {
	
	private int errCode;
    private String errMsg;
    private Object resData;
    
	public Object getResData() {
		return resData;
	}
	public void setResData(Object resData) {
		this.resData = resData;
	}
	public int getErrCode() {
		return errCode;
	}
	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
    
}
