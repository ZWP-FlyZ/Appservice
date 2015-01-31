package com.service.netty;

import io.netty.channel.Channel;

public class MyChannelGroup implements ChannelGroupIntf{

	@Override
	public void add(String id, Channel ch) {
		   map.put(id, ch);
	}

	@Override
	public void remove(String id) {
	         map.remove(id);
	}
	
	@Override
	public Channel getChannel(String id) {
		return map.get(id);
	}

	@Override
	public void close(String id) {
		map.get(id).close();
		map.remove(id);
	}

	@Override
	public void closeAll() {
		for(Channel k:map.values())
			     k.close();
		map.clear();
	}

	@Override
	public int size() {	
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean isContainId(String id) {
		return map.containsKey(id);
	}


}
