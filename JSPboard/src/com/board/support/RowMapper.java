package com.board.support;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.board.user.User;

public interface RowMapper {
	public abstract User mapRow(ResultSet rs) throws SQLException;
}
