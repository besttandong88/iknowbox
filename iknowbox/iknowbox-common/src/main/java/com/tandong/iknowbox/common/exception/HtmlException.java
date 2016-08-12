package com.tandong.iknowbox.common.exception;

/**
 * 继承ApplicationException，用户能够设置html信息，该信息用于局部替换错误页面内容
 * 
 * @author TanDong
 *
 */
public class HtmlException extends ApplicationException {
	
	private static final long serialVersionUID = 1L;
	
	private String html;//局部替换错误页面内容
	
	public HtmlException(String errCode, String html) {
		super(errCode);
		this.html = html;
	}

	public HtmlException(String errCode) {
		super(errCode);
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}
}
