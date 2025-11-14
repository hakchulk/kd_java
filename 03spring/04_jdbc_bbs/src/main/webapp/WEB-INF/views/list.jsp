<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<div class="container">
	<div class="d-flex justify-content-between">
		<h3>게시판 리스트</h3>
		<div>게시물 갯수 : ${count}</div>
	</div>
	<!-- <ul> -->
	<%-- <c:forEach var="item" items="${lists }"> --%>
	<!-- 	<li> -->
	<%-- 	${item.id } / ${item.title } / ${item.writer } / ${item.content } --%>
	<!-- 	</li> -->
	<%-- </c:forEach> --%>
	<!-- </ul> -->

	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Title</th>
				<th scope="col">Writer</th>
				<th scope="col">Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${lists }">
				<tr>
					<th scope="row">${item.id }</th>
					<td><a class="link-secondary text-decoration-none"
						href="view?id=${item.id }"> ${item.title }</a></td>
					<td>${item.writer }</td>
					<td>${item.created_at }</td>
					<td><a href="./delete?id=${item.id }" class="btn btn-danger btn-sm">삭제</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="text-end">
		<a href="./writeForm" class="btn btn-primary" >글작성</a>
	</div>
</div>
<%@ include file="include/footer.jsp"%>

