/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.concurrent.tree<br/>
 * <b>文件名：</b>BTreeNode.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年7月18日-上午10:36:52<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.concurrent.datastructure;

/**
 *
 * BTreeNode
 * 
 * @author TanDong 2016年7月18日 上午10:36:52
 * 
 * @version 1.0.0
 *
 */
public class BTreeNode {

	private BTreeNode leftChild;

	private BTreeNode rightChild;

	int intege;

	public BTreeNode(int intege) {
		super();
		this.intege = intege;
	}

	public BTreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BTreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public BTreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BTreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public int getIntege() {
		return intege;
	}

	public void setIntege(int intege) {
		this.intege = intege;
	}
}
