/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.concurrent.datastructure<br/>
 * <b>文件名：</b>TrieTree.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年7月29日-下午5:22:13<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.concurrent.datastructure;

/**
 *
 * TrieTree 字典树
 * 
 * @author TanDong 2016年7月29日 下午5:22:13
 * 
 * @version 1.0.0
 *
 */
public class TrieTree {
	
	private int SIZE = 26;
	private TreeNode root;

	TrieTree() {
		root = new TreeNode();
	}

	class TreeNode {
		private TreeNode[] son;
		private char data;
		private boolean isword;
		private int num;

		TreeNode() {
			son = new TreeNode[SIZE];
			data = ' ';
			isword = false;
			int num = 0;
		}
	}

	protected void insertTreeNode(String str) {
		TreeNode node = root;
		char[] strdata = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			int id = strdata[i] - 'a';
			if (node.son[id] == null) {
				node.son[id] = new TreeNode();
				node.son[id].data = strdata[i];
			} else
				node.son[id].num++;
			node = node.son[id];
		}
		node.isword = true;
	}

	protected int countTime(String str) {
		if (str.length() == 0 || str == null)
			return -1;
		char[] strdata = str.toCharArray();
		TreeNode node = root;
		for (int i = 0; i < str.length(); i++) {
			int id = strdata[i] - 'a';
			if (node.son[id] == null)
				return 0;
			else
				node = node.son[id];
		}
		return node.num;
	}

	protected boolean isInDictionary(String str) {
		TreeNode node = root;
		char[] strdata = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			int id = strdata[i] - 'a';
			if (node.son[id] == null)
				return false;
			node = node.son[id];
		}
		if (node.isword == false)
			return false;
		else
			return true;
	}

	protected TreeNode getRoot() {
		return this.root;
	}

	protected void preVisit(TreeNode node) {
		if (node != null) {
			System.out.print(node.data + " ");
			for (TreeNode temp : node.son)
				preVisit(temp);
		}
	}

	public static void main(String[] args) {
		TrieTree root = new TrieTree();
		root.insertTreeNode("asdsadsadsadsad");
		root.insertTreeNode("ewewewewewasdsad");
		
		
//		if (root.isInDictionary("lixiaokun"))
//			System.out.println("Yes");
//		else
//			System.out.println("No");
//		if (root.isInDictionary("haoxue"))
//			System.out.println("Yes");
//		else
//			System.out.println("No");
//		if (root.isInDictionary("hehe"))
//			System.out.println("Yes");
//		else
//			System.out.println("No");
//		root.preVisit(root.getRoot());
//		System.out.println();
//		System.out.println(root.countTime("he"));
	}
}
