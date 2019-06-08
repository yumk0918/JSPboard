package com.board.user;

import static org.junit.Assert.*;
import org.junit.Test;


public class UserTest {
	public static final User TEST_USER=new User("userId","password","name","email@email");
	@Test
	public void matcedPassword() {
		assertTrue(TEST_USER.matchPassword("password"));
	}
	@Test
	public void notMatcedPassword() {
		assertFalse(TEST_USER.matchPassword("password2"));
	}
	@Test
	public void login() throws Exception{
		User user=UserTest.TEST_USER;
		UserDAO userDAO=new UserDAO();
		userDAO.addUser(user);
		
		assertTrue(User.login(TEST_USER.getUserId(),TEST_USER.getPassword()));
	}
	
	@Test(expected=UserNotFoundException.class)
	public void loginWhenNotExistedUser() throws Exception{
		User.login("userId2",TEST_USER.getPassword());
	}
	
	@Test(expected=PasswordMismatchException.class)
	public void loginWhenNotPasswordMismated() throws Exception{
		User user=UserTest.TEST_USER;
		UserDAO userDAO=new UserDAO();
		userDAO.addUser(user);
		User.login(TEST_USER.getUserId(),"password2");
	}
}
