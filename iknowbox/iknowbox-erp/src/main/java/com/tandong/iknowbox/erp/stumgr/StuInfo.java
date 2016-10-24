package com.tandong.iknowbox.erp.stumgr;

import java.io.Serializable;

public class StuInfo implements Serializable {
    private Long id;

    private String stuName;

    private Integer stuGender;

    private Integer stuAge;

    private String stuId;

    private String stuPhone;

    private String stuAddress;

    private String stuFrom;

    private Integer signFlag;

    private String stuPName;

    private String stuPPhone;

    private String stuPRel;

    private String memo;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public Integer getStuGender() {
        return stuGender;
    }

    public void setStuGender(Integer stuGender) {
        this.stuGender = stuGender;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone == null ? null : stuPhone.trim();
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress == null ? null : stuAddress.trim();
    }

    public String getStuFrom() {
        return stuFrom;
    }

    public void setStuFrom(String stuFrom) {
        this.stuFrom = stuFrom == null ? null : stuFrom.trim();
    }

    public Integer getSignFlag() {
        return signFlag;
    }

    public void setSignFlag(Integer signFlag) {
        this.signFlag = signFlag;
    }

    public String getStuPName() {
        return stuPName;
    }

    public void setStuPName(String stuPName) {
        this.stuPName = stuPName == null ? null : stuPName.trim();
    }

    public String getStuPPhone() {
        return stuPPhone;
    }

    public void setStuPPhone(String stuPPhone) {
        this.stuPPhone = stuPPhone == null ? null : stuPPhone.trim();
    }

    public String getStuPRel() {
        return stuPRel;
    }

    public void setStuPRel(String stuPRel) {
        this.stuPRel = stuPRel == null ? null : stuPRel.trim();
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
        StuInfo other = (StuInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStuName() == null ? other.getStuName() == null : this.getStuName().equals(other.getStuName()))
            && (this.getStuGender() == null ? other.getStuGender() == null : this.getStuGender().equals(other.getStuGender()))
            && (this.getStuAge() == null ? other.getStuAge() == null : this.getStuAge().equals(other.getStuAge()))
            && (this.getStuId() == null ? other.getStuId() == null : this.getStuId().equals(other.getStuId()))
            && (this.getStuPhone() == null ? other.getStuPhone() == null : this.getStuPhone().equals(other.getStuPhone()))
            && (this.getStuAddress() == null ? other.getStuAddress() == null : this.getStuAddress().equals(other.getStuAddress()))
            && (this.getStuFrom() == null ? other.getStuFrom() == null : this.getStuFrom().equals(other.getStuFrom()))
            && (this.getSignFlag() == null ? other.getSignFlag() == null : this.getSignFlag().equals(other.getSignFlag()))
            && (this.getStuPName() == null ? other.getStuPName() == null : this.getStuPName().equals(other.getStuPName()))
            && (this.getStuPPhone() == null ? other.getStuPPhone() == null : this.getStuPPhone().equals(other.getStuPPhone()))
            && (this.getStuPRel() == null ? other.getStuPRel() == null : this.getStuPRel().equals(other.getStuPRel()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStuName() == null) ? 0 : getStuName().hashCode());
        result = prime * result + ((getStuGender() == null) ? 0 : getStuGender().hashCode());
        result = prime * result + ((getStuAge() == null) ? 0 : getStuAge().hashCode());
        result = prime * result + ((getStuId() == null) ? 0 : getStuId().hashCode());
        result = prime * result + ((getStuPhone() == null) ? 0 : getStuPhone().hashCode());
        result = prime * result + ((getStuAddress() == null) ? 0 : getStuAddress().hashCode());
        result = prime * result + ((getStuFrom() == null) ? 0 : getStuFrom().hashCode());
        result = prime * result + ((getSignFlag() == null) ? 0 : getSignFlag().hashCode());
        result = prime * result + ((getStuPName() == null) ? 0 : getStuPName().hashCode());
        result = prime * result + ((getStuPPhone() == null) ? 0 : getStuPPhone().hashCode());
        result = prime * result + ((getStuPRel() == null) ? 0 : getStuPRel().hashCode());
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
        sb.append(", stuName=").append(stuName);
        sb.append(", stuGender=").append(stuGender);
        sb.append(", stuAge=").append(stuAge);
        sb.append(", stuId=").append(stuId);
        sb.append(", stuPhone=").append(stuPhone);
        sb.append(", stuAddress=").append(stuAddress);
        sb.append(", stuFrom=").append(stuFrom);
        sb.append(", signFlag=").append(signFlag);
        sb.append(", stuPName=").append(stuPName);
        sb.append(", stuPPhone=").append(stuPPhone);
        sb.append(", stuPRel=").append(stuPRel);
        sb.append(", memo=").append(memo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}