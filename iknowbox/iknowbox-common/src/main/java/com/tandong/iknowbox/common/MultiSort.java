/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.konwbox.sort<br/>
 * <b>文件名：</b>SortTest.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年1月12日-下午4:21:47<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.common;

/**
 *
 * SortTest
 * 
 * @author TanDong 2016年1月12日 下午4:21:47
 * 
 * @version 1.0.0
 *
 */
public class MultiSort {

	// 冒泡排序
	public static int[] maopaoSort(int a[]) {
		int temp = 0;
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < a.length - i; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}

	// 插入排序
	public static int[] insertSort(int[] src) {
		int len = src.length;
		for (int i = 1; i < len; i++) {
			int j;
			int temp = src[i];
			for (j = i; j > 0; j--) {
				if (src[j - 1] > temp) {
					src[j] = src[j - 1];// 将j指向的数据覆盖
				} else {
					break;
				}
			}
			src[j] = temp;
		}
		return src;
	}

}
