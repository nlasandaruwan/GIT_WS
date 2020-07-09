<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="POST" action="webresources/DepartmentService/addDepartment" >
		Department Id: <input type="text" name="departmentId"> <br>
		department Category Name: <input type="text" name="departmentCategory"> <br>
		Department Name: <input type="text" name="departmentName"> <br>
		Employee Count: <input type="text" name="employeeCount"> <br>
		<input type="submit" value="Add Department" />
	</form>
</body>
</html>