package com.ssafy.board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	// DB와 연결하기위해 필요한 DB의 URL
	private final String url = "jdbc:mysql://localhost:3306/ssafit_db?serverTimezone=UTC";
	// DB의 USER 이름
	private final String username = "ssafy";
	// 위 USER의 PASSWORD
	private final String password = "ssafy";
	// Mysql 드라이버 클래스 이름
	private final String driverName = "com.mysql.cj.jdbc.Driver";

    private static DBUtil instance = new DBUtil();

    private DBUtil() {
        // JDBC 드라이버를 로딩한다. 드라이버 로딩은 객체 생성 시 한번만 진행하도록 하자.
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DBUtil getInstance() {
        return instance;
    }
  
    public Connection getConnection() throws SQLException{
    	return DriverManager.getConnection(url, username, password);
    }

    public void close(AutoCloseable... closeables) {
        for (AutoCloseable c : closeables) {
            if (c != null) {
                try {
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}