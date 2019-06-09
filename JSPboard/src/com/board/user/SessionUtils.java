package com.board.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionUtils {
	public static boolean isEmpty(HttpSession session, String key) {
		String sessionUserId=(String)session.getAttribute(key);
		if(sessionUserId==null) {
			return true;
		}
		return false;
	}
	public static String getStringValue(HttpSession session, String key) {
		if(isEmpty(session, key)) {
			return null;
		}
		
		return (String)session.getAttribute(key);
	}
}
