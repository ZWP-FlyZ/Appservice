package com.service.handlers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import io.netty.channel.Channel;

import com.service.model.LogInData;
import com.service.pojo.CommonInfo;
import com.service.pojo.UserInfo;
import com.service.system.SerSystem;

public class LogInTask extends CommonTask {
	
	private Channel channel;
	
	
	private static Log logfile = LogFactory.getLog("LogInLog"); 
	
	public LogInTask(UserInfo info,Channel channel) {
		super(info);
		this.channel=channel;
		logger = Logger.getLogger(LogInTask.class);
	}

	@Override
	public void run() {
		CommonInfo sCommonInfo = (CommonInfo) info;	
		
		try {
			LogInData tData = SerSystem.getLocalDbService().GetLogInData(sCommonInfo);
			if(tData==null){
				logfile.info(" Login error [userName:"+sCommonInfo.getReceiveFrom()+"]  does't reg !");
				logger.debug(" Login error [userName:"+sCommonInfo.getReceiveFrom()+"]  does't reg !");
				sCommonInfo.setValues("0");//用户不存在			
			}else if(!tData.getU_Password().equals(sCommonInfo.getValues())){
				logfile.info(" Login error [userName:"+sCommonInfo.getReceiveFrom()+"]  password error !");
				logger.debug(" Login error [userName:"+sCommonInfo.getValues()+"]  password error !");
				sCommonInfo.setValues("1");//密码错误	
			}else {
				SerSystem.getChannelGroup().remove(tData.getU_Id()+"");
				SerSystem.getChannelGroup().add(tData.getU_Id()+"", channel);
				logfile.info("[userName:"+sCommonInfo.getReceiveFrom()+"]  [userId:"+tData.getU_Id()+"]");
				sCommonInfo.setReceiveFrom(tData.getU_Id()+"");
				sCommonInfo.setValues(null);
			}
			channel.writeAndFlush(sCommonInfo);
		} catch (Exception e) {
			logger.error(e);
		}
		
	}

}
