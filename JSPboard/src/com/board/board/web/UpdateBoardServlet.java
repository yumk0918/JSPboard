package com.board.board.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.board.board.Board;
import com.board.board.BoardDAO;
import com.board.support.MyValidatorFactory;
import com.board.support.SessionUtils;
import com.board.user.web.LoginServlet;

@WebServlet("/board/update")
public class UpdateBoardServlet extends HttpServlet {
	 private static final Logger logger = LoggerFactory.getLogger(UpdateBoardServlet.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String sessionUserId=SessionUtils.getStringValue(session, LoginServlet.SESSION_USER_ID);
		
		Board board=new Board();
		try {
			BeanUtilsBean.getInstance().populate(board, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e1) {
			throw new ServletException(e1);
		}
		logger.debug("{}",board);
		if(!board.getUserId().equals(sessionUserId)) {
			response.sendRedirect("/JSPBoard");
			return;
		}
		Validator validator=MyValidatorFactory.createValidator();
		Set<ConstraintViolation<Board>> constraintViolations =validator.validate( board );
		if(constraintViolations.size()>0) {
			request.setAttribute("board", board);
			request.setAttribute("isUpdateBoardView", true);
			String errorMessage=constraintViolations.iterator().next().getMessage();
		    forwardJSP(request, response, errorMessage);
		    return;
		}
		
		BoardDAO boardDAO=new BoardDAO();
		boardDAO.updateBoard(board);
		response.sendRedirect("/JSPboard/board/view?id="+board.getBoardId());
	}
	private void forwardJSP(HttpServletRequest request, HttpServletResponse response,String errorMessage) 
			throws ServletException, IOException {
		request.setAttribute("errorMessage", errorMessage);
 		RequestDispatcher rd=request.getRequestDispatcher("/boardWrite.jsp");
 		rd.forward(request, response);
	}
}
