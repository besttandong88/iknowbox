/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.aqs<br/>
 * <b>文件名：</b>ForkjoinTask.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年3月16日-上午11:41:49<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.concurrent.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 *
 * ForkjoinTask
 * 
 * @author TanDong 2016年3月16日 上午11:41:49
 * 
 * @version 1.0.0
 *
 */
public class ForkjoinTask extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;

	private static final int THRESHOLD = 100;
	private int start;
	private int end;

	public ForkjoinTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	protected Integer compute() {
		int sum = 0;
		if ((start - end) < THRESHOLD) {
			for (int i = start; i < end; i++) {
				sum += i;
			}
		} else {
			int middle = (start + end) / 2;
			ForkjoinTask left = new ForkjoinTask(start, middle);
			ForkjoinTask right = new ForkjoinTask(middle + 1, end);
			left.fork();
			right.fork();

			sum = left.join() + right.join();
		}
		return sum;
	}
	
	public static void main(String[] args){
		ForkJoinPool forkJoinPool = new ForkJoinPool();  
	    Future<Integer> result = forkJoinPool.submit(new ForkjoinTask(0, 10000));  
	  
	    try {
			System.out.println(result.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}  
	}
}
