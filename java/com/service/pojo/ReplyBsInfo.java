package com.service.pojo;

public class ReplyBsInfo extends CommonInfo {
	private String bstypeS;
    private String body;
    private String bsid;
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

	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getBstypeS() {
		return bstypeS;
	}


	public void setBstypeS(String bstypeS) {
		this.bstypeS = bstypeS;
	}


	public String getBsid() {
		return bsid;
	}


	public void setBsid(String bsid) {
		this.bsid = bsid;
	}

	
}
