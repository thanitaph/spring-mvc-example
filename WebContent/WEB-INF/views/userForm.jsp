<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User</title>
</head>
<body>
	<h3>User Form</h3>
	<form action="${pageContext.request.contextPath}/user/add" method="post">
		<input type="text" name="userName"><br/>
		<input type="text" name="userAge"><br/>
		<input type="submit" value="Create">
	</form>
</body>
</html>