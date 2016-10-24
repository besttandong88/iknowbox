package com.tandong.iknowbox.erp.feemgr.web;

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
import com.tandong.iknowbox.common.web.BaseController;
import com.tandong.iknowbox.erp.feemgr.FeeRegInfo;
import com.tandong.iknowbox.erp.feemgr.service.IFeeMgrService;

/**
 * 费用登记信息页面请求处理
 * 
 * @author TanDong
 *
 */
@Controller
@RequestMapping("fee")
public class FeeMgrController extends BaseController {

	@Autowired
	private IFeeMgrService feeMgrService;

	/**
	 * 分页查询费用登记信息
	 * 
	 * @param pageSize
	 * @param currentPageNum
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> queryFeeRegInfo(@RequestParam Integer pageSize,
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

		PageList<FeeRegInfo> ret = feeMgrService.queryWithPage(params, pageBounds);

		return buildResult(pageSize, currentPage, ret);
	}

	/**
	 * 新增费用登记信息
	 * 
	 * @param p2pUser
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addFeeRegInfo(@RequestBody FeeRegInfo orderPurchase) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		feeMgrService.saveFeeRegInfo(orderPurchase);
		ret.put("success", true);
		return ret;
	}

	/**
	 * 更新费用登记信息
	 * 
	 * @param p2pUser
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateFeeRegInfo(@RequestBody FeeRegInfo orderPurchase)
			throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		feeMgrService.updateFeeRegInfo(orderPurchase);
		ret.put("success", true);
		return ret;
	}

	/**
	 * 删除费用登记信息
	 * 
	 * @param id
	 *            费用登记信息ID
	 * @return
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> delFeeRegInfo(@RequestParam long id) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		feeMgrService.delFeeRegInfo(id);
		ret.put("success", true);
		return ret;
	}
	
	@RequestMapping(value = "/delBatch", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> delFeeRegInfoBatch(@RequestParam("ids[]") List<Long> ids)
			throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		feeMgrService.delFeeRegInfo(ids);
		ret.put("success", true);
		return ret;
	}

}
