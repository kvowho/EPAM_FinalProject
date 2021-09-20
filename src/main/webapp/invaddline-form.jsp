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

<h3 class="text-center">Product List</h3>
			<hr>
			<a href="Controller?command=logout">Logout</a>
			
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/Controller?command=product" class="btn btn-success">Add
					Product to the invoice ${inv_id} / ${id}</a>
			</div>
			
			User name ${u_name}, role ${role}
			
			<br>
			
			<form name="InvoiceLineUpdate" method="POST" action="Controller">
								<input type="hidden" name="command" value="invoice" />
								<input type="hidden" name="ex" value="addl" />
								<input type="hidden" name="id" value="${inv_id}" />
								<input type="text" class="form-control" id="status" name="search_word" placeholder="search_word">
								<button type="submit" class="btn btn-primary">Search</button>
							</form>



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
					<c:forEach var="prod" items="${productList}">

						<tr>
							<td><c:out value="${prod.id}" /></td>
							<td><c:out value="${prod.name}" /></td>
							<td><c:out value="${prod.description}" /></td>
							<td><c:out value="${prod.stockQuantity}" /></td>
							<td><c:out value="${prod.price}" /></td>
							<td><c:out value="${prod.availabilityStatus}" /></td>
							<td><a href="<%=request.getContextPath()%>/Controller?command=invoice&ex=addl&prod_id=<c:out value='${prod.id}'/>&inv_id=<c:out value='${inv_id}'/>">Add to invoice</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>

	<table border="1" cellpadding="5" cellspacing="5">
		<tr>
			<c:forEach begin="1" end="${noOfPages}" var="i">
				<c:choose>
					<c:when test="${currentPage eq i}">
						<td>${i}</td>
					</c:when>
					<c:otherwise>
						<td><a href="Controller?command=invoice&ex=addl&inv_id=${inv_id}&currentPage=${i}">${i}</a></td>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</tr>
	</table>

</body>
</html>