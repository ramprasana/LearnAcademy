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
	<c:url var="myURL" value="link-class-stud">
        <c:param name="cid" value="${classes.cid}"/>
    </c:url>
	<form method="post" action="<c:out value="${myURL}"/>">
		<fieldset>
			<div align="center">
				<table border="1" cellpadding="1">
					<caption><h3>Assign Subject and Teacher to a Class</h3></caption>
					<tr>
						<td>Class Id</td>
						<td><c:out value="${classes.cid}" /></td>
					</tr>
					<tr>
						<td>Name</td>
						<td><c:out value="${classes.className}" /></td>
					</tr>
				</table>
			</div>
			<div align="center">
				<table border="1" cellpadding="1">	
					<tr>
						<td><label for="name">Student 1</label></td>
						<td>
							<select name="student1" id="student1">
								<c:forEach var="laSub" items="${students}">
									<option value="${laSub.id}">${laSub.first_name}&nbsp;${laSub.last_name}&nbsp;${laSub.email}</option>
								</c:forEach>								
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="name">Subject 2</label></td>
						<td>
							<select name="student2" id="student2">
								<c:forEach var="laSub" items="${students}">
									<option value="${laSub.id}">${laSub.first_name}&nbsp;${laSub.last_name}&nbsp;${laSub.email}</option>
								</c:forEach>								
							</select>
						</td>					
					</tr>
					<tr>
						<td><label for="name">Student 3</label></td>
						<td>
							<select name="student3" id="student3">
								<c:forEach var="laSub" items="${students}">
									<option value="${laSub.id}">${laSub.first_name}&nbsp;${laSub.last_name}&nbsp;${laSub.email}</option>
								</c:forEach>							
							</select>
						</td>
					</tr>	
					<tr><td colspan="4" align="center"><input type="submit" value="Save" /></td></tr>				
				</table>							
			</div>
		</fieldset>
	</form>
</body>
</html>