package com.isbank.login;

public class UserInfoBean {
	private String uName;
	private String lastName;
	private String userName;
	private String eMail;
	
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "UserInfoBean [uName=" + uName + ", lastName=" + lastName + ", userName=" + userName + ", eMail=" + eMail
				+ "]";
	}

}
