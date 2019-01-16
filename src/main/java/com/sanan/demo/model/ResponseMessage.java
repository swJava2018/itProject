package com.sanan.demo.model;

import java.util.List;

import com.sanan.demo.data.entity.Keyword;

public class ResponseMessage {
	
	private int errCode;
    private String errMsg;    
    private OpenAPIResultResponse openApiResult;
    private List<Keyword> latest10;
    
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
	public OpenAPIResultResponse getOpenApiResult() {
		return openApiResult;
	}
	public void setOpenApiResult(OpenAPIResultResponse openApiResult) {
		this.openApiResult = openApiResult;
	}
	public List<Keyword> getLatest10() {
		return latest10;
	}
	public void setLatest10(List<Keyword> latest10) {
		this.latest10 = latest10;
	}
    
}
