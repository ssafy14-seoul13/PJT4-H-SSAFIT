package com.ssafit.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.ssafit.Dao.UserDao;
import com.ssafit.Dto.User;
import com.ssafy.board.util.DBUtil;

public class UserDaoImpl implements UserDao {

	// 싱글턴으로 구현
	public static UserDao userDao = new UserDaoImpl();

	private DBUtil util = DBUtil.getInstance();

	public static UserDao getInstance() {
		return userDao;
	}

	// 회원가입
	//사용자 정보를 DB의 user 테이블에 삽입
	@Override
	public void signUp(User user) {
		// jdbc 객체 선언 및 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// DBUtil에서 Connection 획득
			conn = util.getConnection();
			String sql = "INSERT INTO user (user_name, user_email, user_password) VALUES (?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);

			// 쿼리 파라미터 설정
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserEmail());
			pstmt.setString(3, user.getUserPassword());

			int result = pstmt.executeUpdate(); // 쿼리 실행(삽입)

			if (result > 0) {
				System.out.println("회원가입 완료: " + user.getUserName());
			} else {
				System.out.println("회원가입 실패");
			}

		} catch (SQLException e) {
			System.out.println("DB 오류: 회원가입 중 문제가 발생했습니다.");
			e.printStackTrace();
		} finally {
			// 자원 반납
			util.close(pstmt, conn);
		}
	}

	// 로그인
	// 입력받은 이메일과 비밀번호가 일치하는 사용자 정보를 DB에서 조회
	@Override
	public User logIn(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User loggedInUser = null; // 로그인 성공 시 반환할 User 객체

		try {
			conn = util.getConnection();
			String sql = "SELECT id, user_name, user_email, user_password FROM user WHERE user_email = ? AND user_password = ?";
			pstmt = conn.prepareStatement(sql);

			// 쿼리 파라미터에 값 바인딩
			pstmt.setString(1, user.getUserEmail());
			pstmt.setString(2, user.getUserPassword());

			rs = pstmt.executeQuery(); // 쿼리 실행(조회)

			if (rs.next()) {
				// 조회된 결과가 있으면 로그인 성공
				loggedInUser = new User();
				loggedInUser.setUserId(rs.getInt("id"));
				loggedInUser.setUserName(rs.getString("user_name"));
				loggedInUser.setUserEmail(rs.getString("user_email"));
				loggedInUser.setUserPassword(rs.getString("user_password"));

				System.out.println(loggedInUser.getUserName() + " 님 반갑습니다!");
				return loggedInUser;
			} else {
				// 결과가 없으면 로그인 실패
				System.out.println("이메일 또는 비밀번호가 잘못되었습니다.");
				return null;
			}
		} catch (SQLException e) {
			System.out.println("DB오류: 로그인 중 문제가 발생했습니다.");
			e.printStackTrace();
			return null; // 오류 발생 시 null 반환
		} finally {
			// 자원 반납
			util.close(rs, pstmt, conn);
		}

	}

	@Override
	//controller/service 레이어에서 세션을 무효화 시키면서 처리하므로 로그아웃은 사용자 이름만 출력 
	public void logOut(int userId) {
		System.out.println("사용자 ID" + userId + " 님 안녕히가세요!");

	}

	@Override
	//userId를 가진 사용자의 정보를 DB의 user 테이블에서 찾아서 삭제
	public void delUser(int userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = util.getConnection();
			String sql = "DELETE FROM user WHERE id = ?";
			pstmt = conn.prepareStatement(sql);

			// 쿼리 파라미터 설정
			pstmt.setInt(1, userId);

			int result = pstmt.executeUpdate();// 쿼리 실행(삭제)

			if (result > 0) {
				System.out.println("회원 탈퇴가 완료되었습니다. (ID: " + userId + ")");
			} else {
				System.out.println("회원 탈퇴 실패 : 해당 ID의 사용자가 없습니다.");
			}
		} catch (SQLException e) {
			System.out.println("DB 오류: 회원 탈퇴 중 문제가 발생했습니다.");
			e.printStackTrace();
		} finally {
			// 자원 반납
			util.close(pstmt, conn);
		}

	}
}
