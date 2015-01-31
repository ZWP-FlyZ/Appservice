package com.service.trigger;

import com.service.scheduler.MyScheduler;
import com.service.scheduler.MyTask;

public class MyTrigger implements TriggerInf{
		
		private MyScheduler scheduler;
		
		public MyTrigger()
		{
			scheduler = new MyScheduler();
		}
		@Override
		public boolean regTrigger(String tName,final ConditionInf when,final MyTask command,int accuracy)
		{
			if(accuracy<HIGH_ACCURACY)
				accuracy=HIGH_ACCURACY;
			else if(accuracy>LOW_ACCURACY)
				accuracy=LOW_ACCURACY;
			
			MyTask task = new MyTask() {				
				@Override
				public void run() {
				  if(when.when())
					  command.run();
				}
			};			
			return scheduler.regScheduler(tName, task, 0, accuracy);
		}
		@Override
		public boolean regTrigger(String tName,final ConditionInf when,final MyTask command)
		{
			return regTrigger(tName,when,command,NORMAL_ACCURACY);
		}
		@Override
		public boolean unregTrigger(String tName)
		{
			return scheduler.unRegScheduler(tName);
		}
		@Override
		public boolean cleanAll() {
			scheduler.clearAll();
			return true;
		}
		 
}
