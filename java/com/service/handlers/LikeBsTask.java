package com.service.handlers;

import io.netty.channel.Channel;

import org.apache.log4j.Logger;

import com.service.pojo.CommonInfo;
import com.service.pojo.UserInfo;
import com.service.system.SerSystem;

public class LikeBsTask extends CommonTask {

	public LikeBsTask(UserInfo info) {
		super(info);
		logger = Logger.getLogger(LikeBsTask.class);
	}

	@Override
	public void run() {
		CommonInfo commonInfo = (CommonInfo)info;
		try {
			Channel channel = SerSystem.getChannelGroup().getChannel(commonInfo.getReceiveFrom());
			if(channel!=null&&channel.isActive()){
				int t=SerSystem.getLocalDbService().LikeBs(info);
				commonInfo.setValues(null);
				if(t>0)
				channel.writeAndFlush(commonInfo);
			}  
				else
					logger.warn(" user ["+commonInfo.getReceiveFrom()+"] LikeBsTask faile ");
		
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		
	}

}
