package com.tandong.iknowbox.erp.feemgr;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FeeRegInfo implements Serializable {
	
    private Long id;

    private Date regTime;

    private Date feeDate;

    private Integer feeType;

    private BigDecimal amount;

    private String feeUse;

    private String regUser;

    private String memo;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getFeeDate() {
        return feeDate;
    }

    public void setFeeDate(Date feeDate) {
        this.feeDate = feeDate;
    }

    public Integer getFeeType() {
        return feeType;
    }

    public void setFeeType(Integer feeType) {
        this.feeType = feeType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getFeeUse() {
        return feeUse;
    }

    public void setFeeUse(String feeUse) {
        this.feeUse = feeUse == null ? null : feeUse.trim();
    }

    public String getRegUser() {
        return regUser;
    }

    public void setRegUser(String regUser) {
        this.regUser = regUser == null ? null : regUser.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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
        FeeRegInfo other = (FeeRegInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRegTime() == null ? other.getRegTime() == null : this.getRegTime().equals(other.getRegTime()))
            && (this.getFeeDate() == null ? other.getFeeDate() == null : this.getFeeDate().equals(other.getFeeDate()))
            && (this.getFeeType() == null ? other.getFeeType() == null : this.getFeeType().equals(other.getFeeType()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getFeeUse() == null ? other.getFeeUse() == null : this.getFeeUse().equals(other.getFeeUse()))
            && (this.getRegUser() == null ? other.getRegUser() == null : this.getRegUser().equals(other.getRegUser()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRegTime() == null) ? 0 : getRegTime().hashCode());
        result = prime * result + ((getFeeDate() == null) ? 0 : getFeeDate().hashCode());
        result = prime * result + ((getFeeType() == null) ? 0 : getFeeType().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getFeeUse() == null) ? 0 : getFeeUse().hashCode());
        result = prime * result + ((getRegUser() == null) ? 0 : getRegUser().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", regTime=").append(regTime);
        sb.append(", feeDate=").append(feeDate);
        sb.append(", feeType=").append(feeType);
        sb.append(", amount=").append(amount);
        sb.append(", feeUse=").append(feeUse);
        sb.append(", regUser=").append(regUser);
        sb.append(", memo=").append(memo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}