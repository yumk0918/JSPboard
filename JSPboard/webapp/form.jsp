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
	<c:choose>
		<c:when test="${not empty user.userId }">
			<c:set var="actionURL" value="/JSPboard/users/update"/>
			<c:set var="button" value="개인정보수정"/>
			<h1 class="text-center">개인정보수정</h1>
		</c:when>
		<c:otherwise>
			<c:set var="actionURL" value="/JSPboard/users/save"/>
			<c:set var="button" value="회원가입"/>
			<h1 class="text-center">회원가입</h1>
		</c:otherwise>
	</c:choose>
	<br/><br/><br/>
	<form action="${actionURL}" method="post">
	  <div class="form-group">
	    <label for="userId">사용자 아이디 :</label>
	    <c:choose>
		<c:when test="${not empty user.userId }">
			<input type="hidden" name="userId" value="${user.userId}">
			<h4>${user.userId}</h4>
		</c:when>
		<c:otherwise>
			<input type="text" name="userId" class="form-control" >
		</c:otherwise>
	</c:choose>
	    
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
	    <input type="email" name="email" class="form-control" value="${user.email}">
	  </div>
	  <br/>
	  <button type="submit" class="btn btn-primary btn-lg btn-block">${button}</button>
	  </form>
	  </div>
	  </div>
<%@ include file="./common/_body.jspf" %>  </body>
</html>