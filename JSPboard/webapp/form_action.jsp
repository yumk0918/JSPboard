<%@page import="com.board.db.Database"%>
<%@page import="com.board.user.User,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	User user=new User(request.getParameter("userId"),
			request.getParameter("password"),
			request.getParameter("name"),
			request.getParameter("email"));
	Database.addMap(user);
	response.sendRedirect("/JSPboard");
%>