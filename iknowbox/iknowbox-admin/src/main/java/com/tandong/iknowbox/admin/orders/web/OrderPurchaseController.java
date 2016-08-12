package com.tandong.iknowbox.admin.orders.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.tandong.iknowbox.admin.orders.entity.OrderPurchase;
import com.tandong.iknowbox.admin.orders.service.IOrderPurchaseService;
import com.tandong.iknowbox.common.web.BaseController;

/**
 * 申购业务订单页面请求处理
 * 
 * @author TanDong
 *
 */
@Controller
@RequestMapping("orders/purchase")
public class OrderPurchaseController extends BaseController {

	@Autowired
	private IOrderPurchaseService orderPurchaseService;

	/**
	 * 分页查询申购业务订单
	 * 
	 * @param pageSize
	 * @param currentPageNum
	 * @return
	 */
	@RequestMapping(value = "/queryOrderPurchase", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> queryOrderPurchase(@RequestParam Integer pageSize,
			@RequestParam Integer currentPage, @RequestParam String condition, @RequestParam String fundChannel,
			@RequestParam String orderStatus, @RequestParam String purStartTime, @RequestParam String purEndTime) throws ApplicationException {

		Map<String, Object> params = new HashMap<String, Object>();

		PageBounds pageBounds = buildPageBounds(pageSize, currentPage, true);
		if (null != condition && !"".equals(condition)) {
			params.put("condition", "%" + condition + "%");
		}
		if (null != fundChannel && !"".equals(fundChannel)) {
			params.put("fundChannel", fundChannel);
		}
		if (null != orderStatus && !"".equals(orderStatus)) {
			params.put("orderStatus", orderStatus);
		}
		if (null != purStartTime && !"".equals(purStartTime)) {
			params.put("purStartTime", purStartTime);
		}
		if (null != purEndTime && !"".equals(purEndTime)) {
			params.put("purEndTime", purEndTime);
		}

		PageList<OrderPurchase> ret = orderPurchaseService.queryWithPage(params, pageBounds);

		return buildResult(pageSize, currentPage, ret);
	}

	/**
	 * 新增申购业务订单
	 * 
	 * @param p2pUser
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addOrderPurchase(@RequestBody OrderPurchase orderPurchase) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		orderPurchaseService.saveOrderPurchase(orderPurchase);
		ret.put("success", true);
		return ret;
	}

	/**
	 * 更新申购业务订单
	 * 
	 * @param p2pUser
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateOrderPurchase(@RequestBody OrderPurchase orderPurchase)
			throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		orderPurchaseService.updateOrderPurchase(orderPurchase);
		ret.put("success", true);
		return ret;
	}

	/**
	 * 删除申购业务订单
	 * 
	 * @param id
	 *            申购业务订单ID
	 * @return
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/delOrderPurchase", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> delOrderPurchase(@RequestParam long id) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		orderPurchaseService.delOrderPurchase(id);
		ret.put("success", true);
		return ret;
	}
	
	@RequestMapping(value = "/delOrderPurchaseBatch", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> delOrderPurchaseBatch(@RequestParam("ids[]") List<Long> ids)
			throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		orderPurchaseService.delOrderPurchase(ids);
		ret.put("success", true);
		return ret;
	}

}
