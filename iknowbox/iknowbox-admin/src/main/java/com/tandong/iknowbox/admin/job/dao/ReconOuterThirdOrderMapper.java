package com.tandong.iknowbox.admin.job.dao;

import com.tandong.iknowbox.admin.job.vo.ReconOuterThirdOrder;

public interface ReconOuterThirdOrderMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(ReconOuterThirdOrder record);

    int insertSelective(ReconOuterThirdOrder record);

    ReconOuterThirdOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ReconOuterThirdOrder record);

    int updateByPrimaryKey(ReconOuterThirdOrder record);
}