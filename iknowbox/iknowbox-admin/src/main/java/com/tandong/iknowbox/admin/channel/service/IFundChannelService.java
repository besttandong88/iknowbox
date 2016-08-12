package com.tandong.iknowbox.admin.channel.service;

import java.util.List;

import com.tandong.iknowbox.admin.channel.entity.FundChannel;
import com.tandong.iknowbox.common.exception.ApplicationException;

/**
 * 
 * 基金渠道服务接口
 * 
 * @author TanDong
 *
 */
public interface IFundChannelService {
	
	
	public List<FundChannel> getAllChannel() throws ApplicationException;

}
