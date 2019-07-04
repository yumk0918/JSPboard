package com.board.board.web;

import java.io.IOException;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.board.board.Board;
import com.board.board.BoardDAO;
import com.board.support.MyValidatorFactory;
import com.board.support.SessionUtils;
import com.board.user.web.LoginServlet;

@WebServlet("/board/write")
public class WriteBoardServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(WriteBoardServlet.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userId=SessionUtils.getStringValue(session, LoginServlet.SESSION_USER_ID);
		int boardId=BoardDAO.getNextBoardId();
		Board board=new Board(boardId
				,request.getParameter("boardTitle")
				,userId
				,request.getParameter("boardContent")
				,1);
		
		logger.debug("board : {}", board);
		Validator validator=MyValidatorFactory.createValidator();
		Set<ConstraintViolation<Board>> constraintViolations =validator.validate( board );
		if(constraintViolations.size()>0) {
			request.setAttribute("board", board);
			String errorMessage=constraintViolations.iterator().next().getMessage();
			logger.debug("erromessage : {}", errorMessage);
		    forwardJSP(request, response, errorMessage);
		    return;
		    
		}
		BoardDAO boardDAO=new BoardDAO();
		boardDAO.addBoard(board);
		
		response.sendRedirect("/JSPboard/board/list");
	}
	private void forwardJSP(HttpServletRequest request, HttpServletResponse response,String errorMessage) 
			throws ServletException, IOException {
		request.setAttribute("errorMessage", errorMessage);
 		RequestDispatcher rd=request.getRequestDispatcher("/write.jsp");
 		rd.forward(request, response);
	}

}
