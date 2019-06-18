package com.board.user.web;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.board.support.SessionUtils;
import com.board.user.User;
import com.board.user.UserDAO;

@WebServlet("/users/updateForm")
public class UpdateFormUserServlet extends HttpServlet {
	 private static final Logger logger = LoggerFactory.getLogger(UpdateFormUserServlet.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userId=SessionUtils.getStringValue(session, LoginServlet.SESSION_USER_ID);
		if(userId==null) {
			response.sendRedirect("/JSPboard");
			return;
		}
		
		UserDAO userDAO=new UserDAO();
		logger.debug("userId : {}",userId);
			User user=userDAO.findByUserId(userId);
			request.setAttribute("isUpdate",true);
			request.setAttribute("user",user);
			RequestDispatcher rd=request.getRequestDispatcher("/form.jsp");
			rd.forward(request, response);
	}

}
