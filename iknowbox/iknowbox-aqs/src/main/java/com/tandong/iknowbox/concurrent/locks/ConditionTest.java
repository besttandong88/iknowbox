/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.concurrent.locks<br/>
 * <b>文件名：</b>ConditionTest.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年3月25日-上午10:03:19<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 */
package com.tandong.iknowbox.concurrent.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * ConditionTest
 * 
 * 我们要打印1到9这9个数字，由A线程先打印1，2，3，然后由B线程打印4,5,6， 然后再由A线程打印7，8，9.
 * 这道题有很多种解法，现在我们使用Condition来做这道题
 * 
 * @author TanDong 2016年3月25日 上午10:03:19
 * @version 1.0.0
 *
 */
public class ConditionTest {

	static class NumberWrapper {
		public int value = 1;
	}

	public static void main(String[] args) {
		
		// 初始化可重入锁
		final Lock lock = new ReentrantLock();

		// 第一个条件当屏幕上输出到3
		final Condition reachThreeCondition = lock.newCondition();
		// 第二个条件当屏幕上输出到6
		final Condition reachSixCondition = lock.newCondition();

		// NumberWrapper只是为了封装一个数字，一边可以将数字对象共享，并可以设置为final
		// 注意这里不要用Integer, Integer 是不可变对象
		final NumberWrapper num = new NumberWrapper();
		// 初始化A线程
		Thread threadA = new Thread(new Runnable() {
			public void run() {
				// 需要先获得锁
				lock.lock();
				try {
					System.out.println("threadA start write");
					// A线程先输出前3个数
					while (num.value <= 3) {
						System.out.println(num.value);
						num.value++;
					}
					// 输出到3时要signal，告诉B线程可以开始了
					reachThreeCondition.signal();
				} finally {
					lock.unlock();
				}
				lock.lock();
				try {
					// 等待输出6的条件
					reachSixCondition.await();
					System.out.println("threadA start write");
					// 输出剩余数字
					while (num.value <= 9) {
						System.out.println(num.value);
						num.value++;
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}

		});

		Thread threadB = new Thread(new Runnable() {
			public void run() {
				try {
					lock.lock();

					while (num.value <= 3) {
						// 等待3输出完毕的信号
						reachThreeCondition.await();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
				try {
					lock.lock();
					// 已经收到信号，开始输出4，5，6
					System.out.println("threadB start write");
					while (num.value <= 6) {
						System.out.println(num.value);
						num.value++;
					}
					// 4，5，6输出完毕，告诉A线程6输出完了
					reachSixCondition.signal();
				} finally {
					lock.unlock();
				}
			}

		});

		// 启动两个线程
		threadB.start();
		threadA.start();
	}
}