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
			<caption><h3>List of Subject</h3></caption>
			<tr>
				<th>Subject Id</th>
				<th>Description</th>
				<th>Assigned Teacher</th> 				
			</tr>
			<c:forEach var="subject" items="${listSubject}">
				<tr>
					<td><c:out value="${subject.subjectId}" /></td>
					<td><c:out value="${subject.desc}" /></td>
					<td><c:out value="${subject.tid}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>