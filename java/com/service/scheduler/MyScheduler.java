package com.service.scheduler;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MyScheduler implements SchdulerInf
{
	private 	 int 								threadC = 10;
	private 	 ScheduledExecutorService 			service ;
	private		 Map<String, ScheduledFuture<?>>	futureMap;
	
	public MyScheduler()
	{
		service 	=  Executors.newScheduledThreadPool(threadC);
		futureMap   =  new HashMap<String, ScheduledFuture<?>>();
	}
	@Override
	public boolean regScheduler(String sName,MyTask command,long initialDelay,long period,TimeUnit unit){
		if(futureMap.containsKey(sName))
			return false;
		ScheduledFuture<?> f = service.scheduleAtFixedRate(command, initialDelay, period, unit);
		futureMap.put(sName, f);		
		return !f.isCancelled();
		}
	@Override
	public boolean regScheduler(String sName,MyTask command,long initialDelay,long period)
	{
		return regScheduler(sName,command,initialDelay,period,TimeUnit.MILLISECONDS);
	}
	@Override
	public boolean regScheduler(String sName,MyTask command,long initialDelay)
	{
		if(futureMap.containsKey(sName))
			return false;
		ScheduledFuture<?> f = service.schedule(command, initialDelay,TimeUnit.MILLISECONDS);
		futureMap.put(sName, f);		
		return !f.isCancelled();	
	}
	@Override
	public boolean regScheduler(String sName,MyTask command,String time)
	{
		Date date = new Date(System.currentTimeMillis());  
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		try {
			date = dFormat.parse(time);	
		} catch (Exception e) {
			return false;
		}
		return regScheduler(sName,command,date.getTime()-System.currentTimeMillis());
	}
	@Override
	public boolean unRegScheduler(String sName){
		if(futureMap.containsKey(sName))
		{
			 ScheduledFuture<?> f = futureMap.get(sName);
			 f.cancel(false);
			futureMap.remove(sName);
			//return f.isCancelled();
			return true;
		}
		return false;
		}

	@Override
	public boolean clearAll()  {
		for(ScheduledFuture<?> f: futureMap.values())
			f.cancel(false);
		futureMap.clear();
		return true;
	}
}
