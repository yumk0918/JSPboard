package com.board.user;

import java.sql.*;

import com.board.support.JdbcTemplate;
import com.board.support.PrepareStatementSetter;
import com.board.support.RowMapper;

public class UserDAO {
	public void addUser(User user) throws SQLException {
		PrepareStatementSetter pss= new PrepareStatementSetter() {
			@Override
			public void setParameters(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, user.getUserId());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getName());
				pstmt.setString(4, user.getEmail());
			}
		};
		JdbcTemplate template=new JdbcTemplate();
		String sql="insert into USERS values(?,?,?,?)";
		template.executeUpdate(sql,pss);
	}

	public User findByUserId(String userId) throws SQLException {
		PrepareStatementSetter pss= new PrepareStatementSetter() {
			@Override
			public void setParameters(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, userId);
			}
		};
		RowMapper rm=new RowMapper() {
			@Override
			public User mapRow(ResultSet rs) throws SQLException {
				return new User(rs.getString("userId"), rs.getString("password"), 
						rs.getString("name"), rs.getString("email"));
			}
		};
		JdbcTemplate  template=new JdbcTemplate();
		String sql ="select * from USERS where userId=?";
		return (User)template.executeQuery(sql,pss,rm);
	}

	public void removeUser(String userId) throws SQLException {
		String sql="delete from USERS where userId=?";
		PrepareStatementSetter pss= new PrepareStatementSetter() {
			@Override
			public void setParameters(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, userId);
			}
			
		};
		JdbcTemplate template=new JdbcTemplate();
		template.executeUpdate(sql,pss);
	}

	public void updateUser(User user) throws SQLException {
		String sql="update USERS set password=?, name=?, email=? where userId=?";
		PrepareStatementSetter pss= new PrepareStatementSetter() {
			@Override
			public void setParameters(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, user.getPassword());
				pstmt.setString(2, user.getName());
				pstmt.setString(3, user.getEmail());
				pstmt.setString(4, user.getUserId());
			}
		};
		JdbcTemplate template=new JdbcTemplate();
		template.executeUpdate(sql,pss);
	}
}