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
				<c:forEach var="boardVO" items="${boardList}">
				<tr>
					<td><c:out value="${boardVO.boardId}"/></td>
					<td><c:out value="${boardVO.boardTitle}"/></td>
					<td><c:out value="${boardVO.userId}"/></td>
					<td><c:out value="${boardVO.boardDate}"/></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<c:choose>
			<c:when test="${not empty userId }">
				<c:set var="checkLogin" value="/JSPboard/write.jsp"/>
			</c:when>
			<c:otherwise>
				<c:set var="checkLogin" value="/JSPboard/login.jsp"/>
			</c:otherwise>
		</c:choose>
		
		<button type="button" onclick="location.href='${checkLogin}'" class="btn btn-primary btn-lg pull-right">새글</button>
	</div>
		<div class="row ">
			<c:if test="${currentPage>0 }">
				<a href="/JSPboard/board/list?page=${currentPage-1}" class="btn btn-primary btn-sm pull-left">이전</a>
			</c:if>
				<div class="text-center"><h4><c:out value="${currentPage+1 }/${totalPage } 페이지"/></h4></div>
			<c:if test="${(currentPage+1)<totalPage }">
				<a href="/JSPboard/board/list?page=${currentPage+1}" class="btn btn-primary btn-sm pull-left">다음</a>
			</c:if>
		</div>
</div>
<%@ include file="./common/_body.jspf" %>
</body>
</html>