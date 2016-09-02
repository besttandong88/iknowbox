/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.concurrent<br/>
 * <b>文件名：</b>CountDownLatchTest.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年4月25日-下午1:36:27<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 *
 * CountDownLatchTest 通过计数器方式来等待所有线程执行完毕。
 * countDown()计数器减1，await();阻塞等待，直到计数器为0
 * 
 * @author TanDong
 * 2016年4月25日 下午1:36:27
 * 
 * @version 1.0.0
 *
 */
public class CountDownLatchTest {
	
	CountDownLatch latch = new CountDownLatch(2);
	
	Thread t1 = new Thread(){
		public void run(){
			System.out.println("Thread - 1");
			latch.countDown();
		}
	};
	
	Thread t2 = new Thread(){
		public void run(){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread - 2");
			latch.countDown();
		}
	};
	
	public static void main(String[] args){
		CountDownLatchTest latchTest = new CountDownLatchTest();
		latchTest.t1.start();
		latchTest.t2.start();
		
		try {
			latchTest.latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finished");
	}

}
