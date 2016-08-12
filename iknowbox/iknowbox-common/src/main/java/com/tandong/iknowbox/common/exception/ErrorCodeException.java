package com.tandong.iknowbox.common.exception;

/**
 * 继承ApplicationException，用户能够设置异常码、异常码的参数
 * 
 * @author TanDong
 *
 */
public class ErrorCodeException extends ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public ErrorCodeException(String errCode) {
		super(errCode);
	}
	
}
