/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.concurrent<br/>
 * <b>文件名：</b>BTreeTest.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年7月18日-上午10:36:14<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.concurrent.datastructure;

/**
 *
 * BTreeTest
 * 
 * @author TanDong 2016年7月18日 上午10:36:14
 * 
 * @version 1.0.0
 *
 */
public class BTreeTest {
	private int max;
	private int min;

	public BTreeTest(int max, int min) {
		super();
		this.max = max;
		this.min = min;
	}

	// 构造二叉树
	public void insert(BTreeNode root, int i) {
		if (root == null) {
			System.out.println("树为空");
		} else {

			if (root.getIntege() < i) {
				if (root.getLeftChild() != null) {
					insert(root.getLeftChild(), i);
				} else {
					root.setLeftChild(new BTreeNode(i));
				}
			} else {
				if (root.getRightChild() != null) {
					insert(root.getRightChild(), i);
				} else {
					root.setRightChild(new BTreeNode(i));
				}
			}
		}
	}

	// 插入二叉树，遍历找到节点最大值和最小值
	public void FindMax_Min(BTreeNode root) {
		if (root == null) {
			System.out.println("该树为空");
		} else {
			if (root.getIntege() > max) {
				max = root.getIntege();
			}
			if (root.getIntege() < min) {
				min = root.getIntege();
			}
			// System.out.println(root.getIntege() + " ");
			if (root.getLeftChild() != null) {
				FindMax_Min(root.getLeftChild());
			}
			if (root.getRightChild() != null) {
				FindMax_Min(root.getRightChild());
			}
		}
	}

	public void Max_Min_abs() {
		System.out.println(Math.abs(max) +"  "+Math.abs(min));
		System.out.println(max - min);
		
	}

	public static void main(String[] args) {
		int a[] = { 1, 45, 6, 7, 12, 89, 2, 17 };
		BTreeTest b = new BTreeTest(-10000, 10000);
		BTreeNode treeNode1 = new BTreeNode(a[0]);
		for (int i = 1; i < a.length; i++) {
			b.insert(treeNode1, a[i]);
		}
		b.FindMax_Min(treeNode1);
		b.Max_Min_abs();
	}
}
