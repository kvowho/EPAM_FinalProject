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

<h3 class="text-center">Invoice N ${invoice.id}</h3>
			<hr>
			<a href="Controller?command=logout">Logout</a>
			
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/Controller?command=product" class="btn btn-success">Add
					New Product</a>
			</div>
			
			User name ${u_name}, role ${role}
			
			<br>



<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Product Name</th>
						<th>Description</th>
						<th>Quantity Available</th>
						<th>Price</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="prod" items="${products}">

						<tr>
							<td><c:out value="${prod.id}" /></td>
							<td><c:out value="${prod.name}" /></td>
							<td><c:out value="${prod.quantity}" /></td>
							<td><c:out value="${prod.price}" /></td>
							<td><c:out value="${prod.total}" /></td>
							<td><a href="<%=request.getContextPath()%>/Controller?command=invoice&ex=disp&id=<c:out value='${prod.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="<%=request.getContextPath()%>/Controller?command=invoice&ex=del&id=<c:out value='${prod.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>

</body>
</html>