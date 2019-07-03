package com.board.board;

import static org.junit.Assert.*;

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
		boardDAO.removeBoard(0);
		boardDAO.addBoard(TEST_BOARD);
	}
	@Test
	public void checkBoardId() {
		assertTrue(boardDAO.getNextBoardId()>=0);
	}
}
