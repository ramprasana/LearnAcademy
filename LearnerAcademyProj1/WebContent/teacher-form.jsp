<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Teacher</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div align="center">
	<form action="insert-teacher" method="post">
		<table border="1" cellpadding="1">
			<caption>
				<div align="center">
					<h4>Add Teacher</h4>
				</div>
			</caption>
			<tr>
				<th>First Name</th>
				<td><input type="text" name="firstname" id="firstame" size=45 value="<c:out value='${teacher.firstname}' />"  required /></td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td><input type="text" name="lastname" id="lastname" size=45 value="<c:out value='${teacher.lastname}' />"  required /></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="text" name="email" id="email" size=45 value="<c:out value='${teacher.email}' />"  required /></td>
			</tr>
			<tr>
				<th>SkillSet</th>
				<td><textarea type="textarea" name="skillset" id="skillset" size=255 rows="4" cols="50" value="<c:out value='${teacher.skillset}' />"  required> </textarea> </td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>