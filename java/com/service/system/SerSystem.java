package com.service.system;

import org.springframework.beans.factory.annotation.Autowired;

import com.service.broadcast.MyBroadCast;
import com.service.cache.BsCountImp;
import com.service.dbservice.LocalDbService;
import com.service.dbservice.RemoteDbService;
import com.service.netty.MyChannelGroup;
import com.service.netty.NettyService;
import com.service.scheduler.MyScheduler;
import com.service.threadpool.MyThreadPool;
import com.service.trigger.MyTrigger;

public class SerSystem {
	
	private   	static MyScheduler 		scheduler;
	private 	static MyBroadCast		broadCast;
	private		static MyTrigger		trigger;
	private 	static NettyService		nettyService;
	private 	static LocalDbService	localDbService;
	private     static RemoteDbService  remoteDbService;
	private 	static MyChannelGroup 	channelGroup;
	private 	static MyThreadPool		threadPool;
	private 	static MyThreadPool		threadPoolChat;
	private     static BsCountImp    	bsCount;
	
	private SerSystem(){};
	
	public static MyScheduler getScheduler() {
		return scheduler;
	}


	 @Autowired
	public void setScheduler(MyScheduler scheduler) {
		SerSystem.scheduler = scheduler;
	}

	public static BsCountImp getBsCount() {
		return bsCount;
	}
	
	 @Autowired
	public  void setBsCount(BsCountImp bsCount) {
		SerSystem.bsCount = bsCount;
	}

	public static MyBroadCast getBroadCast() {
		return broadCast;
	}


	 @Autowired
	public  void setBroadCast(MyBroadCast broadCast) {
		SerSystem.broadCast = broadCast;
	}



	public static MyTrigger getTrigger() {
		return trigger;
	}


	 @Autowired
	public  void setTrigger(MyTrigger trigger) {
		SerSystem.trigger = trigger;
	}



	public static NettyService getNettyService() {
		return nettyService;
	}


	 @Autowired
	public  void setNettyService(NettyService nettyService) {
		SerSystem.nettyService = nettyService;
	}



	public static LocalDbService getLocalDbService() {
		return localDbService;
	}


	 @Autowired
	public  void setLocalDbService(LocalDbService localDbService) {
		SerSystem.localDbService = localDbService;
	}



	public static RemoteDbService getRemoteDbService() {
		return remoteDbService;
	}


	 @Autowired
	public  void setRemoteDbService(RemoteDbService remoteDbService) {
		SerSystem.remoteDbService = remoteDbService;
	}



	public static MyChannelGroup getChannelGroup() {
		return channelGroup;
	}


	 @Autowired
	public  void setChannelGroup(MyChannelGroup channelGroup) {
		SerSystem.channelGroup = channelGroup;
	}


	public static MyThreadPool getThreadPool() {
		return threadPool;
	}
	@Autowired
	public  void setThreadPool(MyThreadPool threadPool) {
		SerSystem.threadPool = threadPool;
	}

	public static MyThreadPool getThreadPoolChat() {
		return threadPoolChat;
	}
	@Autowired
	public  void setThreadPoolChat(MyThreadPool threadPoolChat) {
		SerSystem.threadPoolChat = threadPoolChat;
	}

}
