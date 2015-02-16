package com.service.handlers;

import io.netty.channel.Channel;

import org.apache.log4j.Logger;

import com.service.pojo.CommonInfo;
import com.service.pojo.UserInfo;
import com.service.system.SerSystem;

public class ChangePerTask extends CommonTask {

	public ChangePerTask(UserInfo info) {
		super(info);
		logger = Logger.getLogger(ChangePerTask.class);
	}
	@Override
	public void run() {
		
		CommonInfo commonInfo = (CommonInfo)info;
		try {
			Channel channel = SerSystem.getChannelGroup().getChannel(commonInfo.getReceiveFrom());
			if(channel!=null&&channel.isActive()){
				int t = SerSystem.getLocalDbService().ChanPerData(info);
				    t+=SerSystem.getRemoteDbService().ChanPerData(info); 
				if(t>=6){
					commonInfo.setValues("1");
					channel.writeAndFlush(commonInfo);
				}
				else{
					commonInfo.setValues("0");
					channel.writeAndFlush(commonInfo);
					logger.warn(" user ["+commonInfo.getReceiveFrom()+"] ChangePerTask faile ");	
				}	
			}   
			else
			logger.warn("channel is null, non user ["+commonInfo.getReceiveFrom()+"] had login!");		
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e);
		}
	}

}
