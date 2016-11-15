/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.tandong.iknowbox.examples<br/>
 * <b>文件名：</b>ExamplesController.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年9月27日-下午5:09:30<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.tandong.iknowbox.examples;

import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tandong.iknowbox.admin.TestMessage;
import com.tandong.iknowbox.admin.api.DubboService;
import com.tandong.iknowbox.common.web.BaseController;

/**
 *
 * ExamplesController
 * 
 * @author TanDong
 * 2016年9月27日 下午5:09:30
 * 
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping("examples/dubbo ")
public class ExamplesController  extends BaseController {

	@Autowired
	private DubboService testDubboService;
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> addOrderPurchase() throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		
		TestMessage msg = new TestMessage();
		testDubboService.test(msg);
		ret.put("success", true);
		return ret;
	}

}
