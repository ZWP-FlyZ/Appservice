package com.service.handlers;

import io.netty.channel.Channel;

import org.apache.log4j.Logger;

import com.service.pojo.CommonInfo;
import com.service.pojo.UserInfo;
import com.service.system.SerSystem;

public class BbsCountTask extends CommonTask{

	public BbsCountTask(UserInfo info) {
		super(info);
		logger = Logger.getLogger(BbsCountTask.class);
	}

	@Override
	public void run() {
		CommonInfo commonInfo = (CommonInfo)info;
		try {
			Channel channel = SerSystem.getChannelGroup().getChannel(commonInfo.getReceiveFrom());
			if(channel!=null&&channel.isActive()){
				commonInfo.setValues(SerSystem.getBsCount().toString());
				channel.writeAndFlush(commonInfo);	
			}   
			else
			logger.warn("channel is null, non user ["+commonInfo.getReceiveFrom()+"] had login!");		
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e);
		}
			
	}

}
