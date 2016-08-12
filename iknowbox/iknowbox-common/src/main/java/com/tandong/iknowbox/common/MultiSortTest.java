/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.konwbox.sort<br/>
 * <b>文件名：</b>MultiSortTest.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年1月12日-下午4:24:54<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.common;

/**
 *
 * MultiSortTest
 * 
 * @author TanDong
 * 2016年1月12日 下午4:24:54
 * 
 * @version 1.0.0
 *
 */
public class MultiSortTest {
	
	public static void main(String[] args) {
		
		int vals[] = {1,3,4,2,5,12,11,43,23,44,67,0};
		
		long startMP = System.currentTimeMillis();
		for(int k=0; k<10000; k++){
			int[] ret = MultiSort.maopaoSort(vals);
//			System.out.println("冒泡排序结果：");
//			for(int i=0; i<ret.length; i++){
//				System.out.print(ret[i]+" ");
//			}
		}
		long endMP = System.currentTimeMillis();
		System.out.println("冒泡耗时："+(endMP-startMP));
		
		
		System.out.println();
		long startCR = System.currentTimeMillis();
		for(int k=0; k<10000; k++){
			int[] ret1 = MultiSort.maopaoSort(vals);
//			System.out.println("插入排序结果：");
//			for(int i=0; i<ret1.length; i++){
//				System.out.print(ret1[i]+" ");
//			}
		}
		long endCR = System.currentTimeMillis();
		System.out.println("插入耗时："+(endCR-startCR));
	}

}
