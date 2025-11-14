<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<div class="container">
	<div>
		<h3>글작성 하기</h3>
	</div>
	<div>
		<form action="write" method="post" onsubmit="return validForm()">
			<div class="my-3">
				<label for="name" class="form-label">작성자</label> <input id="name"
					type="text" class="form-control" name="writer" required />
			</div>
			<div class="my-3">
				<label for="title" class="form-label">제목</label> <input id="title"
					type="text" class="form-control" name="title" required />
			</div>
			<div class="my-3">
				<label for="content" class="form-label">내용</label>
				<textarea rows=10 id="content" class="form-control" name="content">
				</textarea>
			</div>

			<div class="text-end">
				<button class="btn btn-primary" type="submit">작성완료</button>
			</div>
		</form>
	</div>
</div>

<%@ include file="include/footer.jsp"%>
