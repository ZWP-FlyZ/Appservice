package com.service.cache;

import com.service.system.SysValues;

public interface BsCounterInf {
	Integer[] integers = new Integer[SysValues.BSCOUNT+1];
	public void	   initCount();
	public Integer getCount(int index);
	public Integer addCount(int index);
	public Integer cutCount(int index);	
	public Integer getCount(String bstype);
	public Integer addCount(String bstype);
	public Integer cutCount(String bstype);	
}
