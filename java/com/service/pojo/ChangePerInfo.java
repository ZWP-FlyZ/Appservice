package com.service.pojo;

public class ChangePerInfo extends CommonInfo{
	
	private String nickname;
	private String sex;
	private String school;
	private String major;
	private String mtimes;
	private String year;
	
	private String sign;
	private String briday;
	private String contact;
	private String addrbuid;
	private String addrrooom;
	private String selfMark;
	private String selfTimes;
	private String otherMark;
	private String otherTimes;
	
	
	public ChangePerInfo(String cmdKind, String receiveFrom, String sendTo) {
		super(cmdKind, receiveFrom, sendTo);
		// TODO Auto-generated constructor stub
	}
	
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMtimes() {
		return mtimes;
	}

	public void setMtimes(String mtimes) {
		this.mtimes = mtimes;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getBriday() {
		return briday;
	}

	public void setBriday(String briday) {
		this.briday = briday;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getSelfMark() {
		return selfMark;
	}

	public void setSelfMark(String selfMark) {
		this.selfMark = selfMark;
	}

	public String getSelfTimes() {
		return selfTimes;
	}

	public void setSelfTimes(String selfTimes) {
		this.selfTimes = selfTimes;
	}

	public String getOtherMark() {
		return otherMark;
	}

	public void setOtherMark(String otherMark) {
		this.otherMark = otherMark;
	}

	public String getOtherTimes() {
		return otherTimes;
	}

	public void setOtherTimes(String otherTimes) {
		this.otherTimes = otherTimes;
	}


	public String getAddrbuid() {
		return addrbuid;
	}


	public void setAddrbuid(String addrbuid) {
		this.addrbuid = addrbuid;
	}


	public String getAddrrooom() {
		return addrrooom;
	}


	public void setAddrrooom(String addrrooom) {
		this.addrrooom = addrrooom;
	}



}
