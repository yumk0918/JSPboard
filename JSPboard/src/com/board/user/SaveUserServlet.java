package com.board.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.db.Database;


@WebServlet("/users/save")
public class SaveUserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User user=new User(request.getParameter("userId"),
				request.getParameter("password"),
				request.getParameter("name"),
				request.getParameter("email"));
		Database.addUser(user);
		response.sendRedirect("/JSPboard");
	}

}
