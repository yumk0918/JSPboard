package com.board.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
	public void crud() throws Exception{
		User user=UserTest.TEST_USER;
		userDAO.removeUser(user.getUserId());
		userDAO.addUser(user);
		
		User updateUser=new User(user.getUserId(), "upassword", "uname", "uemail@email");
		userDAO.updateUser(updateUser);
		
		User dbUser=userDAO.findByUserId(user.getUserId());
		assertEquals(updateUser, dbUser);
	}
	
	@Test
	public void findWhenNotExisted() throws Exception{
		User user=UserTest.TEST_USER;
		userDAO.removeUser(user.getUserId());
		
		User dbUser=userDAO.findByUserId(user.getUserId());
		assertNull(dbUser);
	}
}
