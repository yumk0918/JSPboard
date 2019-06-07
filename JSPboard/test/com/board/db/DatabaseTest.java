package com.board.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.board.user.User;
import com.board.user.UserTest;


public class DatabaseTest {

	@Test
	public void addAndFindWhenExisted() {
		User user=UserTest.TEST_USER;
		Database.addUser(user);
		User dbuser=Database.findByUserId(user.getUserId());
		assertEquals(user,dbuser);
	}
	@Test
	public void addAndFindWhenNotExisted() {
		User dbuser=Database.findByUserId("userid2");
		assertNull(dbuser);
	}

}
