package com.sanan.demo.exception;

public class SananErrorCode {
	public static final int SUCCESS = 100;
	public static final int INTERNAL_ERROR = 101;
	
	// Search ErrorCode
	public static final int SEARCH_KEYWORD_NOT_FOUND = 102;
	
	// User ErrorCode
	public static final int USER_ALREADY_EXISTED = 103;
	public static final int USER_NOT_FOUND = 104;
	public static final int USER_LOGIN_FAIL = 105;
	
	public static String getErrorMessage(int errorCode) {
		String errMsg;
		switch (errorCode) {		
		case SEARCH_KEYWORD_NOT_FOUND:	errMsg = "검색 결과가 없습니다."; break;
		case USER_ALREADY_EXISTED:		errMsg = "이미 등록된 ID입니다."; break;
		case USER_NOT_FOUND:			errMsg = "등록되지 않은 ID입니다."; break;
		case USER_LOGIN_FAIL:			errMsg = "ID 혹은 Password가 틀렸습니다."; break;
		default:
			errMsg = "서버에서 에러가 발생했습니다."; break;
		}
		return errMsg;
	}
}
