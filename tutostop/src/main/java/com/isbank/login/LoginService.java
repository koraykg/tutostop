package com.isbank.login;

public class LoginService {
	
	public String retrieveUserEmail(String userName) {
		LoginGetUserEmail dao = new LoginGetUserEmail();
		String UserInfo = dao.GetUserEmail(userName);
		return UserInfo;
	}

}
