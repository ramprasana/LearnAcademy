<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Learning Academy</title>
</head>
<body>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.la.entity.Subject" %>
<%@page import="com.la.entity.Classes" %>
	<jsp:include page="header.jsp" />
	<div align="center">
		<table border="1" cellpadding="1">
			<caption><h3>List of Student</h3></caption>
			<tr>
				<th>Student Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>EMail</th>
				<th>Phone</th>			
			</tr>
			<c:forEach var="student" items="${listStudent}">
				<tr>
					<td><c:out value="${student.id}" /></td> 
					<td><c:out value="${student.first_name}" /></td>
					<td><c:out value="${student.last_name}" /></td> 
					<td><c:out value="${student.email}" /></td> 
					<td><c:out value="${student.phone}" /></td> 
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>