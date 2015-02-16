package com.service.handlers;

import io.netty.channel.Channel;

import java.util.List;

import org.apache.log4j.Logger;

import com.service.dbservice.LocalDbService;
import com.service.model.BsReplyData;
import com.service.pojo.CommonInfo;
import com.service.pojo.UserInfo;
import com.service.system.SerSystem;

public class LookBsTask extends CommonTask {

	public LookBsTask(UserInfo info) {
		super(info);
		logger = Logger.getLogger(LookBsTask.class);
	}

	@Override
	public void run() {
		CommonInfo commonInfo = (CommonInfo)info;
		try {
			
			Channel channel = SerSystem.getChannelGroup().getChannel(commonInfo.getReceiveFrom());
			if(channel!=null&&channel.isActive()){
				LocalDbService service = SerSystem.getLocalDbService();
				String bodyString = service.GetBsBody(info);
				if(bodyString==null)
					commonInfo.setValues(null);
				else {
					List<BsReplyData> list=service.LookBs(info);
					String vus=""+bodyString;
					if(list!=null&&list.size()!=0)
					for(int i=0;i<list.size();i++)
						vus+=":"+list.get(i).getNickname()+
							 ":"+list.get(i).getBody();
					commonInfo.setValues(vus);
				}
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
