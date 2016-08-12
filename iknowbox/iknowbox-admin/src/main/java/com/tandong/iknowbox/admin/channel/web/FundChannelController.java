package com.tandong.iknowbox.admin.channel.web;

import java.util.List;
import java.util.Map;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tandong.iknowbox.admin.channel.entity.FundChannel;
import com.tandong.iknowbox.admin.channel.service.IFundChannelService;
import com.tandong.iknowbox.common.web.BaseController;

/**
 * 申购业务订单页面请求处理
 * 
 * @author TanDong
 *
 */
@Controller
@RequestMapping("channel/fund")
public class FundChannelController extends BaseController {

	@Autowired
	private IFundChannelService fundChannelService;

	/**
	 * 分页查询申购业务订单
	 * 
	 * @param pageSize
	 * @param currentPageNum
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> queryOrderPurchase() throws ApplicationException {

		List<FundChannel> ret = fundChannelService.getAllChannel();

		return buildResult(ret);
	}

}
