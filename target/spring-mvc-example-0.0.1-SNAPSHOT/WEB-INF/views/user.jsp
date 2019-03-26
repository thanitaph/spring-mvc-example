
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>User Home Page</title>
</head>
<body>
	<div align="center">
		<h3>User List</h3>
		<table border="1">
                <th>No</th>
                <th>Name</th>
                <th>Age</th>
                 
                <c:forEach var="user" items="${listUser}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${user.userName}</td>
                    <td>${user.userAge}</td>
                             
                </tr>
                </c:forEach>             
            </table>
	</div>

</body>
</html>
