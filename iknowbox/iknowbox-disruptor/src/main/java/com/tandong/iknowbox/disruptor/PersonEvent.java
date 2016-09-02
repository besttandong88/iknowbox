/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.konwbox.disruptor<br/>
 * <b>文件名：</b>PersonEvent.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年1月19日-下午2:36:26<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 *
 * PersonEvent
 * 
 * @author TanDong 2016年1月19日 下午2:36:26
 * 
 * @version 1.0.0
 *
 */
public class PersonEvent {

	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public final static  EventFactory<PersonEvent> EVENT_FACTORY = new EventFactory<PersonEvent>(){
        public PersonEvent newInstance(){
            return new PersonEvent();
        }
    };
}
