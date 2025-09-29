package com.ssafit.DaoImpl;

import java.util.*;

import com.ssafit.Dao.UserDao;
import com.ssafit.Dto.User;

public class UserDaoImpl implements UserDao {

	public static UserDao userDao = new UserDaoImpl();

	// 로그인 상태
	private Map<Integer, Boolean> logedInMap = new HashMap<>();
	
	// 유저 저장 맵 
	private Map<Integer, User> userMap = new HashMap<>();

	private UserDaoImpl() {
		putDummyUser();
	}

	// 더미 데이터
	private void putDummyUser() {
		userMap.put(1, new User("김싸피", "abc@gmail.com", "1234"));
		userMap.put(2, new User("이싸피", "def@gmail.com", "5678"));
		userMap.put(3, new User("박싸피", "ghi@gmail.com", "9012"));
	}

	public static UserDao getInstance() {
		return userDao;
	}
	
	private int nextUserId = 4;
	
	// 회원가입
	@Override
	public void signUp(User user) {
		user.setUserId(nextUserId++);
		userMap.put(user.getUserId(), user);
		System.out.println("회원가입 완료: " + user.getUserName());
	}
	
	//로그인
		@Override
		public User logIn(User user) {
			
			String inputEmail = user.getUserEmail();
			String inputPassword = user.getUserPassword();
			
			for (Map.Entry<Integer, User> entry : userMap.entrySet()) {
				User u = entry.getValue();
				
				if (u.getUserEmail().equals(inputEmail) && u.getUserPassword().equals(inputPassword)) {
					
					logedInMap.put(entry.getKey(),true);
					System.out.println(u.getUserName() + " 님 반갑습니다!");
					return u;
				} 
			}
					System.out.println("이메일 또는 비밀번호가 잘못되었습니다.");
					return null;
				
		}

		@Override
		public void logOut(int userId) {
			if (logedInMap.containsKey(userId)) {
				logedInMap.remove(userId);
				System.out.println(userMap.get(userId).getUserName()+" 님 안녕히가세요!");
			} else {
				System.out.println("로그아웃 실패");
			}
			
		}
		
		@Override
		public void delUser(int userId) {
			
			logedInMap.remove(userId);
			userMap.remove(userId);
			System.out.println("회원 탈퇴가 완료되었습니다");
			
		}
}
