package com.tandong.iknowbox.common;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	
	public static void main(String[] args) {
		int lastAdd = 0;
		for (int i = 0; i < 10; i++) {
			lastAdd = lastAdd++;
		}
		System.out.println(lastAdd);
	}
}
