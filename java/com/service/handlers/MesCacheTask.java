package com.service.handlers;

import io.netty.channel.Channel;

import org.apache.log4j.Logger;

import com.service.pojo.CommonInfo;
import com.service.pojo.UserInfo;
import com.service.system.SerSystem;

public class MesCacheTask extends CommonTask{

	public MesCacheTask(UserInfo info) {
		super(info);
		logger = Logger.getLogger(MesCacheTask.class);
	}

	@Override
	public void run() {
		CommonInfo commonInfo = (CommonInfo) info;		
		try {
		    Channel channel  = SerSystem.getChannelGroup().getChannel(commonInfo.getReceiveFrom());
		    if(channel!=null&&channel.isActive()){
		    	String tmp=SerSystem.getLocalDbService().GetMsgCacheAndDelete(info);
				if(tmp==null)
				   commonInfo.setValues("null");
				else 
				   commonInfo.setValues(tmp);
				channel.writeAndFlush(commonInfo);
		    }    
			else 
				logger.warn(" user ["+commonInfo.getReceiveFrom()+"]");
		    
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		
	}
}
