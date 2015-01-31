package com.service.netty;

import java.util.HashMap;
import java.util.Map;

import io.netty.channel.Channel;


public interface ChannelGroupIntf {
    Map<String, Channel> map = new HashMap<String, Channel>();
    
	public void add(String id,Channel ch);
	public void remove(String id);	
	public Channel getChannel(String id);
	public void close(String id);
	public void closeAll();
	public int size();
	public boolean isEmpty();
	public boolean isContainId(String id);
}
