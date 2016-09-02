/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.aqs<br/>
 * <b>文件名：</b>ReentrantlockTest.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年3月22日-下午4:36:17<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.concurrent.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 三个线程A、B、C循环输出A、B、C例子
 * 
 * @author TanDong
 * 2016年3月22日 下午4:36:17
 * 
 * @version 1.0.0
 *
 */
public class ReentrantlockTest {
	
	public static void main(String[] args) throws Exception{
		
		ReentrantLock lock = new ReentrantLock();
		
		Condition conditionA = lock.newCondition();
		
		Condition conditionB = lock.newCondition();
		
		Condition conditionC = lock.newCondition();
		
		MyTask thread1 = new ReentrantlockTest().new MyTask("A",lock, conditionB);
		
		MyTask thread2 = new ReentrantlockTest().new MyTask("B",lock, conditionC);
		
		MyTask thread3 = new ReentrantlockTest().new MyTask("C",lock, conditionA);
		
		thread1.run();
		thread2.run();
		thread3.run();
	}
	
	class MyTask implements Runnable {
		
		private String str = "";
		
		private ReentrantLock lock;
		
		private Condition nextCondition;
		
		public MyTask(String s, ReentrantLock lock, Condition nextCondition){
			this.str = s;
			this.lock = lock;
			this.nextCondition = nextCondition;
		}

		public void run() {
			lock.lock();
			System.out.println(str);
			try {
				nextCondition.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			nextCondition.signal();
			lock.unlock();
		}
	}

}
