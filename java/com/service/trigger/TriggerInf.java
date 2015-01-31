package com.service.trigger;

import com.service.scheduler.MyTask;

public interface TriggerInf {
	public static int LOW_ACCURACY = 2000;
	public static int NORMAL_ACCURACY = 1000;
	public static int HIGH_ACCURACY = 500;
	
	public boolean regTrigger(String tName,final ConditionInf when,final MyTask command,int accuracy);
	public boolean regTrigger(String tName,final ConditionInf when,final MyTask command);
	public boolean unregTrigger(String tName);
	
	public boolean cleanAll();
}
