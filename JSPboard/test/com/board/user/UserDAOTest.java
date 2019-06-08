package com.board.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

public class UserDAOTest {
	private UserDAO userDAO;
	@Before
	public void setup() {
		userDAO=new UserDAO();
	}
	@Test
	public void test() {
		Connection conn=userDAO.getConnection();
		assertNotNull(conn);
	}
	@Test
	public void addUser() throws Exception{
		userDAO.addUser(UserTest.TEST_USER);
	}
	@Test
	public void findByUserId() throws Exception{
		User user=userDAO.findByUserId("userId");
		assertEquals(UserTest.TEST_USER, user);
	}
}
