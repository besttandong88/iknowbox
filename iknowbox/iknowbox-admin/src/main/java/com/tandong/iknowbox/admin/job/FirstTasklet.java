/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.admin.job<br/>
 * <b>文件名：</b>FirstTasklet.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年8月29日-下午1:50:53<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.admin.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.tandong.iknowbox.admin.channel.dao.FundChannelMapper;
import com.tandong.iknowbox.admin.channel.entity.FundChannel;

/**
 *
 * FirstTasklet
 * 
 * @author TanDong
 * 2016年8月29日 下午1:50:53
 * 
 * @version 1.0.0
 *
 */
public class FirstTasklet implements Tasklet {
	
	private static Logger log = LoggerFactory.getLogger(FirstTasklet.class);
	
	@Autowired
    private FundChannelMapper fundChannelMapper;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
    	log.info( "执行第一个任务");
    	String batchNo = String.valueOf(chunkContext.getStepContext().getJobParameters().get("batchNo"));
    	for(int i=0; i<10000; i++){
    		FundChannel channel = new FundChannel();
    		channel.setChannelCode("test_code"+i);
    		channel.setChannelName("test_name"+i);
    		channel.setBatchNo(batchNo);
    		fundChannelMapper.inertFundChannel(channel);
    	}
        return RepeatStatus.FINISHED;
    }
}