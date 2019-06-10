package com.board.user;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/users/login")
public class LoginServlet extends HttpServlet {
	public static final String SESSION_USER_ID = "userId";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter(SESSION_USER_ID);
	 	String password=request.getParameter("password");
	 	try{
	 		User.login(userId, password);
	 		HttpSession session=request.getSession();
	 		session.setAttribute(SESSION_USER_ID, userId);
	 		response.sendRedirect("/JSPboard");
	 	}catch(UserNotFoundException e){
	 		forwardJSP(request, response,"존재하지 않는 사용자입니다. 다시 로그인하세요.");
	 	}catch(PasswordMismatchException e){
	 		forwardJSP(request, response,"비밀번호가 틀립니다. 다시 로그인하세요.");	 
	 	}
	}
	private void forwardJSP(HttpServletRequest request, HttpServletResponse response,String errorMessage) 
			throws ServletException, IOException {
		request.setAttribute("errorMessage", errorMessage);
 		RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
 		rd.forward(request, response);
	}

}
