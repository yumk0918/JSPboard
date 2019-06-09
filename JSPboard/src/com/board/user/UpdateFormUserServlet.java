package com.board.user;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/users/updateForm")
public class UpdateFormUserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userId=SessionUtils.getStringValue(session, LoginServlet.SESSION_USER_ID);
		if(userId==null) {
			response.sendRedirect("/JSPboard");
			return;
		}
		
		UserDAO userDAO=new UserDAO();
		System.out.println("userId : "+userId);
		try {
			User user=userDAO.findByUserId(userId);
			request.setAttribute("user",user);
			RequestDispatcher rd=request.getRequestDispatcher("/form.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {}
	}

}
