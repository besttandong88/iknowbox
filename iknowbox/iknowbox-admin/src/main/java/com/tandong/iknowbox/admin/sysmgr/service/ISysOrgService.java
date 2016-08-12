package com.tandong.iknowbox.admin.sysmgr.service;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.tandong.iknowbox.admin.sysmgr.entity.SysOrg;
import com.tandong.iknowbox.admin.sysmgr.web.TreeNode;
import com.tandong.iknowbox.common.exception.ApplicationException;

/**
 * 
 * 机构服务接口
 * 
 * @author TanDong
 *
 */
public interface ISysOrgService {
	
	public List<TreeNode> getSysOrgTree(long parent) throws ApplicationException;
	
	/**
	 * 分页查询机构
	 * @return
	 * @throws ApplicationException
	 */
	public PageList<SysOrg> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws ApplicationException;
	
	
	/**
	 * 增加机构
	 * @param sysOrg
	 * @throws ApplicationException
	 */
	public void saveSysOrg(SysOrg sysOrg) throws ApplicationException;
	
	/**
	 * 更新机构信息 
	 * @param sysOrg
	 * @throws ApplicationException
	 */
	public void updateSysOrg(SysOrg sysOrg) throws ApplicationException;
	
	/**
	 * 删除机构信息
	 * @param id 机构ID
	 * @throws ApplicationException
	 */
	public void delSysOrg(long id) throws ApplicationException;
	
	/**
	 * 根据ID获取机构信息
	 * @param id 机构ID
	 * @return
	 * @throws ApplicationException
	 */
	public SysOrg getSysOrg(long id) throws ApplicationException;

}
