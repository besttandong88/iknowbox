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
import org.springframework.stereotype.Service;

import com.tandong.iknowbox.admin.job.dao.ReconOuterThirdOrderMapper;

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
@Service("firstTasklet")
public class FirstTasklet implements Tasklet {
	
	private static Logger log = LoggerFactory.getLogger(FirstTasklet.class);
	
	@Autowired
    private ReconOuterThirdOrderMapper reconOuterThirdOrderMapper;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
    	log.info( "执行第一个任务, 准备待对账数据");
    	String batchNo = String.valueOf(chunkContext.getStepContext().getJobParameters().get("batchNo"));
    	log.info( "对账批次-"+batchNo);
        return RepeatStatus.FINISHED;
    }
}