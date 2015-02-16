package com.service.cache;

import org.apache.log4j.Logger;

import com.service.dbservice.LocalDbService;
import com.service.system.SerSystem;
import com.service.system.SysValues;

public class BsCountImp implements BsCounterInf{
	
	private static Logger logger  = Logger.getLogger(BsCountImp.class);
	
	@Override
	public synchronized void initCount() {
		// TODO Auto-generated method stub
		LocalDbService service = SerSystem.getLocalDbService();
		for(int i=1;i<=SysValues.BSCOUNT;i++)
			integers[i]= service.Count(SysValues.BSSUFF+i);
	}

	@Override
	public Integer getCount(int index) {
		return integers[index];
	}

	@Override
	public Integer addCount(int index) {
		// TODO Auto-generated method stub
		return ++integers[index];
	}

	@Override
	public Integer cutCount(int index) {
		// TODO Auto-generated method stub
		return --integers[index];
	}

	@Override
	public Integer getCount(String bstype) {
		int i = getIndex(bstype);
		if(i==0)
			return -1;
		else 
		    return getCount(i);
	}

	@Override
	public Integer addCount(String bstype) {
		int i = getIndex(bstype);
		if(i==0)
			return -1;
		else 
		    return addCount(i);
	}

	@Override
	public Integer cutCount(String bstype) {
		int i = getIndex(bstype);
		if(i==0)
			return -1;
		else 
		    return cutCount(i);
	}
	
	private int getIndex(String s)
	{
		int tmp=0;
		if(s.length()>3)
			tmp=0;
		else if(s.charAt(0)!='b')
			tmp=0;
		else 
		{
			try {
				tmp = Integer.valueOf(s.replace('b', '0'));
			} catch (Exception e) {
				tmp=0;
				e.printStackTrace();
				logger.error(e);
			}
		}
		return tmp;
	}

	@Override
	public String toString() {
		String tmp = ""+integers[1];
		for(int i=2;i<=SysValues.BSCOUNT;i++)
		        tmp+=":"+integers[i];
		return tmp;
	}
	
	
	
}
