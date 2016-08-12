/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.common<br/>
 * <b>文件名：</b>Test.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年6月8日-下午2:11:00<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.common;

import com.tandong.iknowbox.common.exception.ApplicationException;

/**
 *
 * Test
 * 
 * @author TanDong
 * 2016年6月8日 下午2:11:00
 * 
 * @version 1.0.0
 *
 */
public class Test {
	
	public static void main(String[] args) {
		System.out.println("test1");
		new ApplicationException("0909");
		System.out.println("test2");
	}

}
