package com.sanan.demo.utils;

public class HttpException extends Exception {
	
	private static final long serialVersionUID = 7410787534146177056L;
	private int errCode = 0;	
	private String resJSON;
	private String errMsg;

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getResJSON() {
		return resJSON;
	}

	public void setResJSON(String resJSON) {
		this.resJSON = resJSON;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public HttpException(int errCode, String resJSON, String errMsg) {
		super();
		this.errCode = errCode;
		this.resJSON = resJSON;
		this.errMsg = errMsg;
	}	
}
