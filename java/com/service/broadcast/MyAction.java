package com.service.broadcast;

public class MyAction {
	
	public int value1 ;
	public int value2 ;
	private String filter;
	
	public MyAction(String filter)
	{
		this.filter=filter;
	}
	
	public MyAction(MyAction action)
	{
		this.filter=action.filter;
	}

	public String getFilter() {
		return filter;
	}

}
