package com.tandong.iknowbox.erp.feemgr.dao;

import com.tandong.iknowbox.erp.feemgr.FeeRegInfo;

public interface FeeRegInfoMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(FeeRegInfo record);

    int insertSelective(FeeRegInfo record);

    FeeRegInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FeeRegInfo record);

    int updateByPrimaryKey(FeeRegInfo record);
}