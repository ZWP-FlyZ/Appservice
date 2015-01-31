package com.service.scheduler;

import java.util.concurrent.TimeUnit;

public interface SchdulerInf {
	public 	boolean regScheduler(String sName,MyTask command,long initialDelay,long period,TimeUnit unit);
	public 	boolean regScheduler(String sName,MyTask command,long initialDelay,long period);
	public boolean regScheduler(String sName,MyTask command,long initialDelay);
	public boolean regScheduler(String sName,MyTask command,String time);
	public boolean unRegScheduler(String sName);
	public boolean clearAll();
	
}
