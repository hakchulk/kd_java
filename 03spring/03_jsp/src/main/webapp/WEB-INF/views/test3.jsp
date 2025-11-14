<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@include file="include/include_header.jsp" %>

<div class="container">
 	<c:forEach var="item" items="${list }">
 		${item }
	</c:forEach>
</div>
 

<%@include file="include/include_footer.jsp" %>
