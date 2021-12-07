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
	<jsp:include page="header.jsp" />
	<div align="center">
		<table border="1" cellpadding="1">
			<caption><h3>List of Teacher</h3></caption>
			<tr>
				<th>Teacher Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>EMail</th>
				<th>Skillset</th>				
			</tr>
			<c:forEach var="teacher" items="${listTeacher}">
				<tr>
					<td><c:out value="${teacher.id}" /></td>
					<td><c:out value="${teacher.first_name}" /></td>
					<td><c:out value="${teacher.last_name}" /></td> 
					<td><c:out value="${teacher.email}" /></td> 
					<td><c:out value="${teacher.skillset}" /></td> 					
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>