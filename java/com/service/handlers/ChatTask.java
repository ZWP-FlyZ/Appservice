package com.service.handlers;

import io.netty.channel.Channel;

import org.apache.log4j.Logger;

import com.service.pojo.ChatInfo;
import com.service.pojo.UserInfo;
import com.service.system.SerSystem;

public class ChatTask extends CommonTask{

	public ChatTask(UserInfo info) {
		super(info);
		logger = Logger.getLogger(ChatTask.class);
	}

	@Override
	public void run() {
		ChatInfo chatInfo = (ChatInfo) info;
		try {
			Channel channelS = SerSystem.getChannelGroup().getChannel(chatInfo.getSendTo());
			Channel channel  = SerSystem.getChannelGroup().getChannel(chatInfo.getReceiveFrom());
			
		    if(channel!=null&&channel.isActive())
				if(channelS!=null&&channelS.isActive()){
					chatInfo.setValues(chatInfo.getOnickname()+":" +chatInfo.getNickname()+":" +
										    chatInfo.getMessage());
					channelS.writeAndFlush(chatInfo);
					logger.debug("another user is  online "+chatInfo.getValues());
					chatInfo.setSendTo("ser");
					chatInfo.setValues("1");
					channel.writeAndFlush(chatInfo);		
				}
				else {
							chatInfo.setValues("$"+ chatInfo.getReceiveFrom()+","+
											   chatInfo.getNickname()   +","+
											   chatInfo.getMessage()    +"$");						
				            SerSystem.getLocalDbService().AddMsgCache(chatInfo);
				            logger.debug("another user is't online  "+chatInfo.getValues());
				            chatInfo.setSendTo("ser");
				            chatInfo.setValues("0");
							channel.writeAndFlush(chatInfo);		
				}
			
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		
	}

}
