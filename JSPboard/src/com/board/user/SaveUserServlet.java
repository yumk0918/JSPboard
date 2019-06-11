package com.board.user;

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
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.board.support.MyValidatorFactory;

@WebServlet("/users/save")
public class SaveUserServlet extends HttpServlet {
	 private static final Logger logger = LoggerFactory.getLogger(SaveUserServlet.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User user=new User();
		try {
			BeanUtilsBean.getInstance().populate(user, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e1) {
			throw new ServletException(e1);
		}
		logger.debug("user : {}",user);
		Validator validator=MyValidatorFactory.createValidator();
		Set<ConstraintViolation<User>> constraintViolations =validator.validate( user );
		if(constraintViolations.size()>0) {
			request.setAttribute("user", user);
			String errorMessage=constraintViolations.iterator().next().getPropertyPath()+" : "+constraintViolations.iterator().next().getMessage();
		    forwardJSP(request, response, errorMessage);
		    return;
		    
		}
		UserDAO userDAO=new UserDAO();
		try {
			userDAO.addUser(user);
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
