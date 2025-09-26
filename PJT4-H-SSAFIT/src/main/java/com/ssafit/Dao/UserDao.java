package com.ssafit.Dao;

public interface UserDao {

	
	//회원 가입
	public abstract void signUp(User user);
	
	//로그인
	public abstract void login(User user);
	
	//로그아웃
	public abstract void logOut(int userId);
	
	//탈퇴
	public abstract void delUser(int userId);
}
