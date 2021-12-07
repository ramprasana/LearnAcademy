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
	<c:url var="myURL" value="link-class-subj">
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
						<td><label for="name">Subject 1</label></td>
						<td>
							<select name="subject1" id="subject1">
								<c:forEach var="laSub" items="${subjects}">
									<option value="${laSub.subjectId}">${laSub.desc}</option>
								</c:forEach>								
							</select>
						</td>
						<td><label for="name">Teacher</label></td>
						<td>
							<select name="teacher1" id="teacher1">
								<c:forEach var="laTec" items="${teachers}">
									<option value="${laTec.id}">${laTec.first_name}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="name">Subject 2</label></td>
						<td>
							<select name="subject2" id="subject2">
								<c:forEach var="laSub" items="${subjects}">
									<option value="${laSub.subjectId}">${laSub.desc}</option>
								</c:forEach>								
							</select>
						</td>
						<td><label for="name">Teacher</label></td>
						<td>
							<select name="teacher2" id="teacher2">
								<c:forEach var="laTec" items="${teachers}">
									<option value="${laTec.id}">${laTec.first_name}</option>
								</c:forEach>
							</select>	
						</td>						
					</tr>
					<tr>
						<td><label for="name">Subject 3</label></td>
						<td>
							<select name="subject3" id="subject3">
								<c:forEach var="laSub" items="${subjects}">
									<option value="${laSub.subjectId}">${laSub.desc}</option>
								</c:forEach>								
							</select>
						</td>
						<td><label for="name">Teacher</label></td>
						<td>
							<select name="teacher3" id="teacher3">
								<c:forEach var="laTec" items="${teachers}">
									<option value="${laTec.id}">${laTec.first_name}</option>
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