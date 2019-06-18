package com.board.support.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/study?useUnicode=true&characterEncoding=utf-8";
		String id = "yumk";
		String pw = "password";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
