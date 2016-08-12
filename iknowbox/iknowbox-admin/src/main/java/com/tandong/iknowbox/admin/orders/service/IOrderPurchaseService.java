package com.tandong.iknowbox.admin.orders.service;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.tandong.iknowbox.admin.orders.entity.OrderPurchase;
import com.tandong.iknowbox.common.exception.ApplicationException;

/**
 * 
 * 申购业务订单服务接口
 * 
 * @author TanDong
 *
 */
public interface IOrderPurchaseService {
	
	/**
	 * 分页查询申购业务订单
	 * @return
	 * @throws ApplicationException
	 */
	public PageList<OrderPurchase> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws ApplicationException;
	
	/**
	 * 增加申购业务订单
	 * @param dictType
	 * @throws ApplicationException
	 */
	public void saveOrderPurchase(OrderPurchase sysUser) throws ApplicationException;
	
	/**
	 * 更新申购业务订单信息 
	 * @param dictType
	 * @throws ApplicationException
	 */
	public void updateOrderPurchase(OrderPurchase sysUser) throws ApplicationException;
	
	/**
	 * 删除申购业务订单信息
	 * @param id 申购业务订单ID
	 * @throws ApplicationException
	 */
	public void delOrderPurchase(long id) throws ApplicationException;
	
	public void delOrderPurchase(List<Long> ids) throws ApplicationException;
	
	/**
	 * 根据ID获取申购业务订单信息
	 * @param id 申购业务订单ID
	 * @return
	 * @throws ApplicationException
	 */
	public OrderPurchase getOrderPurchase(long id) throws ApplicationException;

}
