package com.service.pojo;

public class ChatInfo extends CommonInfo {
    
	private String nickname;
	private String onickname;
	private String message;
	
	public ChatInfo(String cmdKind, String receiveFrom, String sendTo) {
		super(cmdKind, receiveFrom, sendTo);
		// TODO Auto-generated constructor stub
	}
	
	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getOnickname() {
		return onickname;
	}


	public void setOnickname(String onickname) {
		this.onickname = onickname;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
  
}
