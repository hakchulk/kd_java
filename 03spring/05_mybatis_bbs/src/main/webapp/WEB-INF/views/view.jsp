<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<div class="container mt-5">
	<div>
		<h4 class="mb-3">${item.id }. ${item.title }</h4>
		<h5 class="text-scondary" >${item.writer }</h5>
		<hr />
		<p class="my-5" >
		${item.content }
		</p>
		<div class="d-flex justify-content-end" >
			<a href="./list" class="btn btn-primary btn-sm">목록으로</a>
		</div>
	</div>


</div>
<%@ include file="include/footer.jsp"%>