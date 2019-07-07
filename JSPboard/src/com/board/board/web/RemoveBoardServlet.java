package com.board.board.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.board.Board;
import com.board.board.BoardDAO;
import com.board.support.SessionUtils;
import com.board.user.web.LoginServlet;


@WebServlet("/board/remove")
public class RemoveBoardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardId=request.getParameter("id");
		HttpSession session=request.getSession();
		String sessionUserId=SessionUtils.getStringValue(session, LoginServlet.SESSION_USER_ID);
		
		BoardDAO boardDAO=new BoardDAO();
		boardDAO.updateBoardValid(sessionUserId, boardId);
		response.sendRedirect("/JSPboard/board/list");
	}

}
