package com.sanan.demo.exception;

public class SananException extends Exception {
	
	private static final long serialVersionUID = -1457638686258002156L;
	private int errCode;
	private String errReason;	
	
	public SananException(int errCode) {
		this.errCode = errCode;
		this.errReason = SananErrorCode.getErrorMessage(errCode);
	}
	
	public SananException(int errCode, Throwable e) {
		super(SananErrorCode.getErrorMessage(errCode), e);
		this.errCode = errCode;		
	}
	
	public int getErrorCode(){		
		return errCode;
	}

	@Override
	public String getMessage() {
		String retValue = SananErrorCode.getErrorMessage(errCode);
		if(errReason != null)
			retValue = "" + errReason + "";
			
		return retValue;
	}
	
	
}
