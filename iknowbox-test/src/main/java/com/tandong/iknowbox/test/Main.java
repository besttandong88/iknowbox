/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.admin<br/>
 * <b>文件名：</b>main.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年9月27日-下午3:24:16<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tandong.iknowbox.admin.TestMessage;
import com.tandong.iknowbox.admin.api.DubboService;

/**
 *
 * main
 * 
 * @author TanDong
 * 2016年9月27日 下午3:24:16
 * 
 * @version 1.0.0
 *
 */
public class Main {
	
	
	public static void main(String[] args) {
		
		while(true){
		
	 
			try {
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dubbo-consumer.xml"});
				context.start();
				Thread.sleep(3000);
				
				TestMessage msg = new TestMessage();
		        DubboService testService = (DubboService)context.getBean("testDubboService"); // 获取远程服务代理
		        msg = testService.test(msg);
		 
		        System.out.println( msg.getResCode() + " " + msg.getResMsg()); // 显示调用结果
		        
		        Thread.sleep(30000);
		        
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
