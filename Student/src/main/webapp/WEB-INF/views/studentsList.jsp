<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Students</title>
</head>
<body>
	<center>
		<h1>Student List</h1>
		<h3>
			<a href="add.html">Add More Student</a>
		</h3>
	</center>
	<center>
		<form:form method="POST" commandName="searchStudent"
			action="/studentslist.html">
			<table >
				<tr>
					<td><form:label path="studentName">Student Name:</form:label></td>
					<td><form:input path="studentName"
							value="${searchStudent.studentName}" /></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td colspan="1"><input type="submit" name="action"
						value="Submit" /></td>
					<td colspan="1"><input type="submit" name="action"
						value="Reset" /></td>
				</tr>
			</table>
		</form:form>
	</center>
	<br>
	<c:if test="${!empty students}">
		<table align="center" border="1">
			<tr style="background-color: gray;">
				<th>Student ID</th>
				<th>Student Name</th>
				<th>Student Roll</th>
				<th>Student Class</th>
				<th>Actions on Row</th>
			</tr>
			<c:forEach items="${students}" var="student">
				<tr style="background-color: silver;">
					<td><c:out value="${student.studentId}" /></td>
					<td><c:out value="${student.studentName}" /></td>
					<td><c:out value="${student.studentRoll}" /></td>
					<td><c:out value="${student.studentClass}" /></td>
					<td align="center">| <a
						href="edit.html?studentId=${student.studentId}">Edit</a> | <a
						href="delete.html?studentId=${student.studentId}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>
