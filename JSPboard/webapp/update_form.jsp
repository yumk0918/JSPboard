<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
<%@ include file="./common/_head.jspf" %>
  </head>
  <body>
<%@ include file="./common/_nav.jspf" %>
	<div class="jumbotron jumbotron">
	<div class="container">
	<h1 class="text-center">개인정보수정</h1>
	<br/><br/><br/>
	<form action="/JSPboard/users/update" method="post">
	  <input type="hidden" name="userId" value="${user.userId}">
	  <div class="form-group">
	    <label for="userId">사용자 아이디 :</label>
	    <h4>${user.userId}</h4>
	  </div>
	  <br/>
	  <div class="form-group">
	    <label for="password">비밀번호 :</label>
	    <input type="password" name="password" class="form-control" >
	  </div>
	  <br/>
	  <div class="form-group">
	    <label for="name">이름 :</label>
	    <input type="text" name="name" class="form-control" value="${user.name}">
	  </div>
	  <br/>
	  <div class="form-group">
	    <label for="email">이메일 :</label>
	    <input type="email" name="email" class="form-control" ${user.email}">
	  </div>
	  <br/>
	  <button type="submit" class="btn btn-primary btn-lg btn-block">개인정보수정</button>
	  </form>
	  </div>
	  </div>
<%@ include file="./common/_body.jspf" %> 
 </body>
</html>