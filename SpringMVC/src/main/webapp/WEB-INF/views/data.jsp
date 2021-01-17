<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>All Users</h2>


	<table border="1">

		<th>Sr No</th>
		<th>Full Name</th>
		<th>Mobile Number</th>
		<th>Email</th>
		<th>Gender</th>

		<c:forEach var="reg" items="${listUser}">
			<tr>
				<td>${reg.id}</td>
				<td>${reg.fullname}</td>
				<td>${reg.mobileNumber}</td>
				<td>${reg.email}</td>
				<td>${reg.gender}</td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>