/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>test.com.tandong.iknowbox.admin<br/>
 * <b>文件名：</b>JobTest.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年8月30日-上午11:15:24<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package test.com.tandong.iknowbox.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tandong.iknowbox.common.SpringContextHolder;

/**
 *
 * JobTest
 * 
 * @author TanDong 2016年8月30日 上午11:15:24
 * 
 * @version 1.0.0
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class JobTest {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Test
	public void testJob() throws Exception {
		Thread thread1 = new Thread() {
			public void run() {
				System.out.println("Thread 启动执行任务");

				long startTime = System.currentTimeMillis();
				try {
					Job jobBean = SpringContextHolder.getBean("testJob");
					JobExecution result = ((JobLauncher) SpringContextHolder.getBean("jobLauncher")).run(jobBean,
							new JobParametersBuilder().addString("batchNo", "2016830").toJobParameters());
					System.out.println("Thread 执行结果"+result.getExitStatus().getExitCode());
					// jobLauncherTestUtils.launchJob(new
					// JobParametersBuilder().addString("batchNo",
					// "2016831").toJobParameters());
				} catch (Exception e) {
					e.printStackTrace();
				}
				long endTime = System.currentTimeMillis();
				System.out.println("Thread耗时：" + (endTime - startTime) / 1000 + "秒");
			}
		};
		thread1.start();

		Thread thread2 = new Thread() {
			public void run() {
				
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				System.out.println("Thread2 启动执行任务");
				long startTime = System.currentTimeMillis();
				try {
					Job jobBean = SpringContextHolder.getBean("testJob");
					JobExecution result = ((JobLauncher) SpringContextHolder.getBean("jobLauncher")).run(jobBean,
							new JobParametersBuilder().addString("batchNo", "2016831").toJobParameters());
					System.out.println("Thread2 执行结果"+result.getExitStatus().getExitCode());
				} catch (Exception e) {
					e.printStackTrace();
				}
				long endTime = System.currentTimeMillis();
				System.out.println("Thread2耗时：" + (endTime - startTime) / 1000 + "秒");
			}
		};
		thread2.start();
		
		
		while(true){
			if(thread1.getState().toString() == "TERMINATED" && thread2.getState().toString() == "TERMINATED"){
				System.out.println("Thread1 state --- >> "+thread1.getState());
				System.out.println("Thread2 state --- >> "+thread2.getState());
				break;
			}else{
				
			}
		}

		// JobExecution jobExecution = jobLauncherTestUtils.launchJob();
		// Assert.isTrue("COMPLETED".equals(jobExecution.getExitStatus().getExitCode()));
	}
}
