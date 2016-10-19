/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.admin.job<br/>
 * <b>文件名：</b>SecondTasklet.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年8月30日-上午10:23:55<br/>
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

import com.tandong.iknowbox.admin.job.dao.ReconOuterThirdOrderMapper;

/**
 *
 * SecondTasklet
 * 
 * @author TanDong
 * 2016年8月30日 上午10:23:55
 * 
 * @version 1.0.0
 *
 */
public class ThreeTasklet implements Tasklet {
	
	private static Logger log = LoggerFactory.getLogger(FirstTasklet.class);

	@Autowired
    private ReconOuterThirdOrderMapper reconOuterThirdOrderMapper;
	
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
          log.info( "执行第三个任务");
          String batchNo = String.valueOf(chunkContext.getAttribute("batchNo"));
          return RepeatStatus.FINISHED;
    }
}