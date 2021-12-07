<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div align="center">
	<form action="insert-student" method="post">
		<table border="1">
			<caption>
					<h4>Add Student</h4>
			</caption>
			<tr>
				<th>First Name</th>
				<td><input type="text" name="firstname" id="firstame" size=45 value="<c:out value='${student.firstname}' />"  required /></td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td><input type="text" name="lastname" id="lastname" size=45 value="<c:out value='${student.lastname}' />"  required /></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="text" name="email" id="email" size=45 value="<c:out value='${student.email}' />"  required /></td>
			</tr>
			<tr>
				<th>Phone</th>
				<td><input type="text" name="phone" id="email" size=45 value="<c:out value='${student.phone}' />"  required /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>