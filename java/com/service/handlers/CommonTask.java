package com.service.handlers;

import com.service.pojo.UserInfo;
import com.service.scheduler.MyTask;

public abstract class CommonTask extends MyTask {
	protected UserInfo info;
	public CommonTask(UserInfo info)
	{
		this.info=info;
	}
	
}
