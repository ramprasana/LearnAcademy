<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Class</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<form action="insert-class" method="post">
	<div align="center">
		<table border="1" cellpadding="1">
			<caption>
				<div align="center">
					<h4>Add Class</h4>
				</div>
			</caption>
			<tr>
				<th>Class Name</th>
				<td><input type="text" name="className" id="className" size=45 value="<c:out value='${laclass.className}' />"  required /></td>
			</tr>
			<tr>
				<th>Start Date(YYYY/MM/DD)</th>
				<td><input type="date" name="sDate" id="sDate" size=10  required/></td>
			</tr>
			<tr>
				<th>End Date(YYYY/MM/DD)</th>
				<td><input type="date" name="eDate" id="eDate" size=10  required /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save" /></td>
			</tr>
		</table>
		</div>
	</form>
</body>
</html>