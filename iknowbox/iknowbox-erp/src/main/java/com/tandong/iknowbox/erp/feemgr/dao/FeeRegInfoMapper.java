package com.tandong.iknowbox.erp.feemgr.dao;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.tandong.iknowbox.erp.feemgr.FeeRegInfo;

public interface FeeRegInfoMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(FeeRegInfo record);

    int insertSelective(FeeRegInfo record);

    FeeRegInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FeeRegInfo record);

    int updateByPrimaryKey(FeeRegInfo record);
    
    /**
	 * 分页条件查询FeeRegInfo
	 * @param params
	 * @param pageBounds
	 * @return
	 * @throws Exception
	 */
	public PageList<FeeRegInfo> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws Exception;
}