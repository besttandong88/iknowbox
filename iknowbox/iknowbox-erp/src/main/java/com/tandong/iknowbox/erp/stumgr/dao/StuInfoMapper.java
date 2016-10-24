package com.tandong.iknowbox.erp.stumgr.dao;

import com.tandong.iknowbox.erp.stumgr.StuInfo;

public interface StuInfoMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(StuInfo record);

    int insertSelective(StuInfo record);

    StuInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StuInfo record);

    int updateByPrimaryKey(StuInfo record);
}