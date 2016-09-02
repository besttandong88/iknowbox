/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.concurrent.nio<br/>
 * <b>文件名：</b>ChatClient.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年4月12日-下午4:55:41<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.concurrent.nio;

/**
 *
 * ChatClient
 * 
 * @author TanDong
 * 2016年4月12日 下午4:55:41
 * 
 * @version 1.0.0
 *
 */
public class ChatClient {
	
	private String name;
	
	public ChatClient(String name){
		this.name = name;
	}
	
	public void start(){
		System.out.println("I'm online...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
