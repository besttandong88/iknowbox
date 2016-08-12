package com.tandong.iknowbox.common.exception;

public class SystemException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
    
    public SystemException() {
    }
    
    public SystemException(String msg) {
    	super(msg);
    }
    
    public SystemException(String msg, Throwable e) {
    	super(msg, e);
    }
    
    public SystemException(Throwable e) {
    	super(e);
    }
}