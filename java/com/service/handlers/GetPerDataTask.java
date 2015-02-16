package com.service.handlers;

import io.netty.channel.Channel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import com.service.model.PerDataLoc;
import com.service.model.PerDataLocS;
import com.service.model.PerDataRem;
import com.service.model.PerDataRemS;
import com.service.pojo.CommonInfo;
import com.service.pojo.UserInfo;
import com.service.pojo.UserInfoUtil;
import com.service.system.SerSystem;

public class GetPerDataTask extends CommonTask{

	//private static Log logfileGetPerLog = LogFactory.getLog("GetPerLog");	 
	private static Log logfileWarnLog = LogFactory.getLog("WarnLog");
	
	public GetPerDataTask(UserInfo info) {
		super(info);
		logger = Logger.getLogger(GetPerDataTask.class);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		CommonInfo sCommonInfo= (CommonInfo)info;
		try {
			Channel channel = SerSystem.getChannelGroup().getChannel(sCommonInfo.getReceiveFrom());			
			if(channel!=null&&channel.isActive()){
				PerDataLoc loc	  = SerSystem.getLocalDbService().GetPerDataLoc(info);
				PerDataLocS locs  = SerSystem.getLocalDbService().GetPerDataLocS(info);
				PerDataRem rem    = SerSystem.getRemoteDbService().GetPerDataRem(info);
				PerDataRemS rems  = SerSystem.getRemoteDbService().GetPerDataRemS(info);
				sCommonInfo.setValues(UserInfoUtil.getPerValues(loc, locs, rem, rems));
				channel.writeAndFlush(sCommonInfo);
			}
			else {
				logfileWarnLog.warn("channel is null, non user ["+sCommonInfo.getReceiveFrom()+"] had login!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}

}
