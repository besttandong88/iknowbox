/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.common<br/>
 * <b>文件名：</b>ForkJoin.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年3月7日-下午1:52:21<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.common;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 *
 * ForkJoin JDK7提供的forkjoin并发处理框架；Fork/Join 模式能够解决很多种类的并行问题 
 * 
 * @author TanDong
 * 2016年3月7日 下午1:52:21
 * 
 * @version 1.0.0
 *
 */
public class ForkJoin extends RecursiveAction {

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;

	final long[] array;
    final int lo;
    final int hi;
    private int THRESHOLD = 0; //For demo only
 
    public ForkJoin(long[] array) {
        this.array = array;
        this.lo = 0;
        this.hi = array.length - 1;
    }

    public ForkJoin(long[] array, int lo, int hi) {
        this.array = array;
        this.lo = lo;
        this.hi = hi;
    }

    protected void compute() {
        if (hi - lo < THRESHOLD)
            sequentiallySort(array, lo, hi);
        else {
            int pivot = partition(array, lo, hi);
            System.out.println("\npivot = " + pivot + ", low = " + lo + ", high = " + hi);
			System.out.println("array" + Arrays.toString(array));
            this.invokeAll(new ForkJoin(array, lo, pivot - 1), new ForkJoin(array,pivot + 1, hi));
        }
    }

    private int partition(long[] array, int lo, int hi) {
        long x = array[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (array[j] <= x) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, hi);
        return i + 1;
    }

    private void swap(long[] array, int i, int j) {
        if (i != j) {
            long temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private void sequentiallySort(long[] array, int lo, int hi) {
        Arrays.sort(array, lo, hi + 1);
    }
    
    public static void main(String[] args) { 
    	int SIZE = 1000;
        ForkJoinPool forkJoinPool = new ForkJoinPool();  
        Random rnd = new Random();  
        long[] array = new long[SIZE];  
        for (int i = 0; i < SIZE; i++) {  
            array[i] = rnd.nextInt();  
        }  
        forkJoinPool.submit(new ForkJoin(array));  
      
        forkJoinPool.shutdown();  
        try {
			forkJoinPool.awaitTermination(1000, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  
      
        for (int i = 1; i < SIZE; i++) {  
        	System.out.println(array[i]);
            System.out.println(array[i - 1] < array[i]);  
        }  
    }  

}
