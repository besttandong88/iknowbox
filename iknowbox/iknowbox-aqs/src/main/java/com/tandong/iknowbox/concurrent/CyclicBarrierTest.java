/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.concurrent<br/>
 * <b>文件名：</b>CyclicBarrier.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年4月28日-下午2:16:43<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * CyclicBarrierTest 一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)。
 * 
 * @author TanDong 2016年4月28日 下午2:16:43
 * 
 * @version 1.0.0
 *
 */
public class CyclicBarrierTest {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final CyclicBarrier cb = new CyclicBarrier(3); // 三个线程同时到达
		for (int i = 0; i < 3; i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						Thread.sleep((long) (Math.random() * 10000));
						System.out.println(
								"线程" + Thread.currentThread().getName() + "即将到达集合地点，当前已有" + (cb.getNumberWaiting() + 1) + "个已到达" + "正在等候");
						if(cb.getNumberWaiting() == 2){
							System.out.println("都到齐了");
						}
						try {
							cb.await();
						} catch (BrokenBarrierException e) {
							e.printStackTrace();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			service.execute(runnable);
		}
		service.shutdown();
	}
}
