package com.tandong.iknowbox.common.exception;

public class BaseException extends Exception{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2182788441742594189L;
	
	public BaseException(String msg){
		super(msg);
	}
	public BaseException(Throwable e){
		super(e);
	}
	public BaseException(String msg ,Throwable e){
		super(msg,e);
	}

}
