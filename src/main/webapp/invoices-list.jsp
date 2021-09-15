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

<h3 class="text-center">Invoices List</h3>
			<hr>
			<a href="Controller?command=logout">Logout</a>
			
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/Controller?command=invoice&ex=new" class="btn btn-success">Add New Invoice</a>
			</div>
			
			User name ${u_name}, role ${role}
			
			<br>



<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Status</th>
						<th>Comments</th>
						<th>Created</th>
						<th>Total amount</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="invoice" items="${invoiceList}">

						<tr>
							<td><c:out value="${invoice.id}" /></td>
							<td><c:out value="${invoice.status}" /></td>
							<td><c:out value="${invoice.comments}" /></td>
							<td><c:out value="${invoice.date}" /></td>
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