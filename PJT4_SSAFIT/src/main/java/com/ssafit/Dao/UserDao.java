package com.ssafit.Dao;

import com.ssafit.Dto.User;

public interface UserDao {

	// 회원 가입
	public abstract void signUp(User user);

	// 로그인
	public abstract User logIn(User user);

	// 로그아웃
	public abstract void logOut(int userId);

	// 탈퇴
	public abstract void delUser(int userId);
}
