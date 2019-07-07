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
			<h1 class="table">게시글</h1>
			<div class="empty"></div>
				<table class="table table-bordered" style="width:100%">
					<tr>
						<td colspan="1" class="active"><b>제목</b></td>
						<td colspan="4" class="text-left" >
							${board.boardTitle }
						</td>
					</tr>
					<tr>
						<td class="active"><b>작성자</b></td>
						<td class="text-left">
							${board.userId }
						</td>
						<td class="active"><b>작성일</b></td>
						<td class="text-left">
							${board.boardDate }
						</td>
					</tr>
					<tr>
						<td colspan="1" class="active"><b>내용</b></td>
						<td colspan="4" class="text-left" style="height:500px" >
							<xmp>${board.boardContent }</xmp>
						</td>
					</tr>
				</table>
				<div class="empty"></div>	
				<div align="right">
				<a href="/JSPboard/board/list" class="btn btn-primary btn-lg">목록</a>
				<c:if test="${isUpdateBoard}">
					&nbsp;&nbsp;<a href="/JSPboard/board/updateForm?id=${board.boardId}" class="btn btn-primary btn-lg">수정</a>
					&nbsp;&nbsp;<a href="/JSPboard/board/remove?id=${board.boardId}" class="btn btn-primary btn-lg">삭제</a>
				</c:if>
				</div>
		</div>
	</div>
	<%@ include file="./common/_body.jspf" %>
</body>
</html>