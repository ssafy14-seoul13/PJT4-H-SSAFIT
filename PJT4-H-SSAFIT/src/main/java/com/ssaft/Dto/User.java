package com.ssaft.Dto;

public class User {
	
	private int userID;
	private String userEmail;
	private String userPassword;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userID, String userEmail, String userPassword) {
		this.userID = userID;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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
		return "User [userID=" + userID + ", userEmail=" + userEmail + ", userPassword=" + userPassword + "]";
	}
	
	


}
