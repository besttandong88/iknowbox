/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.math<br/>
 * <b>文件名：</b>SecondPrimeNumber.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年3月24日-下午2:02:17<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.concurrent.math;

/**
 *
 * SecondPrimeNumber
 * 
 * @author TanDong 2016年3月24日 下午2:02:17
 * 
 * @version 1.0.0
 *
 */
public class SecondPrimeNumber {
	
	public static int count = 0;

	public static void main(String[] args) {
		for (int i = 101; i < 200; i++) {
			boolean b = true;// 默认此数就素数
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					b = false; // 此数不是素数
					break;
				}
			}
			if (b) {
				count++;
				System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.println("素数的个数：" + count);
	}
}