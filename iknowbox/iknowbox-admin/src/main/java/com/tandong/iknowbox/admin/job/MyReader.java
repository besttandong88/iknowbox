/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.admin.job<br/>
 * <b>文件名：</b>MyReader.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年8月30日-上午11:10:49<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.admin.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 *
 * MyReader
 * 
 * @author TanDong
 * 2016年8月30日 上午11:10:49
 * 
 * @version 1.0.0
 *
 */
public class MyReader implements ItemReader<MyModel> {

    private int count;

    private static Logger log = LoggerFactory.getLogger(MyReader.class);
    
    @Override
    public MyModel read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
         log.info( "执行第二个任务，Reader获取数据");
         MyModel model = null;
         if ( count < 2) {
              model = new MyModel();
              count++;
         }
         return model;
    }

}
