package com.service.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.service.scheduler.MyTask;
import com.service.system.SysValues;

public class MyThreadPool {
	private ExecutorService  pool = null;
	
	public MyThreadPool()
	{
		pool = Executors.newCachedThreadPool();
	}
	
	public boolean AddTask(MyTask task)
	{
		try {
			pool.execute(task);			
		} catch (Exception e) {
			return false;
		}	
		return true;
	}
	
	public boolean shutdown()
	{
		try {
			pool.shutdown();
			return pool.awaitTermination(SysValues.threadStopwaitTime, TimeUnit.SECONDS);
		} catch (Exception e) {
	        return true;
		}	
	}
}
