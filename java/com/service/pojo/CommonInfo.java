package com.service.pojo;

public class CommonInfo implements UserInfo{
	    private String cmdKind;
	    private String receiveFrom;
	    private String sendTo;
	    private String values;
	    
	    public CommonInfo(String cmdKind, String receiveFrom, String sendTo){
	    	this.cmdKind=cmdKind;
	    	this.receiveFrom=receiveFrom;
	    	this.sendTo=sendTo;
	    }
	    
		public String getCmdKind() {
			return cmdKind;
		}
		public void setCmdKind(String cmdKind) {
			this.cmdKind = cmdKind;
		}
		public String getReceiveFrom() {
			return receiveFrom;
		}
		public void setReceiveFrom(String receiveFrom) {
			this.receiveFrom = receiveFrom;
		}
		public String getSendTo() {
			return sendTo;
		}
		public void setSendTo(String sendTo) {
			this.sendTo = sendTo;
		}

		public String getValues() {
			return values;
		}

		public void setValues(String values) {
			this.values = values;
		}
		
	    
}
