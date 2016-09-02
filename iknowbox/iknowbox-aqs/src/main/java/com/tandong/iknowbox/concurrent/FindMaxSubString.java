/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.concurrent<br/>
 * <b>文件名：</b>FindMaxSubString.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年7月18日-上午10:41:23<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.concurrent;

/**
 *
 * FindMaxSubString
 * 
 * @author TanDong 2016年7月18日 上午10:41:23
 * 
 * @version 1.0.0
 *
 */
public class FindMaxSubString {

	public static void main(String[] args) {
		String str1 = "abcdeioplkjnm";
		String str2 = "dsfdsfdsewrrrggrdabcde";
		for (int i = 0; i < str1.length(); i++) {
			for (int start = 0, end = str1.length() - i; end != str1.length() + 1; start++, end++) {
				String sub = str1.substring(start, end);
				if (str2.contains(sub))
					System.out.println(sub);
			}
		}
		
		for (int i = 0; i < 10; i++) {
			for(int s=0,e=10-i; e!=11; s++,e++){
				System.out.println(s + "         "+e);
			}
		}
		
	}

}
