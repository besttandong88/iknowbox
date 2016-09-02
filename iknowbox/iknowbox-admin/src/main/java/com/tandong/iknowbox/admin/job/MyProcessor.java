/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.admin.job<br/>
 * <b>文件名：</b>MyProcessor.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年8月30日-上午11:11:13<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.admin.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.tandong.iknowbox.admin.channel.service.IFundChannelService;

/**
 *
 * MyProcessor
 * 
 * @author TanDong
 * 2016年8月30日 上午11:11:13
 * 
 * @version 1.0.0
 *
 */
public class MyProcessor implements ItemProcessor<MyModel, String> {
	
	private static Logger log = LoggerFactory.getLogger(MyProcessor.class);
	
	@Autowired
    private IFundChannelService fundChannelService;

    @Override
    public String process(MyModel item) throws Exception {
          log.info( "执行第二个任务，process处理数据");
          Thread.sleep(1000);
          fundChannelService.insertFundChannelHis(null);
          return "success";
    }
}
