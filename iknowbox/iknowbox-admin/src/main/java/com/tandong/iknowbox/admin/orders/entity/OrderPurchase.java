package com.tandong.iknowbox.admin.orders.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderPurchase implements Serializable {
    private Integer id;

    private String busPurOrderno;

    private String merNo;

    private BigDecimal purAmount;

    private String memNo;

    private String custNo;

    private String bankProdCode;

    private String fundCode;

    private String channelCode;

    private Byte purchType;

    private Byte purStatus;

    private Byte isPayGrant;

    private Date beginProfitDate;

    private Integer confirmShare;

    private Date confirmDate;

    private String resCode;

    private String resMsg;

    private String remark;

    private Date applyDate;

    private Date applyTime;

    private Date applyUptime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusPurOrderno() {
        return busPurOrderno;
    }

    public void setBusPurOrderno(String busPurOrderno) {
        this.busPurOrderno = busPurOrderno == null ? null : busPurOrderno.trim();
    }

    public String getMerNo() {
        return merNo;
    }

    public void setMerNo(String merNo) {
        this.merNo = merNo == null ? null : merNo.trim();
    }

    public BigDecimal getPurAmount() {
        return purAmount;
    }

    public void setPurAmount(BigDecimal purAmount) {
        this.purAmount = purAmount;
    }

    public String getMemNo() {
        return memNo;
    }

    public void setMemNo(String memNo) {
        this.memNo = memNo == null ? null : memNo.trim();
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo == null ? null : custNo.trim();
    }

    public String getBankProdCode() {
        return bankProdCode;
    }

    public void setBankProdCode(String bankProdCode) {
        this.bankProdCode = bankProdCode == null ? null : bankProdCode.trim();
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode == null ? null : fundCode.trim();
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    public Byte getPurchType() {
        return purchType;
    }

    public void setPurchType(Byte purchType) {
        this.purchType = purchType;
    }

    public Byte getPurStatus() {
        return purStatus;
    }

    public void setPurStatus(Byte purStatus) {
        this.purStatus = purStatus;
    }

    public Byte getIsPayGrant() {
        return isPayGrant;
    }

    public void setIsPayGrant(Byte isPayGrant) {
        this.isPayGrant = isPayGrant;
    }

    public Date getBeginProfitDate() {
        return beginProfitDate;
    }

    public void setBeginProfitDate(Date beginProfitDate) {
        this.beginProfitDate = beginProfitDate;
    }

    public Integer getConfirmShare() {
        return confirmShare;
    }

    public void setConfirmShare(Integer confirmShare) {
        this.confirmShare = confirmShare;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode == null ? null : resCode.trim();
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg == null ? null : resMsg.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getApplyUptime() {
        return applyUptime;
    }

    public void setApplyUptime(Date applyUptime) {
        this.applyUptime = applyUptime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OrderPurchase other = (OrderPurchase) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBusPurOrderno() == null ? other.getBusPurOrderno() == null : this.getBusPurOrderno().equals(other.getBusPurOrderno()))
            && (this.getMerNo() == null ? other.getMerNo() == null : this.getMerNo().equals(other.getMerNo()))
            && (this.getPurAmount() == null ? other.getPurAmount() == null : this.getPurAmount().equals(other.getPurAmount()))
            && (this.getMemNo() == null ? other.getMemNo() == null : this.getMemNo().equals(other.getMemNo()))
            && (this.getCustNo() == null ? other.getCustNo() == null : this.getCustNo().equals(other.getCustNo()))
            && (this.getBankProdCode() == null ? other.getBankProdCode() == null : this.getBankProdCode().equals(other.getBankProdCode()))
            && (this.getFundCode() == null ? other.getFundCode() == null : this.getFundCode().equals(other.getFundCode()))
            && (this.getChannelCode() == null ? other.getChannelCode() == null : this.getChannelCode().equals(other.getChannelCode()))
            && (this.getPurchType() == null ? other.getPurchType() == null : this.getPurchType().equals(other.getPurchType()))
            && (this.getPurStatus() == null ? other.getPurStatus() == null : this.getPurStatus().equals(other.getPurStatus()))
            && (this.getIsPayGrant() == null ? other.getIsPayGrant() == null : this.getIsPayGrant().equals(other.getIsPayGrant()))
            && (this.getBeginProfitDate() == null ? other.getBeginProfitDate() == null : this.getBeginProfitDate().equals(other.getBeginProfitDate()))
            && (this.getConfirmShare() == null ? other.getConfirmShare() == null : this.getConfirmShare().equals(other.getConfirmShare()))
            && (this.getConfirmDate() == null ? other.getConfirmDate() == null : this.getConfirmDate().equals(other.getConfirmDate()))
            && (this.getResCode() == null ? other.getResCode() == null : this.getResCode().equals(other.getResCode()))
            && (this.getResMsg() == null ? other.getResMsg() == null : this.getResMsg().equals(other.getResMsg()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getApplyDate() == null ? other.getApplyDate() == null : this.getApplyDate().equals(other.getApplyDate()))
            && (this.getApplyTime() == null ? other.getApplyTime() == null : this.getApplyTime().equals(other.getApplyTime()))
            && (this.getApplyUptime() == null ? other.getApplyUptime() == null : this.getApplyUptime().equals(other.getApplyUptime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBusPurOrderno() == null) ? 0 : getBusPurOrderno().hashCode());
        result = prime * result + ((getMerNo() == null) ? 0 : getMerNo().hashCode());
        result = prime * result + ((getPurAmount() == null) ? 0 : getPurAmount().hashCode());
        result = prime * result + ((getMemNo() == null) ? 0 : getMemNo().hashCode());
        result = prime * result + ((getCustNo() == null) ? 0 : getCustNo().hashCode());
        result = prime * result + ((getBankProdCode() == null) ? 0 : getBankProdCode().hashCode());
        result = prime * result + ((getFundCode() == null) ? 0 : getFundCode().hashCode());
        result = prime * result + ((getChannelCode() == null) ? 0 : getChannelCode().hashCode());
        result = prime * result + ((getPurchType() == null) ? 0 : getPurchType().hashCode());
        result = prime * result + ((getPurStatus() == null) ? 0 : getPurStatus().hashCode());
        result = prime * result + ((getIsPayGrant() == null) ? 0 : getIsPayGrant().hashCode());
        result = prime * result + ((getBeginProfitDate() == null) ? 0 : getBeginProfitDate().hashCode());
        result = prime * result + ((getConfirmShare() == null) ? 0 : getConfirmShare().hashCode());
        result = prime * result + ((getConfirmDate() == null) ? 0 : getConfirmDate().hashCode());
        result = prime * result + ((getResCode() == null) ? 0 : getResCode().hashCode());
        result = prime * result + ((getResMsg() == null) ? 0 : getResMsg().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getApplyDate() == null) ? 0 : getApplyDate().hashCode());
        result = prime * result + ((getApplyTime() == null) ? 0 : getApplyTime().hashCode());
        result = prime * result + ((getApplyUptime() == null) ? 0 : getApplyUptime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", busPurOrderno=").append(busPurOrderno);
        sb.append(", merNo=").append(merNo);
        sb.append(", purAmount=").append(purAmount);
        sb.append(", memNo=").append(memNo);
        sb.append(", custNo=").append(custNo);
        sb.append(", bankProdCode=").append(bankProdCode);
        sb.append(", fundCode=").append(fundCode);
        sb.append(", channelCode=").append(channelCode);
        sb.append(", purchType=").append(purchType);
        sb.append(", purStatus=").append(purStatus);
        sb.append(", isPayGrant=").append(isPayGrant);
        sb.append(", beginProfitDate=").append(beginProfitDate);
        sb.append(", confirmShare=").append(confirmShare);
        sb.append(", confirmDate=").append(confirmDate);
        sb.append(", resCode=").append(resCode);
        sb.append(", resMsg=").append(resMsg);
        sb.append(", remark=").append(remark);
        sb.append(", applyDate=").append(applyDate);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", applyUptime=").append(applyUptime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}