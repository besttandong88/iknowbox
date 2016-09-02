/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.konwbox.disruptor<br/>
 * <b>文件名：</b>PersonEventHandler.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年1月19日-下午2:38:01<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 *
 * PersonEventHandler
 * 
 * @author TanDong 2016年1月19日 下午2:38:01
 * 
 * @version 1.0.0
 *
 */
public class PersonEventHandler implements EventHandler<PersonEvent> {

	public PersonEventHandler() {
		// DataSendHelper.start();
	}

	public void onEvent(PersonEvent event, long sequence, boolean endOfBatch) throws Exception {
		Person person = event.getPerson();
		System.out.println("name = " + person.getName() + ", age = " + person.getAge() + ", gender = "
				+ person.getGender() + ", mobile = " + person.getMobile());
	}

}
