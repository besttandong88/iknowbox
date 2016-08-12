package com.tandong.iknowbox.admin.sysmgr.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.tandong.iknowbox.admin.sysmgr.dao.SysOrgMapper;
import com.tandong.iknowbox.admin.sysmgr.entity.SysOrg;
import com.tandong.iknowbox.admin.sysmgr.service.ISysOrgService;
import com.tandong.iknowbox.admin.sysmgr.web.TreeNode;
import com.tandong.iknowbox.common.exception.ApplicationException;

/**
 * 机构服务实现
 * 
 * @author TanDong
 *
 */
@Service("sysOrgService")
@Transactional(readOnly = true)
public class SysOrgServiceImpl implements ISysOrgService {

	private static Log logger = LogFactory.getLog(SysOrgServiceImpl.class);

	@Autowired
	private SysOrgMapper sysOrgMapper;
	
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void saveSysOrg(SysOrg sysOrg)
			throws ApplicationException {
		try{
			sysOrgMapper.insertSysOrg(sysOrg);
		}catch(Exception e){
			logger.error("添加机构失败", e);
			throw new ApplicationException("error.dictitem.add");
		}
	}

	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void updateSysOrg(SysOrg sysOrg)
			throws ApplicationException {
		try{
			sysOrgMapper.updateSysOrg(sysOrg);
		}catch(Exception e){
			logger.error("更新机构失败", e);
			throw new ApplicationException("error.dictitem.update");
		}
	}

	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void delSysOrg(long id) throws ApplicationException {
		try{
			sysOrgMapper.delSysOrg(id);
		}catch(Exception e){
			logger.error("删除机构失败", e);
			throw new ApplicationException("error.dictitem.delete");
		}
	}
	
	public SysOrg getSysOrg(long id) throws ApplicationException {
		try{
			return sysOrgMapper.getSysOrgById(id);
		}catch(Exception e){
			logger.error("获取机构失败", e);
			throw new ApplicationException("error.sysOrg.get");
		}
	}

	public PageList<SysOrg> queryWithPage( Map<String, Object> params, PageBounds pageBounds) throws ApplicationException {
		try{
			return sysOrgMapper.queryWithPage(params, pageBounds);
		} catch (Exception e) {
			logger.error("查询机构失败", e);
			throw new ApplicationException("error.sysorg.query");
		}
	}

	/* (non-Javadoc)
	 * @see com.tandong.ssm.sysmgr.service.ISysOrgService#getSysOrgTree(long)
	 */
	public List<TreeNode> getSysOrgTree(long parent) throws ApplicationException {
		
		List<TreeNode> ret = new ArrayList<TreeNode>();
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parent", parent);
		try {
			List<SysOrg> orgs = sysOrgMapper.queryByParams(params);
			for(SysOrg org : orgs){
				TreeNode treeNode = new TreeNode();
				treeNode.setId(String.valueOf(org.getId()));
				treeNode.setText(org.getOrgName());
				treeNode.setState("closed");
				if(org.getHasChild() == "1"){
					treeNode.setChildren(getSysOrgTree(org.getId()));
				}
				ret.add(treeNode);
			}
		} catch (Exception e) {
			logger.error("查询机构失败", e);
			throw new ApplicationException("error.sysorg.query");
		}
		return ret;
	}

}
