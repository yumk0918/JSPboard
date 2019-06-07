package com.board.db;

import java.util.HashMap;
import java.util.Map;

import com.board.user.User;

public class Database {
	private static Map<String, User> users=new HashMap<String, User>();
	public static void addUser(User user){
		users.put(user.getUserId(), user);
		System.out.println(user.toString());
	}
	public static User findByUserId(String userId) {
		return users.get(userId);
	}
	
	
}
