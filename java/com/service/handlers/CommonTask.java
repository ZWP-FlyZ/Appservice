package com.service.handlers;

import org.apache.log4j.Logger;

import com.service.pojo.UserInfo;
import com.service.scheduler.MyTask;

public abstract class CommonTask extends MyTask {
	protected UserInfo info;
	protected Logger logger;
	
	public CommonTask(UserInfo info)
	{
		this.info=info;
	}
	
}
