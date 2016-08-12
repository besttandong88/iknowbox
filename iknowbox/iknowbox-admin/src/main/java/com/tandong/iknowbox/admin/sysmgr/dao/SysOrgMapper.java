package com.tandong.iknowbox.admin.sysmgr.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.tandong.iknowbox.admin.sysmgr.entity.SysOrg;

/**
 * 机构数据访问接口
 * 
 * @author TanDong
 * 
 */
public interface SysOrgMapper extends BaseMapper {
	
	
	/**
	 * 根据查询条件查询机构
	 * @param params 查询条件参数
	 * @return
	 * @throws Exception
	 */
	public List<SysOrg> queryByParams(Map<String, Object> params) throws Exception;

	/**
	 * 分页条件查询机构
	 * @param params
	 * @param pageBounds
	 * @return
	 * @throws Exception
	 */
	public PageList<SysOrg> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws Exception;
	
	/**
	 * 根据ID获取机构
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SysOrg getSysOrgById(long id) throws Exception;
	
	/**
	 * 插入机构
	 * @param sysOrg
	 * @return
	 * @throws Exception
	 */
	public Long insertSysOrg(SysOrg sysOrg) throws Exception;

	/**
	 * 修改机构
	 * @param sysOrg
	 * @return
	 * @throws Exception
	 */
	public Long updateSysOrg(SysOrg sysOrg) throws Exception;

	/**
	 * 删除机构
	 * @param id
	 * @throws Exception
	 */
	public void delSysOrg(Long id) throws Exception;

}
