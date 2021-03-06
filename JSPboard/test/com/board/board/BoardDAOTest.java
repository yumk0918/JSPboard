package com.board.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	public static final Board TEST_BOARD = new Board(0, "Title", "userId", "Content", 1);
	private BoardDAO boardDAO;
	@Before
	public void setup() {
		boardDAO=new BoardDAO();
	}
	@Test
	public void crud() throws Exception{
		String boardId=TEST_BOARD.getBoardId()+"";
		boardDAO.addBoard(TEST_BOARD);
		
		Board updateBoard=new Board(0, "uTitle", "userId", "uContent", 1);
		boardDAO.updateBoard(updateBoard);
		
		Board dbboard=boardDAO.showBoardView(boardId);
		assertEquals(dbboard, updateBoard);
		
		boardDAO.updateBoardValid(TEST_BOARD.getUserId(), boardId);
		dbboard=boardDAO.showBoardView(boardId);
		assertEquals(dbboard.getBoardValid(),0);
		
		boardDAO.removeBoard(boardId,TEST_BOARD.getUserId());
	}
	/*@Test
	public void makeForPaging() throws Exception{
		for(int i=12;i<60;i++) {
			Board board=new Board(i,"Title "+i,"userId","Content "+i,1);
			boardDAO.addBoard(board);
		}
	}*/
	@Test
	public void checkBoardId() {
		assertTrue(boardDAO.getNextBoardId()>=0);
	}
	@Test
	public void showBoardList() {
		List<Board> boardList= boardDAO.showBoardList(1);
		logger.debug("boardList : {}",boardList);
		assertTrue(boardList.size()>0);
	}
	@Test
	public void checkTotalPage() {
		int totalPage=boardDAO.getTotalPage();
		logger.debug("totalPage : {}", totalPage);
		assertTrue(totalPage>=0);
	}

	
}
