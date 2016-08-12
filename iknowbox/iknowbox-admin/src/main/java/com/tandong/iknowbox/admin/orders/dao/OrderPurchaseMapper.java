package com.tandong.iknowbox.admin.orders.dao;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.tandong.iknowbox.admin.orders.entity.OrderPurchase;

public interface OrderPurchaseMapper {
	
    int delOrderPurchase(long id) throws Exception;

    int insertOrderPurchase(OrderPurchase record) throws Exception;

    OrderPurchase getOrderPurchaseById(long id) throws Exception;

    int updateOrderPurchase(OrderPurchase record) throws Exception;
    
	/**
	 * 分页条件查询OrderPurchase
	 * @param params
	 * @param pageBounds
	 * @return
	 * @throws Exception
	 */
	public PageList<OrderPurchase> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws Exception;
}