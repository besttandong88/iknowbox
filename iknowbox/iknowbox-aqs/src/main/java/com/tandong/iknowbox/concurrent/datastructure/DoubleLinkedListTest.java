/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.concurrent.tree<br/>
 * <b>文件名：</b>DoubleLinkedListTest.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年7月19日-下午4:13:33<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.concurrent.datastructure;

/**
 *
 * DoubleLinkedListTest
 * 
 * @author TanDong
 * 2016年7月19日 下午4:13:33
 * 
 * @version 1.0.0
 *
 */
public class DoubleLinkedListTest {
	public static void main(String[] args) {
	    DoubleLinkedList dll = new DoubleLinkedList();
	    //添加
	    dll.add("张曼玉");
	    dll.add("钟楚红");
	    dll.add("刘嘉玲");
	    System.out.println(dll);

	    //添加到最前
	    dll.addFirst("林青霞");
	    System.out.println(dll);

	    //添加到最后，同添加
	    dll.addLast("梅艳芳");
	    System.out.println(dll);

	    //添加到指定位置
	    dll.add(4, "王祖贤");
	    System.out.println(dll);

	    //移除最前的
	    dll.removeFirst();
	    System.out.println(dll);

	    //移除最后的
	    dll.removeLast();
	    System.out.println(dll);

	    //移除指定位置上的
	    dll.remove(2);
	    System.out.println(dll);

	    //返回指定位置上的元素
	    System.out.println(dll.get(1));

	  }
	}
