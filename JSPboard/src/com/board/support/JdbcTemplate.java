package com.board.support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.board.user.User;
import com.board.user.UserDAO;

public class JdbcTemplate {
	public void executeUpdate(String sql, PrepareStatementSetter pss) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
		conn=ConnectionManager.getConnection();
		pstmt=conn.prepareStatement(sql);
		pss.setParameters(pstmt);
		pstmt.executeUpdate();
		}finally {
			if(conn!=null)
				conn.close();
			if(pstmt!=null)
				pstmt.close();
		}
	}
	public Object executeQuery(String sql,PrepareStatementSetter pss, RowMapper rm) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
		conn=ConnectionManager.getConnection();
		pstmt=conn.prepareStatement(sql);
		pss.setParameters(pstmt);
		rs=pstmt.executeQuery();
		if(!rs.next()) {
			return null;
		}
		return rm.mapRow(rs);
		}finally {
			if(conn!=null)
				conn.close();
			if(pstmt!=null)
				pstmt.close();
			if(rs!=null)
				rs.close();
		}
	}
}
