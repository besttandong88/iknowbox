/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.concurrent<br/>
 * <b>文件名：</b>SingletonTest.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年4月28日-下午4:03:55<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.concurrent;

/**
 *
 * SingletonTest
 * 线程安全、高效且简洁的单例模式
 * 
 * @author TanDong 2016年4月28日 下午4:03:55
 * 
 * @version 1.0.0
 *
 */
public class SingletonTest {
	
	//私有的静态内部类
	private static class Inner {
		static SingletonTest singletonTest = new SingletonTest();
	}

	public static SingletonTest getInstance() {
		return Inner.singletonTest;
	}
	
	public static void main(String[] args){
		SingletonTest.getInstance();
	}
}
