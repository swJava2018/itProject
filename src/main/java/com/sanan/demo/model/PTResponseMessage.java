package com.sanan.demo.model;


public class PTResponseMessage {
	
	private int errCode;
    private String errMsg;  
    
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
