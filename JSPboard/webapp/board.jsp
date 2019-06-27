<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
<%@ include file="./common/_head.jspf" %>
  </head>
  <body>
<%@ include file="./common/_nav.jspf" %>
<div class="container" id="table">
	<div class="row">
	<h1 class="table">게시판</h1>
	<div class="empty"></div>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th class="col-md-1">번호</th>
					<th class="col-md-7">제목</th>
					<th class="col-md-2">작성자</th>
					<th class="col-md-2">작성일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>안녕하세요</td>
					<td>홍길동</td>
					<td>2019-06-25</td>
				</tr>
			</tbody>
		</table>
		<button type="button" onclick="location.href='./write.jsp'" class="btn btn-primary btn-lg pull-right">새글</button>
	</div>
</div>
<%@ include file="./common/_body.jspf" %>
</body>
</html>