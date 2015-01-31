package com.service.pojo;

public class RegInfo extends CommonInfo {

	private String password;
	private String sex;
	private String school;
	private String major;
	private String year;
	
	public RegInfo(String cmdKind, String receiveFrom, String sendTo) {
		super(cmdKind, receiveFrom, sendTo);
		// TODO Auto-generated constructor stub
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}		
}
