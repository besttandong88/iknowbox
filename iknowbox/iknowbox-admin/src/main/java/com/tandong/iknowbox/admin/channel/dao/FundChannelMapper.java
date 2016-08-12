package com.tandong.iknowbox.admin.channel.dao;

import java.util.List;

import com.tandong.iknowbox.admin.channel.entity.FundChannel;

public interface FundChannelMapper {
	
    List<FundChannel> getAllChannel() throws Exception;

}