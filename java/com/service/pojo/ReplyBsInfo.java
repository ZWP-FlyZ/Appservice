package com.service.pojo;

public class ReplyBsInfo extends CommonInfo {
    private String body;
    private String auid;
    private String nickName;
 
    public ReplyBsInfo(String cmdKind, String receiveFrom, String sendTo) {
		super(cmdKind, receiveFrom, sendTo);
		// TODO Auto-generated constructor stub
	}

    
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAuid() {
		return auid;
	}

	public void setAuid(String auid) {
		this.auid = auid;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	
}
