package com.service.broadcast;

public abstract class MyBroadCastReceiver implements Comparable<MyBroadCastReceiver>{
	private MyAction action;
	@SuppressWarnings("unused")
	private String  filt;
	private int id;
	
	public MyAction getAction() {
		return action;
	}

	public void setAction(MyAction action) {
		this.action = action;
	}

	public void setFilt(String filt) {
		this.filt = filt;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int compareTo(MyBroadCastReceiver o) {	
		return this.id - o.id;
	}

	public abstract void onReceive(MyAction action);
}
