package com.board.user.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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

import org.apache.commons.beanutils.BeanUtilsBean;

import com.board.support.MyValidatorFactory;
import com.board.support.SessionUtils;
import com.board.user.User;
import com.board.user.UserDAO;

@WebServlet("/users/update")
public class UpdateUserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String SessionUserId=SessionUtils.getStringValue(session, LoginServlet.SESSION_USER_ID);

		User user=new User();
		try {
			BeanUtilsBean.getInstance().populate(user, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e1) {
			throw new ServletException(e1);
		}
		
		// session에 userId가 있는지 session에 있는 userId와 같은지 확인
		if(SessionUserId==null || !user.isSameUser(SessionUserId)) {
			response.sendRedirect("/JSPboard");
			return;
		}

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
		userDAO.updateUser(user);
		
		response.sendRedirect("/JSPboard");
	}
	private void forwardJSP(HttpServletRequest request, HttpServletResponse response,String errorMessage) 
			throws ServletException, IOException {
		request.setAttribute("errorMessage", errorMessage);
 		RequestDispatcher rd=request.getRequestDispatcher("/form.jsp");
 		rd.forward(request, response);
	}

}
