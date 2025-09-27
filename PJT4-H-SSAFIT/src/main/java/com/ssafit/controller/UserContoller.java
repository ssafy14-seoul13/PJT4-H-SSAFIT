package com.ssafit.controller;

import java.io.IOException;

import com.ssafit.service.UserService;
import com.ssaft.Dto.User;
import com.ssaft.serviceImpl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserContoller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String act = request.getParameter("act");
		
		switch (act) {
		case "signupform": // 회원가입
			doSignUpForm(request,response);
			break;
		case "signup": // 회원가입
			doSignUp(request,response);
			break;
		case "login": // 로그인
			doLogIn(request,response);
			break;
		case "logout": // 로그아웃
			doLogOut(request,response);
			break;
		case "remove": // 탈퇴
			doRemove(request,response);
			break;
		}
	}
		
	private void doSignUpForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/user/userSignUp.jsp").forward(request, response);
	}
	
	private void doSignUp(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		String userName = request.getParameter("userName");

		User user = new User (userEmail, userPassword, userName);
		
		userService.userSignUp(user);


		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}
	
	private void doLogIn(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		
		User user = new User (userEmail, userPassword, userName);
		
		User LogInUser = userService.userLogIn(user);
		
		if (LogInUser != null) {
			request.getSession().setAttribute("LogInUser", LogInUser);
			response.sendRedirect("user?act=page&userId=" + LogInUser.getUserId());
		} else {
			response.sendRedirect("user?act=login");
		}

		
	}
	private void doLogOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		userService.userLogOut(userId);
		request.getSession().invalidate();
		response.sendRedirect("user?act=login");
		
	}

	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int userId = Integer.parseInt(request.getParameter("userId"));
		
		userService.userDelete(userId);
		response.sendRedirect("user?act=login");

		
	}
}
