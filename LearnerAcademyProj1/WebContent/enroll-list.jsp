<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>  
<%@page import="java.util.Iterator" %>
<%@page import="com.la.entity.Student" %>
<%@page import="com.la.entity.Classes" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div align="center">
		<table border="1" cellpadding="1">
			<caption><h3>Enrollment Report</h3></caption>
			<tr>
				<th>Class Id</th>
				<th>Name</th>
				<th>Start Date</th>
				<th>End Date</th>	
				<th colspan="4"></th>	
			</tr>
			<%
			 List<Classes> enrollmentList = (ArrayList) request.getAttribute("listClasses");	
			 if(request.getAttribute("listClasses") != null) {
				 Iterator<Classes> iterator = enrollmentList.iterator(); 
				 while(iterator.hasNext()) {
					 Classes cal = iterator.next();	
					 List<Student> enrolledStudent = cal.getStudent();
					 Iterator<Student> studentIterator = enrolledStudent.iterator();
					 
		 	%>
		 			 <tr>
					 	<td><%= cal.getCid() %></td>
					 	<td><%= cal.getClassName() %></td>
					 	<td><%= cal.getsDate() %></td>
					 	<td><%= cal.geteDate() %></td>
		
				<% if(enrolledStudent.size() > 0 ) { %>		 	
					 	<td>	
							<table>
							<tr>
								<th>Student Id</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email</th>	
							</tr>
		 	<%
					 while(studentIterator.hasNext()) {
						 Student stud = studentIterator.next();
			%>
							<tr>
							<td><%= stud.getId() %></td>
							<td><%= stud.getFirst_name() %></td>
							<td><%= stud.getLast_name() %></td>
							<td><%= stud.getEmail()  %></td>
							</tr>
			<% 
					 }
				}
		 		else {
		 	%>
		 		<td colspan="4"></td>
		 	<% 		
		 		}
		 	%>	
		 				</table>
		 				</td>
		 			</tr>
		 	<% 
				}
			 }
			%>
		</table>
	</div>

</body>
</html>