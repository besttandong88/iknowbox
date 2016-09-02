package com.tandong.iknowbox.admin.channel.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tandong.iknowbox.admin.channel.dao.FundChannelMapper;
import com.tandong.iknowbox.admin.channel.entity.FundChannel;
import com.tandong.iknowbox.admin.channel.service.IFundChannelService;
import com.tandong.iknowbox.common.exception.ApplicationException;

/**
 * 申购业务订单服务实现
 * 
 * @author TanDong
 *
 */
@Service("fundChannelService")
@Transactional(readOnly = true)
public class FundChannelServiceImpl implements IFundChannelService {

	private static Log logger = LogFactory.getLog(FundChannelServiceImpl.class);

	@Autowired
	private FundChannelMapper fundChannelMapper;
	
	public List<FundChannel> getAllChannel() throws ApplicationException {
		try{
			return fundChannelMapper.getAllChannel();
		} catch (Exception e) {
			logger.error("查询基金渠道信息失败", e);
			throw new ApplicationException("error.fundchannel.query");
		}
	}

	/* (non-Javadoc)
	 * @see com.tandong.iknowbox.admin.channel.service.IFundChannelService#insertFundChannelHis(java.lang.String)
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public int insertFundChannelHis(String batchNo) {
		int i=0; 
		try {
			i = fundChannelMapper.insertFundChannelHis(batchNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	

}
