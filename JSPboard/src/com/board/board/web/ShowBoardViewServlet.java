package com.board.board.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.board.board.Board;
import com.board.board.BoardDAO;
import com.board.support.SessionUtils;
import com.board.user.web.LoginServlet;

@WebServlet("/board/view")
public class ShowBoardViewServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(ShowBoardViewServlet.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardId=request.getParameter("id");
		BoardDAO boardDAO=new BoardDAO();
		Board board=boardDAO.showBoardView(boardId);
		logger.debug("{}",board);
		if(board==null) {
			response.sendRedirect("/JSPboard/board/list");
			return;
		}
		HttpSession session=request.getSession();
		String sessionUserId=SessionUtils.getStringValue(session, LoginServlet.SESSION_USER_ID);
		if(board.getUserId().equals(sessionUserId)) 
			request.setAttribute("isUpdateBoard", true);
		
		request.setAttribute("board", board);
		RequestDispatcher rd=request.getRequestDispatcher("/boardView.jsp");
		rd.forward(request, response);
	}

}
