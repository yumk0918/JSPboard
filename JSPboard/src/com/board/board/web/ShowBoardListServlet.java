package com.board.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.board.board.Board;
import com.board.board.BoardDAO;

@WebServlet("/board/list")
public class ShowBoardListServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(ShowBoardListServlet.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page"); // 요구받은 페이지
		int totalPage=BoardDAO.getTotalPage(); // 전체 페이지
		int currentPage=getCurrentPage(page, totalPage); // 페이지 예외처리, 쿼리문에서 가져 갈 페이지
		
		BoardDAO boardDAO=new BoardDAO();
		List<Board> boardList = boardDAO.showBoardList(currentPage);
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("boardList", boardList);
		RequestDispatcher rd=request.getRequestDispatcher("/boardList.jsp");
		rd.forward(request, response);
		logger.debug(boardList.toString());
	}
	private int getCurrentPage(String page, int totalPage) {
		if(page==null) return 1;
		int currentPage=Integer.parseInt(page);
		
		if(currentPage<=0) return 1;
		else if(currentPage>totalPage) return totalPage;
		
		return currentPage;
	}
}
