package com.board.user;

import java.sql.*;

public class UserDAO {
	public Connection getConnection() {
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

	public void addUser(User user) throws SQLException {
		String sql="insert into USERS values(?,?,?,?)";
		PreparedStatement pstmt=getConnection().prepareStatement(sql);
		pstmt.setString(1, user.getUserId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getEmail());
		pstmt.executeUpdate();
	}

	public User findByUserId(String userId) throws SQLException {
		String sql="select * from USERS where userId=?";
		PreparedStatement pstmt=getConnection().prepareStatement(sql);
		pstmt.setString(1, userId);
		ResultSet rs=pstmt.executeQuery();
		if(!rs.next()) {
			return null;
		}
		return new User(rs.getString("userId"), rs.getString("password"), 
				rs.getString("name"), rs.getString("email"));
		
	}
}