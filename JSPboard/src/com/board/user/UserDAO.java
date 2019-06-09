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
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
		conn=getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, user.getUserId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getEmail());
		pstmt.executeUpdate();
		}finally {
			if(conn!=null)
				conn.close();
			if(pstmt!=null)
				pstmt.close();
		}
	}

	public User findByUserId(String userId) throws SQLException {
		String sql="select * from USERS where userId=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
		conn=getConnection();
		pstmt=getConnection().prepareStatement(sql);
		pstmt.setString(1, userId);
		rs=pstmt.executeQuery();
		if(!rs.next()) {
			return null;
		}
		return new User(rs.getString("userId"), rs.getString("password"), 
				rs.getString("name"), rs.getString("email"));
		}finally {
			if(conn!=null)
				conn.close();
			if(pstmt!=null)
				pstmt.close();
			if(rs!=null)
				rs.close();
		}
	}

	public void removeUser(String userId) throws SQLException {
		String sql="delete from USERS where userId=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
		conn=getConnection();
		pstmt=getConnection().prepareStatement(sql);
		pstmt.setString(1, userId);
		pstmt.executeUpdate();
		}finally {
			if(conn!=null)
				conn.close();
			if(pstmt!=null)
				pstmt.close();
		}
	}

	public void updateUser(User user) throws SQLException {
		String sql="update USERS set password=?, name=?, email=? where userId=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
		conn=getConnection();
		pstmt=getConnection().prepareStatement(sql);
		pstmt.setString(1, user.getPassword());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getEmail());
		pstmt.setString(4, user.getUserId());
		pstmt.executeUpdate();
		}finally {
			if(conn!=null)
				conn.close();
			if(pstmt!=null)
				pstmt.close();
		}
	}
}