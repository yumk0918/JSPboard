package com.board.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.board.support.jdbc.JdbcTemplate;

public class BoardDAO {
	private static final Logger logger = LoggerFactory.getLogger(BoardDAO.class);
	public static int getNextBoardId() {
		JdbcTemplate  template=new JdbcTemplate();
		String sql ="select max(Id) from BOARD";
		return template.executeQuery(sql)+1;
	}
	public void addBoard(Board board) {
		String sql="insert into BOARD values(?,?,?,?,?,?)";
		JdbcTemplate template=new JdbcTemplate();
		template.executeUpdate(sql,
				board.getBoardId(),board.getBoardTitle(),
				board.getUserId(),board.getBoardDate(),
				board.getBoardContent(),board.getBoardvalid());
	}
	public void removeBoard(int boardId) {
		String sql="delete from BOARD where id=?";
		JdbcTemplate template=new JdbcTemplate();
		template.executeUpdate(sql,boardId);
	}

}
