package com.board.board;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.board.support.jdbc.JdbcTemplate;
import com.board.support.jdbc.RowMapper;

public class BoardDAO {
	private static final Logger logger = LoggerFactory.getLogger(BoardDAO.class);
	public static int getNextBoardId() {
		JdbcTemplate  template=new JdbcTemplate();
		String sql ="select max(Id) from BOARD";
		return template.executeQuery(sql)+1;
	}
	public static int getTotalPage() {
		JdbcTemplate  template=new JdbcTemplate();
		String sql ="select count(id) from BOARD";
		int totalCount=template.executeQuery(sql);
		return totalCount%10==0?totalCount/10:totalCount/10+1;
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
	public List<Board> showBoardList(int pageNum) {
		RowMapper<Board> rm=rs->new Board(
				rs.getInt("id"), 
				rs.getString("title"), 
				rs.getString("userId"), 
				rs.getString("date"), 
				rs.getString("content"), 
				rs.getInt("valid"));
		JdbcTemplate  template=new JdbcTemplate();
		String sql ="select new.* from (select*from BOARD order by id desc) new limit ?,10";
		return template.list(sql,rm,10*(pageNum-1));
	}

}
