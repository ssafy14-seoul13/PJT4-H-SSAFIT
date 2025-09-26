package com.ssafit.DaoImpl;

public class UserDaoImpl implements UserDao {

	public static UserDao userDao = new UserDaoImpl();

	// 로그인 상태
	private Map<Integer, Boolean> logedInMap = new HashMap<>();

	private Map<Integer, User> userMap = new HashMap<>();

	private static AtomicInteger userId = new AtomicInteger();

	private UserDaoImpl() {
		getInit();
	}

	// 더미 데이터
	private void getInit() {
		userMap.put(1, new User("abc@gmail.com", "1234", "apple"));
		userMap.put(2, new User("def@gmail.com", "5678", "dog"));
		userMap.put(3, new User("ghi@gmail.com", "9012", "graph"));
	}

	private static int updateId() {
		return userId.incrementAndGet();
	}

	public static UserDao getInstance() {
		return userDao;
	}

	// 회원가입
	@Override
	public void signUp(User user) {

		user.setUserId(updateId());
		userMap.put(user.getUserId(), user);
	}
	
	//로그인
		@Override
		public User signIn(User user) {
			
			String inputEmail = user.getUserEmail();
			String inputPassword = user.getUserPassword();
			
			for (Map.Entry<Integer, User> entry : userMap.entrySet()) {
				User u = entry.getValue();
				
				if (u.getUserEmail().equals(inputEmail) && u.getUserPassword().equals(inputPassword)) {
					
					signedInMap.put(entry.getKey(),true);
					System.out.println("[로그인 성공] : " + u.getUserNickname());
					return u;
				} 
			}
					System.out.println("[로그인 실패] : 이메일 또는 비밀번호가 잘못되었습니다.");
					return null;
				
		}
}
