package com.ssafit.Dto;

public class User {
	
	private int userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String userEmail, String userPassword) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userID) {
		this.userId = userID;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User [userID=" + userId + ", userEmail=" + userEmail + ", userPassword=" + userPassword + "]";
	}
	
	


}
