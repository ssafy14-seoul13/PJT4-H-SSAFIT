package com.ssafit.controller;

import java.io.IOException;

import com.ssafit.Dto.User;
import com.ssafit.service.UserService;
import com.ssafit.serviceImpl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private UserService userService = UserServiceImpl.getInstance();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service(request, response);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String act = request.getParameter("action");
        
        if (act == null) {
            act = "login";
        }
        
        switch (act) {
            case "signupform": // 회원가입 폼
                doSignUpForm(request, response);
                break;
            case "signup": // 회원가입
                doSignUp(request, response);
                break;
            case "login": // 로그인 폼 표시 또는 로그인 처리
                doLogin(request, response);
                break;
            case "logout": // 로그아웃
                doLogOut(request, response);
                break;
            case "remove": // 탈퇴
                doRemove(request, response);
                break;
            case "page": // 사용자 페이지
                doUserPage(request, response);
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

        // 생성자 순서 수정: userName, userEmail, userPassword
        User user = new User();
        user.setUserEmail(userEmail);
        user.setUserPassword(userPassword);
        user.setUserName(userName);
        
        userService.userSignUp(user);

        response.sendRedirect(request.getContextPath() + "/main");
    }
    
    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        // POST 요청인 경우에만 로그인 처리
        if ("POST".equals(request.getMethod())) {
            String userEmail = request.getParameter("userEmail");
            String userPassword = request.getParameter("userPassword");
            
            // 로그인 시에는 userName은 빈 문자열로 설정
            User user = new User("", userEmail, userPassword);
            User logInUser = userService.userLogIn(user);
            
            if (logInUser != null) {
                request.getSession().setAttribute("LogInUser", logInUser);
                response.sendRedirect(request.getContextPath() + "/user?action=page&userId=" + logInUser.getUserId());
            } else {
                request.setAttribute("error", "이메일 또는 비밀번호가 잘못되었습니다.");
                request.getRequestDispatcher("/user/userLogIn.jsp").forward(request, response);
            }
        } else {
            // GET 요청인 경우 로그인 폼 표시
            request.getRequestDispatcher("/user/userLogIn.jsp").forward(request, response);
        }
    }
    
    private void doLogOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        int userId = Integer.parseInt(request.getParameter("userId"));
        
        userService.userLogOut(userId);
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/main");
        
    }

    private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int userId = Integer.parseInt(request.getParameter("userId"));
        
        userService.userDelete(userId);
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/main");
        
    }
    
    private void doUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int userId = Integer.parseInt(request.getParameter("userId"));
        
        User logInUser = (User) request.getSession().getAttribute("LogInUser");
        
        if (logInUser != null && logInUser.getUserId() == userId) {
            request.setAttribute("user", logInUser);
            request.getRequestDispatcher("/user/userPage.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/user?action=login");
        }
        
    }
}