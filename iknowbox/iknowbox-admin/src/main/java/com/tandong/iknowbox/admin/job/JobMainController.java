/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.admin.job<br/>
 * <b>文件名：</b>JobMainController.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年10月12日-上午11:40:36<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.admin.job;

import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tandong.iknowbox.common.SpringContextHolder;
import com.tandong.iknowbox.common.web.BaseController;

/**
 *
 * JobMainController
 * 
 * @author TanDong
 * 2016年10月12日 上午11:40:36
 * 
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping("job")
public class JobMainController extends BaseController {
	
	/**
	 * run(这里用一句话描述这个方法的作用)<br/>
	 * @param typeCode
	 * @param itemCode
	 * @return
	 * @throws ApplicationException
	 * Map<String,Object>
	 * @throws JobParametersInvalidException 
	 * @throws JobInstanceAlreadyCompleteException 
	 * @throws JobRestartException 
	 * @throws JobExecutionAlreadyRunningException 
	 * @exception
	 * @since  1.0.0
	*/
	@RequestMapping(value = "run", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> run(@RequestParam String transType, @RequestParam String channelCode)  {
		
		if(null == transType || "".equals(transType)){
			transType="002";
		}
		if(null == channelCode || "".equals(channelCode)){
			channelCode="BF01";
		}
		Map<String, Object> ret = new HashMap<String, Object>();
		
		Job jobBean = SpringContextHolder.getBean("testJob");
		
		JobExecution result = null;
		JobParametersBuilder params = new JobParametersBuilder();
		params.addString("transType", transType);
		params.addString("channelCode", channelCode);
		params.addString("batchNo", channelCode+String.valueOf(System.currentTimeMillis()));
		try {
			result = ((JobLauncher) SpringContextHolder.getBean("jobLauncher")).run(jobBean,params.toJobParameters());
		} catch (JobExecutionAlreadyRunningException e) {
			e.printStackTrace();
		} catch (JobRestartException e) {
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
		ret.put("ret", result.getExitStatus().getExitCode());
		return ret;
	}

}
