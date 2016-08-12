package com.tandong.iknowbox.admin.orders.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.tandong.iknowbox.admin.orders.dao.OrderPurchaseMapper;
import com.tandong.iknowbox.admin.orders.entity.OrderPurchase;
import com.tandong.iknowbox.admin.orders.service.IOrderPurchaseService;
import com.tandong.iknowbox.common.exception.ApplicationException;

/**
 * 申购业务订单服务实现
 * 
 * @author TanDong
 *
 */
@Service("orderPurchaseService")
@Transactional(readOnly = true)
public class OrderPurchaseServiceImpl implements IOrderPurchaseService {

	private static Log logger = LogFactory.getLog(OrderPurchaseServiceImpl.class);

	@Autowired
	private OrderPurchaseMapper orderPurchaseMapper;
	
	/* 
	 * 保存系统申购业务订单，同时保存申购业务订单的权限设置
	 * @see com.tandong.ssm.sysmgr.service.IOrderPurchaseService#saveOrderPurchase(com.tandong.ssm.sysmgr.entity.OrderPurchase)
	 */
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void saveOrderPurchase(OrderPurchase orderPurchase)
			throws ApplicationException {
		try{
			//插入申购业务订单主表
			orderPurchaseMapper.insertOrderPurchase(orderPurchase);
			
		}catch(Exception e){
			logger.error("添加申购业务订单失败", e);
			throw new ApplicationException("error.dictitem.add");
		}
	}

	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void updateOrderPurchase(OrderPurchase orderPurchase) throws ApplicationException {
		try{
			orderPurchaseMapper.updateOrderPurchase(orderPurchase);
		}catch(Exception e){
			logger.error("更新申购业务订单失败", e);
			throw new ApplicationException("error.dictitem.update");
		}
	}

	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void delOrderPurchase(long id) throws ApplicationException {
		try{
			//删除系统申购业务订单
			orderPurchaseMapper.delOrderPurchase(id);
		}catch(Exception e){
			logger.error("删除申购业务订单失败", e);
			throw new ApplicationException("error.dictitem.delete");
		}
	}
	
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void delOrderPurchase(List<Long> ids) throws ApplicationException {
		try{
			
			for(int i=0; i<ids.size(); i++){
				//删除系统申购业务订单
				orderPurchaseMapper.delOrderPurchase(ids.get(i));
			}
			
		}catch(Exception e){
			logger.error("删除申购业务订单失败", e);
			throw new ApplicationException("error.dictitem.delete");
		}
	}
	
	public OrderPurchase getOrderPurchase(long id) throws ApplicationException {
		try{
			return orderPurchaseMapper.getOrderPurchaseById(id);
		}catch(Exception e){
			logger.error("获取申购业务订单失败", e);
			throw new ApplicationException("error.orderPurchase.get");
		}
	}

	public PageList<OrderPurchase> queryWithPage( Map<String, Object> params, PageBounds pageBounds) throws ApplicationException {
		try{
			return orderPurchaseMapper.queryWithPage(params, pageBounds);
		} catch (Exception e) {
			logger.error("查询申购业务订单失败", e);
			throw new ApplicationException("error.membermain.query");
		}
	}

}
