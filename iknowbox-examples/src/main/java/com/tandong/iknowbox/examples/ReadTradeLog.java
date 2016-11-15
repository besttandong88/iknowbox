/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.examples<br/>
 * <b>文件名：</b>ReadTradeLog.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年11月9日-上午10:25:01<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.examples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * ReadTradeLog
 * 
 * @author TanDong 2016年11月9日 上午10:25:01
 * 
 * @version 1.0.0
 *
 */
public class ReadTradeLog {
	
	public static void main(String[] args) {
		readLog("商户调用同步用户接口:");
		//rmDuplicate();
	}
	
	/**
	 * 去掉日志中同一个用户号，重复访问某个收银台页面的情况
	 * void
	 * @exception
	 * @since  1.0.0
	*/
	public static void rmDuplicate(){
		try {
			List<String> userNos = new ArrayList<String>();
			FileReader reader = new FileReader("E://work//9f//tradelog//10月31日已绑定开户卡进入二次支付页面//smallpay-trade_detail.2016-10-31.log.3.secondpay");
			BufferedReader br = new BufferedReader(reader);
			String str = null;
			while ((str = br.readLine()) != null) {
				int startIndex = str.indexOf('户');
				String temp = str.substring(startIndex+2, startIndex+21);
				userNos.add(temp);
				System.out.println(temp);
			}
			br.close();
			reader.close();
			
			System.out.println(userNos.size());
			
			List<Object> rmdpUserNos = new ArrayList<Object>();
			Object[] usersArray = userNos.toArray();
			for(int i=0;i<usersArray.length;i++){
	             if(!rmdpUserNos.contains(usersArray[i]))
	            	 rmdpUserNos.add(usersArray[i]);       
	        } 
	        
	        //把去重之后的用户号数据写入新的文件中
	        StringBuffer wbuffer = new StringBuffer("");
	        for(int i=0;i<rmdpUserNos.size();i++){
	        	System.out.println("hehe"+rmdpUserNos.get(i));  
	        	wbuffer.append(rmdpUserNos.get(i) + "\n");
	        }
			FileWriter writer = new FileWriter("E://work//9f//tradelog//10月31日已绑定开户卡进入二次支付页面//用户号去重之后//smallpay-trade_detail.2016-10-31.log.3.secondpay.rmdp");
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write(wbuffer.toString());
			bw.close();
			writer.close();
			
			System.out.println("去重之后大小："+rmdpUserNos.size()); 
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//按行读取日志文件，找出包含指定内容的行
	public static void readLog(String searchStr){
		try {
			StringBuffer sb = new StringBuffer("");
			FileReader reader = new FileReader("E://work//9f//tradelog//smallpay-trade_detail.2016-10-31.log.3");
			BufferedReader br = new BufferedReader(reader);
			String str = null;
			while ((str = br.readLine()) != null) {
				if(str.contains(searchStr)){
					sb.append(str + "\n");
					System.out.println(str);
				}
			}
			br.close();
			reader.close();
			// write string to file
			FileWriter writer = new FileWriter("E://work//9f//tradelog//smallpay-trade_detail.2016-10-31.log.3.syncuser");
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write(sb.toString());
			bw.close();
			writer.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
