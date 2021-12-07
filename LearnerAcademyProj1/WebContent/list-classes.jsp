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
			<caption><h3>List of Classes</h3></caption>
			<tr>
				<th>Class Id</th>
				<th>Name</th>
				<th>Start Date</th>
				<th>End Date</th>	
				<th>Action</th>			
			</tr>
			<c:forEach var="laclass" items="${listClasses}">
				<tr>
					<td><c:out value="${laclass.cid}" /></td>
					<td><c:out value="${laclass.className}" /></td>
					<td><c:out value="${laclass.sDate}" /></td> 
					<td><c:out value="${laclass.eDate}" /></td>
					<td>
						<a href="add-subject?cid=<c:out value='${laclass.cid}' />">Add Subject</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="add-student?cid=<c:out value='${laclass.cid}' />">Add Student</a>
					</td> 
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>