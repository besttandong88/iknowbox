/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.concurrent<br/>
 * <b>文件名：</b>Test.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年5月19日-下午4:15:42<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.concurrent;

/**
 *
 * Test
 * 
 * @author TanDong 2016年5月19日 下午4:15:42
 * 
 * @version 1.0.0
 *
 */
public class Test {

	public static void main(String[] args) {

		int k = 0;
		for (; k < 4; k += 2) {
			System.out.print(k + "");
		}
		System.out.println(k);

		int i = 1, j = 10;
		do {
			if (i > --j) {
				continue;
			}
		} while (i++ < 5);
		System.out.println("i = " + i + " and j = " + j);

		Test t = new Test();
		t.new Alpha();
		t.new Base();

		try {
			return;
		} finally {
			System.out.println("Finally");
		}

	}

	class Foo {
	}

	class Base {
		Base() {
			System.out.print("Base");
		}
	}

	class Alpha extends Base {
	}

}

class Parent {
	private String p = "parent";
	private static String sp = "s parent";

	public void method() {
		System.out.println(p);
	}

	public void smethod() {
		System.out.println(sp);
	}
}

class Child extends Parent {
	private String c = "child";
	private static String sc = "s child";

	public void method() {
		System.out.println(c);
	}

	public void smethod() {
		System.out.println(sc);
	}
}

class Td {
	public static void main(String[] args) {
		Child c = new Child();
		Parent p = (Parent) c;
		p.method();
		p.smethod();
	}
}

class Testaaa {
	public static void main(String[] args) {
		StringBuffer a = new StringBuffer("A");
		StringBuffer b = new StringBuffer("B");
		operate(a, b);
		System.out.println(a + "," + b);
	}

	public static void operate(StringBuffer x, StringBuffer y) {
		x = x.append(y);
		y = x;
	}
}
