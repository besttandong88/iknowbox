package com.tandong.iknowbox.common.exception.api;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

@Component("propertiesMessageResolver")
public class PropertiesMessageResolver implements ExceptionResolver {
	
	private static final ResourceBundle resBundle = ResourceBundle.getBundle("messages");

	public String getMessage(String code, Locale locale, Object[] args) {
		String errMsg = "";
		if (code != null) {
			errMsg = resBundle.getString(code);
			if (args != null) {
				errMsg = MessageFormat.format(errMsg, args);
			}
		} 
		return errMsg;
	}

}
