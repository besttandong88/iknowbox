package com.tandong.iknowbox.admin.job.dao;

import com.tandong.iknowbox.admin.job.vo.ReconOuterPlatOrder;

public interface ReconOuterPlatOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ReconOuterPlatOrder record);

    int insertSelective(ReconOuterPlatOrder record);

    ReconOuterPlatOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ReconOuterPlatOrder record);

    int updateByPrimaryKey(ReconOuterPlatOrder record);
}