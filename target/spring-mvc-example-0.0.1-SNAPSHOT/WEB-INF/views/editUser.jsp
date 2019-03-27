<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
</head>
<body>
	<h3>Edit User Form</h3>
	<form action="${pageContext.request.contextPath}/user/edit" method="post">
		<input type="text" name="userName" value="${user.userName}"><br/>
		<input type="text" name="userAge" value="${user.userAge}"><br/>
		<input type="submit" value="Edit">
	</form>
</body>
</html>