package com.service.handlers;

import org.apache.log4j.Logger;

import io.netty.channel.Channel;

import com.service.pojo.CreateBsInfo;
import com.service.pojo.UserInfo;
import com.service.system.SerSystem;

public class AddBsTask extends CommonTask {

	public AddBsTask(UserInfo info) {
		super(info);
		logger = Logger.getLogger(AddBsTask.class);
	}

	@Override
	public void run() {
		CreateBsInfo createBsInfo = (CreateBsInfo) info;
		try {
			Channel channel = SerSystem.getChannelGroup().getChannel(createBsInfo.getReceiveFrom());
			if(channel!=null&&channel.isActive()){
				int t =SerSystem.getLocalDbService().AddBs(info);
				if(t<=2&&t>0){
					SerSystem.getBsCount().addCount(createBsInfo.getBstype());
					createBsInfo.setValues(null);
					channel.writeAndFlush(createBsInfo);
				}	
			}   
			else
			logger.warn("channel is null, non user ["+createBsInfo.getReceiveFrom()+"] had login!");		
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e);
		}
		
	}

}
