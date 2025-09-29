package com.ssafit.serviceImpl;

import com.ssafit.Dao.UserDao;
import com.ssafit.DaoImpl.UserDaoImpl;
import com.ssafit.Dto.User;
import com.ssafit.service.*;

public class UserServiceImpl implements UserService {

	private static UserService userService = new UserServiceImpl();

	private UserDao userDao = UserDaoImpl.getInstance();

	private UserServiceImpl() {
	}

	public static UserService getInstance() {
		return userService;
	}

	// 회원가입
	@Override
	public void userSignUp(User user) {
		userDao.signUp(user);
	}

	// 로그인
	@Override
	public User userLogIn(User user) {
		return userDao.logIn(user);
	}

	// 로그아웃
	@Override
	public void userLogOut(int userId) {
		userDao.logOut(userId);
	}

	// 탈퇴
	@Override
	public void userDelete(int userId) {
		userDao.delUser(userId);
	}

}
