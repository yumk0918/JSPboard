package com.board.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.board.support.MyValidatorFactory;

@WebServlet("/users/update")
public class UpdateUserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String SessionUserId=SessionUtils.getStringValue(session, LoginServlet.SESSION_USER_ID);
		String userId=request.getParameter("userId");
		System.out.println(SessionUserId+":"+userId);
		// session에 userId가 있는지 session에 있는 userId와 같은지 확인
		if(SessionUserId==null || !SessionUserId.equals(userId)) {
			response.sendRedirect("/JSPboard");
			return;
		}
		User user=new User(userId,
				request.getParameter("password"),
				request.getParameter("name"),
				request.getParameter("email"));
		Validator validator=MyValidatorFactory.createValidator();
		Set<ConstraintViolation<User>> constraintViolations =validator.validate( user );
		if(constraintViolations.size()>0) {
			request.setAttribute("isUpdate",true);
			request.setAttribute("user", user);
			String errorMessage=constraintViolations.iterator().next().getPropertyPath()+" : "+constraintViolations.iterator().next().getMessage();
		    forwardJSP(request, response, errorMessage);
		    return;
		    
		}
		UserDAO userDAO=new UserDAO();
		try {
			userDAO.updateUser(user);
		} catch (SQLException e) {
		}
		response.sendRedirect("/JSPboard");
	}
	private void forwardJSP(HttpServletRequest request, HttpServletResponse response,String errorMessage) 
			throws ServletException, IOException {
		request.setAttribute("errorMessage", errorMessage);
 		RequestDispatcher rd=request.getRequestDispatcher("/form.jsp");
 		rd.forward(request, response);
	}

}
