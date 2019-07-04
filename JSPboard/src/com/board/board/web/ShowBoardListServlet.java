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
		String page=request.getParameter("page");
		int totalPage=BoardDAO.getTotalPage();
		int pageNum=getPageNum(page, totalPage);
		
		BoardDAO boardDAO=new BoardDAO();
		List<Board> boardList = boardDAO.showBoardList(pageNum);
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("currentPage", pageNum);
		request.setAttribute("boardList", boardList);
		RequestDispatcher rd=request.getRequestDispatcher("/boardList.jsp");
		rd.forward(request, response);
		logger.debug(boardList.toString());
	}
	private int getPageNum(String page, int totalPage) {
		if(page==null) return 0;
		int pageNum=Integer.parseInt(page);
		if(pageNum<0) return 0;
		else if(pageNum>totalPage) return totalPage;
		return pageNum;
	}

}
