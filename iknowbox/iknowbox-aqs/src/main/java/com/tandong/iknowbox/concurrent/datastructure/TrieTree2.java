/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.concurrent.datastructure<br/>
 * <b>文件名：</b>TrieTree2.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年8月1日-下午2:23:08<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.concurrent.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * TrieTree2
 * 
 * @author TanDong
 * 2016年8月1日 下午2:23:08
 * 
 * @version 1.0.0
 *
 */
public class TrieTree2 {
	
	private TrieNode root;

    public TrieTree2() {
        root = new TrieNode();
        root.wordEnd = false;
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = new Character(word.charAt(i));
            if (!node.childdren.containsKey(c)) {
                node.childdren.put(c, new TrieNode());
            }
            node = node.childdren.get(c);
        }
        node.wordEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        boolean found = true;
        for (int i = 0; i < word.length(); i++) {
            Character c = new Character(word.charAt(i));
            if (!node.childdren.containsKey(c)) {
                return false;
            }
            node = node.childdren.get(c);
        }
        return found && node.wordEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        boolean found = true;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = new Character(prefix.charAt(i));
            if (!node.childdren.containsKey(c)) {
                return false;
            }
            node = node.childdren.get(c);
        }
        return found;
    }
    
    public class TrieNode {
        Map<Character, TrieNode> childdren;
        boolean wordEnd;

        public TrieNode() {
            childdren = new HashMap<Character, TrieNode>();
            wordEnd = false;
        }
    }

}

