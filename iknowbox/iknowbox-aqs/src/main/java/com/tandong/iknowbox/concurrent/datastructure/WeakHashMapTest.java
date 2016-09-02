/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.concurrent.datastructure<br/>
 * <b>文件名：</b>WeakHashMapTest1.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年7月21日-下午1:50:01<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.concurrent.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/**
 *
 * WeakHashMapTest1
 * 
 * @author TanDong 2016年7月21日 下午1:50:01
 * 
 * @version 1.0.0
 *
 */
public class WeakHashMapTest {
	
	public void test1(){
		List<WeakHashMap<byte[][], byte[][]>> maps = new ArrayList<WeakHashMap<byte[][], byte[][]>>();
		for (int i = 0; i < 1000; i++) {
			WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();
			d.put(new byte[1000][1000], new byte[1000][1000]);
			maps.add(d);
			System.gc();
			System.err.println(i);
		}
	}
	
	public void test2(){
		List<WeakHashMap<byte[][], byte[][]>> maps = new ArrayList<WeakHashMap<byte[][], byte[][]>>();
		for (int i = 0; i < 1000; i++) {
			WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();
			d.put(new byte[1000][1000], new byte[1000][1000]);
			maps.add(d);
			System.gc();
			System.err.println(i);
			for (int j = 0; j < i; j++) {
				System.err.println(j + " size" + maps.get(j).size());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		WeakHashMapTest test = new WeakHashMapTest();
		test.test2();
	}
}
