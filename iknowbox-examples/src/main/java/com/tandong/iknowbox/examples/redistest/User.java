/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.examples.redistest<br/>
 * <b>文件名：</b>User.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年11月2日-上午12:45:03<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.examples.redistest;

import java.io.Serializable;

/**
 *
 * User
 * 
 * @author TanDong
 * 2016年11月2日 上午12:45:03
 * 
 * @version 1.0.0
 *
 */
public class User implements Serializable {

	
	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;

	private String name;
	
	private int age;
	
	private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
