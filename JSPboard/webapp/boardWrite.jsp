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
			<c:choose>
				<c:when test="${isUpdateBoardView}">
					<c:set var="actionURL" value="/JSPboard/board/update"/>
					<c:set var="button" value="수정"/>
				</c:when>
				<c:otherwise>
					<c:set var="actionURL" value="/JSPboard/board/write"/>
					<c:set var="button" value="등록"/>
				</c:otherwise>
			</c:choose>			
			
			<h1 class="table">글쓰기</h1>
			<div class="empty"></div>
			<form action="${actionURL }" method="post">
				<input type="hidden" name="userId" value="${board.userId}">
				<input type="hidden" name="boardId" value="${board.boardId}">
				<input type="hidden" name="boardDate" value="${board.boardDate}">
				<input type="hidden" name="boardvalid" value="${board.boardvalid}">
				<table class="table table-bordered" style="width:100%">
					<tr>
						<td class="active"><b>제목</b></td>
						<td>
							<input class="form-control" type="text" maxlength="20" name="boardTitle" value="${board.boardTitle }"/>
						</td>
						<td class="active"><b>작성자</b></td>
						<td>
							${userId}
						</td>
					</tr>
					<tr>
						<td class="active" ><b>내용</b></td>
						<td colspan="3">
							<textarea class="form-control" style="height:500px" name="boardContent" >${board.boardContent }</textarea>
						</td>
					</tr>
				</table>
				<div class="form-group text-right">
	  				<label style="color: red;">${errorMessage}</label>
	  			</div>	
				<button type="submit" class="btn btn-primary btn-lg pull-right">${button}</button>
			</form>
		</div>
	</div>
	<%@ include file="./common/_body.jspf" %>
</body>
</html>