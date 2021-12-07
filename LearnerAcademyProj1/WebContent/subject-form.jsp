<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Subject</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div align="center">
	<form action="insert-subject" method="post">
		<table border="1" cellpadding="1">
			<caption>
					<div align="center">
						<h4>Add Subject</h4>
					</div>
			</caption>
			<tr>
				<th>Subject title:</th>
				<td>
					<input type="text" name="sdesc" size=45 value="<c:out value='${subject.desc}' />" />					
				</td>
			</tr>
			<tr>
				<th>Teacher</th>
				<td>
					<select name="teacher1" id="teacher1">
						<c:forEach var="laTec" items="${listTeacher}">
							<option value="${laTec.id}">${laTec.first_name}-${laTec.skillset}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Save" />
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>