package com.service.handlers;

import io.netty.channel.Channel;

import org.apache.log4j.Logger;

import com.service.dbservice.LocalDbService;
import com.service.pojo.RegInfo;
import com.service.pojo.UserInfo;
import com.service.system.SerSystem;
import com.service.system.SysValues;

public class RegTask extends CommonTask {

	Channel channel;	 
	//private static Log logfile = LogFactory.getLog("LogInLog"); 
	
	public RegTask(UserInfo info,Channel channel) {
		super(info);
		this.channel=channel;
		logger = Logger.getLogger(RegTask.class);
	}

	@Override
	public void run() {
		RegInfo regInfo = (RegInfo)info;
		LocalDbService ls= SerSystem.getLocalDbService();
		int uid =ls.Count("userInfoLocal")+SysValues.idStart;
		try {
			SerSystem.getLocalDbService().RegUserData(uid, info);
			SerSystem.getRemoteDbService().RegUserData(uid, info);
			regInfo.setValues(uid+"");
		} catch (Exception e) {
			regInfo.setValues("9999");
			logger.error(e);
		}
		if(channel!=null&&channel.isActive())
			channel.writeAndFlush(regInfo);
	}

}
