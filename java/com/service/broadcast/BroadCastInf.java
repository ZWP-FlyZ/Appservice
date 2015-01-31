package com.service.broadcast;

import java.util.ArrayList;


public interface BroadCastInf {
	ArrayList<MyBroadCastReceiver> receivers= new ArrayList<MyBroadCastReceiver>();
	public boolean regBroadCastRec(MyBroadCastReceiver receiver,MyAction action);
	public boolean unregBroadCastRec(MyBroadCastReceiver receiver);
	public boolean sendBroadCast(MyAction action);
	public boolean clearAll();
}
