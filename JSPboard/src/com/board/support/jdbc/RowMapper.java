package com.board.support.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.board.user.User;

public interface RowMapper<T> {
	T mapRow(ResultSet rs) throws SQLException;
}