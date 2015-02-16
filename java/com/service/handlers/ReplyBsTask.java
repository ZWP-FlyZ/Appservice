package com.service.handlers;

import io.netty.channel.Channel;

import org.apache.log4j.Logger;

import com.service.pojo.ReplyBsInfo;
import com.service.pojo.UserInfo;
import com.service.system.SerSystem;

public class ReplyBsTask extends CommonTask {
	public ReplyBsTask(UserInfo info) {
		super(info);
		logger = Logger.getLogger(ReplyBsTask.class);
	}
	@Override
	public void run() {
		ReplyBsInfo replyBsInfo = (ReplyBsInfo) info;
		try {
			Channel channel = SerSystem.getChannelGroup().getChannel(replyBsInfo.getReceiveFrom());
			if(channel!=null&&channel.isActive()){
				int t=SerSystem.getLocalDbService().ReplyBs(info);
				replyBsInfo.setValues(null);
				if(t>0)
				 channel.writeAndFlush(replyBsInfo);
				else {
					logger.debug("ReplyBsTask faile sql not success");
				}
			}  
			else
				logger.warn(" user ["+replyBsInfo.getReceiveFrom()+"]");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}	
	}

}
