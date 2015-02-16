package com.service.handlers;

import io.netty.channel.Channel;

import java.util.List;

import org.apache.log4j.Logger;

import com.service.model.BsThemeData;
import com.service.pojo.CommonInfo;
import com.service.pojo.UserInfo;
import com.service.pojo.UserInfoUtil;
import com.service.system.SerSystem;

public class SearchBsTask extends CommonTask {

	public SearchBsTask(UserInfo info) {
		super(info);
		logger = Logger.getLogger(SearchBsTask.class);
	}

	@Override
	public void run() {
		logger.debug("SearchBsTask run");
		CommonInfo commonInfo = (CommonInfo)info;
		String bstype=commonInfo.getValues();
		try {
			Channel channel = SerSystem.getChannelGroup().getChannel(commonInfo.getReceiveFrom());
			if(channel!=null&&channel.isActive()){
				List<BsThemeData> list = SerSystem.getLocalDbService().SearchBs(info);
				if(list!=null&&list.size()!=0)
					commonInfo.setValues(UserInfoUtil.getBsThemeValues(bstype,list));	 
				 channel.writeAndFlush(commonInfo);
			}	  
				else
					logger.warn(" user ["+commonInfo.getReceiveFrom()+"] LookBsTask faile ");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}

	
}
