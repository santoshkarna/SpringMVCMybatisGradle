<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>
<style>
.center {
	margin-left: auto;
	margin-right: auto;
	width: 70%;
	background-color: #C0C0C0;
}
</style>
</head>
<body>
	<div class="center">
		<fieldset>
			<legend>Add Student Data</legend>
			<center>
				<form:form method="POST" action="/save.html">
					<table>
						<tr>
							<td><form:label path="studentName">Student Name:</form:label></td>
							<td><form:input path="studentName"
									value="${student.studentName}" /></td>
						</tr>
						<tr>
							<td><form:label path="studentRoll">Student Roll:</form:label></td>
							<td><form:input path="studentRoll"
									value="${student.studentRoll}" /></td>
						</tr>
						<tr>
							<td><form:label path="studentClass">Student Class:</form:label></td>
							<td><form:input path="studentClass"
									value="${student.studentClass}" /></td>
						</tr>
						<tr>
							<td colspan="1"><input type="submit" value="Submit" /></td>
						</tr>
					</table>
				</form:form>
			</center>
		</fieldset>
	</div>
</body>
</html>

