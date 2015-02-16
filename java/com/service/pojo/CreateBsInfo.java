package com.service.pojo;


public class CreateBsInfo extends CommonInfo {
	private String bstype;
	private String theme;
	private String body;
	private String nickName;
	private Integer bsId;
	
	public CreateBsInfo(String cmdKind, String receiveFrom, String sendTo) {
		super(cmdKind, receiveFrom, sendTo);
		// TODO Auto-generated constructor stub
	}
	
	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
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

	public String getBstype() {
		return bstype;
	}

	public void setBstype(String bstype) {
		this.bstype = bstype;
	}

	public Integer getBsId() {
		return bsId;
	}

	public void setBsId(Integer bsId) {
		this.bsId = bsId;
	}


}
