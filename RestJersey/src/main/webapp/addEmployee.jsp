<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="POST" action="webresources/EmployeeService/addEmployeeForm" >
		Department Id: <input type="text" name="departmentId"> <br>
		Employee Name: <input type="text" name="employeeName"> <br>
		Department Name: <input type="text" name="departmentName"> <br>
		Salary: <input type="text" name="salary"> <br>
		<input type="submit" value="Add Employee" />
	</form>
</body>
</html>