package com.service.handlers;

import io.netty.channel.Channel;

import org.apache.log4j.Logger;

import com.service.dbservice.LocalDbService;
import com.service.pojo.CommonInfo;
import com.service.pojo.UserInfo;
import com.service.system.SerSystem;

public class RegCheckTask extends CommonTask{

	
	private Channel channel;
	public RegCheckTask(UserInfo info,Channel channel) {
		super(info);
		this.channel=channel;
		logger = Logger.getLogger(RegCheckTask.class);
	}

	@Override
	public void run() {
		logger.debug("RegCheckTask run");
		LocalDbService dbService = SerSystem.getLocalDbService();
		CommonInfo sCommonInfo = (CommonInfo) info;		
		try {
			if(dbService.CheckUserName(sCommonInfo.getReceiveFrom())){
				sCommonInfo.setValues("1");
			}
			else {
				sCommonInfo.setValues("0");
			}
				if(channel!=null)
				   channel.writeAndFlush(sCommonInfo);
				else {
					logger.error("channel is null! channel name is "+ sCommonInfo.getReceiveFrom());
				}
		} catch (Exception e) {
			logger.error(e);
		}
		
	}

}
