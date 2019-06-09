package com.board.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/users/update")
public class UpdateUserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String SessionUserId=SessionUtils.getStringValue(session, LoginServlet.SESSION_USER_ID);
		String userId=request.getParameter("userId");
		
		// session에 userId가 있는지 session에 있는 userId와 같은지 확인
		if(SessionUserId==null || !session.equals(userId)) {
			response.sendRedirect("/JSPboard");
			return;
		}
		User user=new User(userId,
				request.getParameter("password"),
				request.getParameter("name"),
				request.getParameter("email"));
		UserDAO userDAO=new UserDAO();
		try {
			userDAO.updateUser(user);
		} catch (SQLException e) {
		}
		response.sendRedirect("/JSPboard");
	}

}
