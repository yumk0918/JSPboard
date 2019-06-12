package com.board.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDAOTest {
	 private static final Logger logger = LoggerFactory.getLogger(UserDAOTest.class);
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
	@Test
	public void findUsers() throws Exception{
		List<User> users=userDAO.findUsers();
		logger.debug("User : {}",users);
		assertTrue(users.size()>0);
	}
}
