/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.admin.job.vo<br/>
 * <b>文件名：</b>ReconOuterMessage.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年10月12日-下午2:16:43<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.admin.job.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * ReconOuterMessage
 * 
 * @author TanDong
 * 2016年10月12日 下午2:16:43
 * 
 * @version 1.0.0
 *
 */
public class ReconOuterMessage implements Serializable {

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;
	
	/** 第三方文件待对账入库主键 */
	private Long thirdId;

	/** 批次号 */
	private String thirdBatchNo;

	/** 第三方文件渠道订单号 */
	private String thirdOrderNo;

	/** 第三方文件订单金额 */
	private BigDecimal thirdOrderAmount;

	/** 第三方文件交易类型 */
	private String thirdTransType;

	/** 第三方文件订单状态 */
	private String thirdStatus;

	/** 渠道编码 */
	private String channelCode;

	/** 第三方文件订单请求时间 */
	private Date thirdRequestTime;

	/** 平台数据入待对账库主键 */
	private Long platId;

	/** 平台渠道订单号 */
	private String platOrderNo;

	/** 平台渠道订单金额 */
	private BigDecimal platOrderAmount;

	/** 平台渠道订单状态 */
	private String platStatus;
	
	/** 平台渠道订单请求时间 */
	private Date platRequestTime;
	
	private Date reconTime;

	private String errorType;
	
	/** 对账状态 */
	private String reconState;

	private String remark;
	
	/** 微支付支付订单号 */
	private String payOrderNo;
	
	/** 银行英文缩写 */
	private String bankAbbr;

	/** 平台数据入待对账库主键 */
	public Long getPlatId() {
		return platId;
	}

	/** 平台数据入待对账库主键 */
	public void setPlatId(Long platId) {
		this.platId = platId;
	}

	/** 第三方文件待对账入库主键 */
	public Long getThirdId() {
		return thirdId;
	}

	/** 第三方文件待对账入库主键 */
	public void setThirdId(Long thirdId) {
		this.thirdId = thirdId;
	}

	/** 渠道编码 */
	public String getChannelCode() {
		return channelCode;
	}
	/** 渠道编码 */
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	/** 平台渠道订单金额 */
	public BigDecimal getPlatOrderAmount() {
		return platOrderAmount;
	}
	/** 平台渠道订单金额 */
	public void setPlatOrderAmount(BigDecimal platOrderAmount) {
		this.platOrderAmount = platOrderAmount;
	}
	/** 平台渠道订单号 */
	public String getPlatOrderNo() {
		return platOrderNo;
	}
	/** 平台渠道订单号 */
	public void setPlatOrderNo(String platOrderNo) {
		this.platOrderNo = platOrderNo;
	}
	/** 平台渠道订单状态 */
	public String getPlatStatus() {
		return platStatus;
	}
	/** 平台渠道订单状态 */
	public void setPlatStatus(String platStatus) {
		this.platStatus = platStatus;
	}
	/** 批次号 */
	public String getThirdBatchNo() {
		return thirdBatchNo;
	}
	/** 批次号 */
	public void setThirdBatchNo(String thirdBatchNo) {
		this.thirdBatchNo = thirdBatchNo;
	}
	/** 第三方文件订单金额 */
	public BigDecimal getThirdOrderAmount() {return thirdOrderAmount;}
	/** 第三方文件订单金额 */
	public void setThirdOrderAmount(BigDecimal thirdOrderAmount) {
		this.thirdOrderAmount = thirdOrderAmount;
	}
	/** 第三方文件渠道订单号 */
	public String getThirdOrderNo() {
		return thirdOrderNo;
	}
	/** 第三方文件渠道订单号 */
	public void setThirdOrderNo(String thirdOrderNo) {
		this.thirdOrderNo = thirdOrderNo;
	}
	/** 第三方文件订单请求时间 */
	public Date getThirdRequestTime() {
		return thirdRequestTime;
	}
	/** 第三方文件订单请求时间 */
	public void setThirdRequestTime(Date thirdRequestTime) {
		this.thirdRequestTime = thirdRequestTime;
	}
	/** 第三方文件订单状态 */
	public String getThirdStatus() {
		return thirdStatus;
	}
	/** 第三方文件订单状态 */
	public void setThirdStatus(String thirdStatus) {
		this.thirdStatus = thirdStatus;
	}
	/** 第三方文件交易类型 {@link com.ninefbank.smallpay.clear.enums.FileType } */
	public String getThirdTransType() {
		return thirdTransType;
	}
	/** 第三方文件交易类型 */
	public void setThirdTransType(String thirdTransType) {
		this.thirdTransType = thirdTransType;
	}
	public Date getPlatRequestTime() {
		return platRequestTime;
	}
	public void setPlatRequestTime(Date platRequestTime) {
		this.platRequestTime = platRequestTime;
	}
	public String getReconState() {
		return reconState;
	}
	public void setReconState(String reconState) {
		this.reconState = reconState;
	}
	public String getPayOrderNo() {
		return payOrderNo;
	}
	public void setPayOrderNo(String payOrderNo) {
		this.payOrderNo = payOrderNo;
	}

	public String getErrorType() {return errorType;}

	public void setErrorType(String errorType) {this.errorType = errorType;}

	public String getRemark() {return remark;}

	public void setRemark(String remark) {this.remark = remark;}

	public Date getReconTime() {return reconTime;}

	public void setReconTime(Date reconTime) {this.reconTime = reconTime;}

	public String getBankAbbr() {
		return bankAbbr;
	}
	public void setBankAbbr(String bankAbbr) {
		this.bankAbbr = bankAbbr;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
