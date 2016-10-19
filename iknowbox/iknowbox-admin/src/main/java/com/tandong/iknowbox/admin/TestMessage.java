/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.admin.dubbo<br/>
 * <b>文件名：</b>TestMessage.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年9月27日-下午2:45:31<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.admin;

import java.io.Serializable;

/**
 *
 * TestMessage
 * 
 * @author TanDong
 * 2016年9月27日 下午2:45:31
 * 
 * @version 1.0.0
 *
 */
public class TestMessage implements Serializable {

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;
	
	public TestMessage(String resCode, String resMsg){
		this.resCode = resCode;
		this.resMsg = resMsg;
	}
	
	private String memNo;
	
	private String accType;
	
	private String amt;
	
	private String resCode;
	
	private String resMsg;

	public String getMemNo() {
		return memNo;
	}

	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
}
