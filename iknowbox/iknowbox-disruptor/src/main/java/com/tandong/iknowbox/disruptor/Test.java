/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.konwbox.disruptor<br/>
 * <b>文件名：</b>Test.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年1月19日-下午2:39:11<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.disruptor;

/**
 *
 * Test
 * 
 * @author TanDong 2016年1月19日 下午2:39:11
 * 
 * @version 1.0.0
 *
 */
public class Test {

	public static void main(String[] args) {
		PersonHelper.start();
		for (int i = 0; i < 200; i++) {
			Person p = new Person("jbgtwang" + i, i, "男", "1234566" + i);

			// 生产者生产数据
			PersonHelper.produce(p);
		}
	}
}
