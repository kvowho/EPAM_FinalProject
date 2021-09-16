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

				<a href="<%=request.getContextPath()%>/Controller?command=invoice&ex=addl&inv_id=<c:out value='${invoice.id}' />" class="btn btn-success">Add product to invoice</a>
			</div>
			
			<c:out value="${sessionScope.role}"/>
			<c:out value="${sessionScope.user}"/>
			
			<br>



<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Product Name</th>
						<th>Description</th>
						<th>Quantity available</th>
						<th>Quantity in invoice</th>
						<th>Price in invoice</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="invoiceLine" items="${invoiceLines}">

						<tr>
							<td><c:out value="${invoiceLine.product.id}"/></td>
							<td><c:out value="${invoiceLine.product.name}"/></td>
							<td><c:out value="${invoiceLine.product.description}"/></td>
							<td><c:out value="${invoiceLine.product.stockQuantity}"/></td>
							<td><c:out value="${invoiceLine.quantity}"/></td>
							<td><c:out value="${invoiceLine.price}"/></td>
							<td><a href="<%=request.getContextPath()%>/Controller?command=invoice&ex=disp&id=<c:out value='${invoice.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="<%=request.getContextPath()%>/Controller?command=invoice&ex=del&inv_id=<c:out value='${invoice.id}'/>&prod_id=<c:out value='${invoiceLine.product.id}'/>">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>

</body>
</html>