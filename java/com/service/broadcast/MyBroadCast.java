package com.service.broadcast;


public class MyBroadCast implements BroadCastInf{
   private static int rc=0; 
	@Override
	public boolean regBroadCastRec(MyBroadCastReceiver receiver, MyAction action) {
		receiver.setAction(action);
		receiver.setFilt(action.getFilter());
		receiver.setId(rc++);
		receivers.add(receiver);
		return false;
	}

	@Override
	public boolean unregBroadCastRec(MyBroadCastReceiver receiver) {
		int i=0;
		for(i=0;i<receivers.size();i++)
			if(receivers.get(i)==receiver)
				break;		
		if(i<receivers.size())
			 receivers.remove(i);
		return true;
	}

	@Override
	public boolean sendBroadCast(MyAction action) {
		for(int i=0;i<receivers.size();i++)
			receivers.get(i).onReceive(action);	
		return true;
	}

	@Override
	public boolean clearAll() {
	    receivers.clear();
		return true;
	}
		
}
