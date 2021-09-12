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

<h3 class="text-center">List of Users</h3>
			<hr>
			<a href="Controller?command=logout">Logout</a>
			
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/Controller?command=user" class="btn btn-success">Add
					New User</a>
			</div>
			
			User name ${u_name}, role ${role}
			
			<br>



<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Second Name</th>
						<th>Login</th>
						<th>Role</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="user" items="${usersList}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.firstname}" /></td>
							<td><c:out value="${user.lastname}" /></td>
							<td><c:out value="${user.login}" /></td>
							<td><a href="<%=request.getContextPath()%>/Controller?command=user&ex=disp&id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="<%=request.getContextPath()%>/Controller?command=user&ex=del&id=<c:out value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>

</body>
</html>