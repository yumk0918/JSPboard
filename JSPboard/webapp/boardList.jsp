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
					<c:choose>
						<c:when test="${boardVO.boardValid==0}">
							<td><c:out value="${boardVO.boardId}"/></td>
							<td><i>삭제된 댓글입니다.</i></td>
							<td><c:out value="${boardVO.userId}"/></td>
							<td><c:out value="${boardVO.boardDate}"/></td>
						</c:when>
						<c:otherwise>
							<td><c:out value="${boardVO.boardId}"/></td>
							<td><a style="color:#000000"href="/JSPboard/board/view?id=${boardVO.boardId}"><c:out value="${boardVO.boardTitle}"/></a></td>
							<td><c:out value="${boardVO.userId}"/></td>
							<td><c:out value="${boardVO.boardDate}"/></td>
						</c:otherwise>
					</c:choose>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<c:choose>
			<c:when test="${not empty userId }">
				<c:set var="checkLogin" value="/JSPboard/boardWrite.jsp"/>
			</c:when>
			<c:otherwise>
				<c:set var="checkLogin" value="/JSPboard/login.jsp"/>
			</c:otherwise>
		</c:choose>
		
		<button type="button" onclick="location.href='${checkLogin}'" class="btn btn-primary btn-lg pull-right">새글</button>
	</div>
		<div class="row ">
			<div class="text-center">
				<h4>				
					<c:if test="${currentPage>1 }">
						<a href="/JSPboard/board/list">[처음]</a>
						<a href="/JSPboard/board/list?page=${currentPage-1}">[이전]</a>
					</c:if>
						<c:out value="${currentPage}/${totalPage } 페이지"/>
					<c:if test="${currentPage<totalPage }">
						<a href="/JSPboard/board/list?page=${currentPage+1}">[다음]</a>
						<a href="/JSPboard/board/list?page=${totalPage}">[끝]</a>
					</c:if>
				
				</h4>
			</div>
		</div>
</div>
<%@ include file="./common/_body.jspf" %>
</body>
</html>