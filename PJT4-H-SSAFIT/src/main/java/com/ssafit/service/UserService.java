package com.ssafit.service;

import com.ssaft.Dto.User;

public interface UserService {

	// 회원가입
	public abstract void userSignUp(User user);

	// 로그인
	public abstract User userLogIn(User user);

	// 로그아웃
	public abstract void userLogOut(int userCount);

	// 회원탈퇴
	public abstract void userDelete(int userCount);

}
