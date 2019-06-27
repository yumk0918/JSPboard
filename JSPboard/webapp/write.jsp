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
			<h1 class="table">글쓰기</h1>
			<div class="empty"></div>
			<form action="#" method="post">
				<table class="table table-bordered" style="width:100%">
					<tr>
						<td class="active"><b>제목</b></td>
						<td>
							<input class="form-control" type="text" maxlength=20" name="bTitle"/>
						</td>
					</tr>
					<tr>
						<td class="active"><b>내용</b></td>
						<td>
							<textarea class="form-control" rows="18" name="bContent"></textarea>
						</td>
					</tr>
				</table>
				<button type="submit" class="btn btn-primary btn-lg pull-right">등록</button>
			</form>
		</div>
	</div>
	<%@ include file="./common/_body.jspf" %>
</body>
</html>