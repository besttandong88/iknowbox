/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.admin.job<br/>
 * <b>文件名：</b>MyWriter.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年8月30日-上午11:10:58<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.admin.job;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Service;

/**
 *
 * MyWriter
 * 
 * @author TanDong
 * 2016年8月30日 上午11:10:58
 * 
 * @version 1.0.0
 *
 */
@Service("myWriter")
public class MyWriter implements ItemWriter<String> {

	private static Logger log = LoggerFactory.getLogger(MyWriter.class);
	
    @Override
    public void write(List<? extends String> items) throws Exception {
          log.info( "执行第二个任务，Writer写入数据");
          for (String item : items) {
              log.info( "Write item: {}", item);
         }
    }

}