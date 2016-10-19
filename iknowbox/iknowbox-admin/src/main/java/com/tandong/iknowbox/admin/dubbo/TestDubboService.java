/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.admin.dubbo<br/>
 * <b>文件名：</b>TestDubboService.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年9月22日-上午9:59:26<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.admin.dubbo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.tandong.iknowbox.admin.TestMessage;
import com.tandong.iknowbox.admin.api.DubboService;

/**
 *
 * TestDubboService
 * 
 * @author TanDong
 * 2016年9月22日 上午9:59:26
 * 
 * @version 1.0.0
 *
 */
@Service("testDubboService")
public class TestDubboService implements DubboService {
	
	private static Log logger = LogFactory.getLog(TestDubboService.class);

	/* (non-Javadoc)
	 * @see com.tandong.iknowbox.admin.api.DubboService#sayHello(java.lang.String)
	 */
	public String sayHello(String name) {
		String str = "Hello "+name;
		logger.debug(str);
		return str;
	}
	
	public TestMessage test(TestMessage msg) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new TestMessage("10000", "记账成功");
	}

}
