/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.erp.feemgr<br/>
 * <b>文件名：</b>IFeeMgrService.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年10月24日-下午1:53:39<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.erp.feemgr.service;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.tandong.iknowbox.common.exception.ApplicationException;
import com.tandong.iknowbox.erp.feemgr.FeeRegInfo;

/**
 *
 * IFeeMgrService
 * 
 * @author TanDong
 * 2016年10月24日 下午1:53:39
 * 
 * @version 1.0.0
 *
 */
public interface IFeeMgrService {
	
	/**
	 * 分页查询费用登记信息
	 * @return
	 * @throws ApplicationException
	 */
	public PageList<FeeRegInfo> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws ApplicationException;
	
	/**
	 * 增加费用登记信息
	 * @param dictType
	 * @throws ApplicationException
	 */
	public void saveFeeRegInfo(FeeRegInfo sysUser) throws ApplicationException;
	
	/**
	 * 更新费用登记信息信息 
	 * @param dictType
	 * @throws ApplicationException
	 */
	public void updateFeeRegInfo(FeeRegInfo sysUser) throws ApplicationException;
	
	/**
	 * 删除费用登记信息信息
	 * @param id 费用登记信息ID
	 * @throws ApplicationException
	 */
	public void delFeeRegInfo(long id) throws ApplicationException;
	
	/**
	 * delFeeRegInfo(这里用一句话描述这个方法的作用)<br/>
	 * @param ids
	 * @throws ApplicationException
	 * void
	 * @exception
	 * @since  1.0.0
	*/
	public void delFeeRegInfo(List<Long> ids) throws ApplicationException;
	
	/**
	 * 根据ID获取费用登记信息信息
	 * @param id 费用登记信息ID
	 * @return
	 * @throws ApplicationException
	 */
	public FeeRegInfo getFeeRegInfo(long id) throws ApplicationException;

}
