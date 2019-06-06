<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>JSP 게시판</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
  	<style type="text/css">
.navbar {
	margin-bottom: 0;
	background-color: #2d2d30;
	border: 0;
	font-size: 17px !important;
	opacity: 0.9;
	font-weight: bold;
}

.navbar-brand {
	font-size: 20px;
}

div.container {
	width: 60%;
	font-size: 1.3rem;
	margin-top: 0;
	margin-left: 12%;
	width: 76%;
	height: 50%;
}

.centered {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	font-size: 6rem;
	text-shadow: 1px 1px 0 #444
}

div#img {
	position: relative;
	text-align: center;
}

div#img img {
	opacity: 0.65;
}

div.jumbotron {
	margin-top: 5%;
	margin-left: 20%;
	width: 60%;
	height: 80%;
}
div.form-group label{
	font-size: 1.8rem;
}
</style>
  </head>
  <body>
<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="/JSPboard/index.jsp">JSP 게시판</a>
	      	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        		<span class="icon-bar"></span>
       		 	<span class="icon-bar"></span>
        		<span class="icon-bar"></span> 
      		</button>	
	    </div>
	    <ul class="nav navbar-nav navbar-right collapse navbar-collapse" id="myNavbar">
	      <li><a href="/JSPboard/form.jsp"><span class="glyphicon glyphicon-user"></span> 회원가입</a></li>
	      <li><a href="#"><span class="glyphicon glyphicon-user"></span> 개인정보수정</a></li>
	      <li><a href="/JSPboard/login.jsp"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
	      <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>
	    </ul>
	  </div>
	</nav>
	<div class="jumbotron jumbotron">
	<div class="container">
	<h1 class="text-center">로그인</h1>
	<br/>
	<form action="#" method="post">
	
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
	  </form>
	  </div>
	  </div>
	  
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
  </body>
</html>