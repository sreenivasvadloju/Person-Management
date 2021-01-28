package com.mars.exceptionhandler;


public class CustomGenericException extends RuntimeException {

	private static final long serialVersionUID = 1L;


	private String errMsg;

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public CustomGenericException(String errMsg) {
		this.errMsg = errMsg;
	}

}