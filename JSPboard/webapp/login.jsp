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
	<h1 class="text-center">로그인</h1>
	<br/>
	<form action="/JSPboard/login_action.jsp" method="post">
	
	  <div class="form-group">
	    <label for="userId">사용자 아이디 :</label>
	    <input type="text" name="userId" class="form-control">
	  </div>
	  <br/>
	  <div class="form-group">
	    <label for="password">비밀번호 :</label>
	    <input type="password" name="password" class="form-control">
	  </div>
	  <br/>
	  <button type="submit" class="btn btn-primary btn-lg btn-block">로그인</button>
	  <br/>
	  <%
	  	Object errorMessage=request.getAttribute("errorMessage");
	  	if(errorMessage!=null){
	  %>
	  	<div class="form-group">
	  		<label style="color: red;"><%=errorMessage%></label>
	  	</div>
	  <%
	  	}else{
	  		%><br/><% 
	  	}
	  %>
	  </form>
	  </div>
	  </div>
<%@ include file="./common/_body.jspf" %>
     </body>
</html>