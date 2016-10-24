/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.erp.feemgr.service.impl<br/>
 * <b>文件名：</b>FeeMgrServiceImpl.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年10月24日-下午1:57:47<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.erp.feemgr.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.tandong.iknowbox.common.exception.ApplicationException;
import com.tandong.iknowbox.erp.feemgr.FeeRegInfo;
import com.tandong.iknowbox.erp.feemgr.dao.FeeRegInfoMapper;
import com.tandong.iknowbox.erp.feemgr.service.IFeeMgrService;

/**
 *
 * FeeMgrServiceImpl
 * 
 * @author TanDong
 * 2016年10月24日 下午1:57:47
 * 
 * @version 1.0.0
 *
 */
public class FeeMgrServiceImpl implements IFeeMgrService {

	private static Log logger = LogFactory.getLog(FeeMgrServiceImpl.class);

	@Autowired
	private FeeRegInfoMapper feeRegInfoMapper;
	
	/* 
	 * 保存系统费用登记信息，同时保存费用登记信息的权限设置
	 * @see com.tandong.ssm.sysmgr.service.IFeeRegInfoService#saveFeeRegInfo(com.tandong.ssm.sysmgr.entity.FeeRegInfo)
	 */
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void saveFeeRegInfo(FeeRegInfo orderPurchase)
			throws ApplicationException {
		try{
			//插入费用登记信息主表
			feeRegInfoMapper.insert(orderPurchase);
			
		}catch(Exception e){
			logger.error("添加费用登记信息失败", e);
			throw new ApplicationException("error.dictitem.add");
		}
	}

	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void updateFeeRegInfo(FeeRegInfo orderPurchase) throws ApplicationException {
		try{
			feeRegInfoMapper.updateByPrimaryKeySelective(orderPurchase);
		}catch(Exception e){
			logger.error("更新费用登记信息失败", e);
			throw new ApplicationException("error.dictitem.update");
		}
	}

	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void delFeeRegInfo(long id) throws ApplicationException {
		try{
			//删除系统费用登记信息
			feeRegInfoMapper.deleteByPrimaryKey(id);
		}catch(Exception e){
			logger.error("删除费用登记信息失败", e);
			throw new ApplicationException("error.dictitem.delete");
		}
	}
	
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void delFeeRegInfo(List<Long> ids) throws ApplicationException {
		try{
			
			for(int i=0; i<ids.size(); i++){
				//删除系统费用登记信息
				feeRegInfoMapper.deleteByPrimaryKey(ids.get(i));
			}
			
		}catch(Exception e){
			logger.error("删除费用登记信息失败", e);
			throw new ApplicationException("error.dictitem.delete");
		}
	}
	
	public FeeRegInfo getFeeRegInfo(long id) throws ApplicationException {
		try{
			return feeRegInfoMapper.selectByPrimaryKey(id);
		}catch(Exception e){
			logger.error("获取费用登记信息失败", e);
			throw new ApplicationException("error.orderPurchase.get");
		}
	}

	public PageList<FeeRegInfo> queryWithPage( Map<String, Object> params, PageBounds pageBounds) throws ApplicationException {
		try{
			return feeRegInfoMapper.queryWithPage(params, pageBounds);
		} catch (Exception e) {
			logger.error("查询费用登记信息失败", e);
			throw new ApplicationException("error.membermain.query");
		}
	}
}
