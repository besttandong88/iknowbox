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
import org.springframework.stereotype.Service;

import com.tandong.iknowbox.admin.job.vo.ReconOuterMessage;

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
@Service("myProcessor")
public class MyProcessor implements ItemProcessor<ReconOuterMessage, String> {
	
	private static Logger log = LoggerFactory.getLogger(MyProcessor.class);
	
    @Override
    public String process(ReconOuterMessage data) throws Exception {
          log.info( "执行第二个任务，process处理数据: "+data.toString());
          String thirdOrderNo = data.getThirdOrderNo();
          String platOrderNo = data.getPlatOrderNo();
          return "success";
    }
}
