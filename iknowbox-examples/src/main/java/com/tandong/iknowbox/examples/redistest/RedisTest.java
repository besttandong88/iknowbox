/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.examples.redistest<br/>
 * <b>文件名：</b>JedisClient.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年11月2日-上午12:38:45<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.examples.redistest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tandong.iknowbox.common.SpringContextHolder;
import com.tandong.iknowbox.common.util.RedisClient;

/**
 *
 * JedisClient
 * 
 * @author TanDong 2016年11月2日 上午12:38:45
 * 
 * @version 1.0.0
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/aplicationContext.xml", 
		"classpath*:/dubbo-consumer.xml",
		"classpath*:/spring-servlet.xml"})
public class RedisTest {
	
	@Autowired
	RedisClient redisClient;

	@Test
	public void testRedis() {
		redisClient = SpringContextHolder.getBean("reidsClient");

		User user = new User();
		user.setName("tandong");
		user.setAge(31);
		user.setPhone("13810509081");

		redisClient.set("user", user);
	}

}
