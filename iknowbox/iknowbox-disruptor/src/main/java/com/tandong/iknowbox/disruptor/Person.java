/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.konwbox.disruptor<br/>
 * <b>文件名：</b>RingBuffer.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年1月19日-下午2:22:10<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.disruptor;

/**
 *
 * RingBuffer
 * 
 * @author TanDong 2016年1月19日 下午2:22:10
 * 
 * @version 1.0.0
 *
 */
public class Person {

	private String name;
	private int age;
	private String gender;
	private String mobile;

	public Person() {
	}

	public Person(String name, int age, String gender, String mobile) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mobile = mobile;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
