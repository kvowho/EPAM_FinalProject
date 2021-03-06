<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap CSS (jsDelivr CDN) -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
  <!-- Bootstrap Bundle JS (jsDelivr CDN) -->
  <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<div>
			<a class="btn btn-primary"
				href="<%=request.getContextPath()%>/Controller?command=invoices"
				class="btn btn-success" " role="button">${iBackToInvList}</a> 
			<a class="btn btn-primary" href="Controller?command=logout"
				role="button" >${iLogout}</a> ${iYouAre}
			<c:out value="${sessionScope.user}" />
			${iYourRole}
			<c:out value="${sessionScope.role_name}" />
		</div>
		<div>
			<form method="POST" action="Controller">
				<input type="hidden" name="command" value="invoice" /> <input
					type="hidden" name="ex" value="disp" /> <input type="hidden"
					name="id" value="${invoice.id}" /> <select id="new_lang_loc"
					name="new_lang_loc" onchange="submit()">
					<option value="US" ${lang_loc == 'US' ? 'selected' : ''}>English</option>
					<option value="UA" ${lang_loc == 'UA' ? 'selected' : ''}>Ukrainian</option>
					<option value="RU" ${lang_loc == 'RU' ? 'selected' : ''}>Russian</option>
				</select>
			</form>
		</div>

		<hr>

		<h3 class="text-center">${iInvNum} ${invoice.id}</h3>

		<br>

		<form name="InvoiceUpdate" method="POST" action="Controller">
			<input type="hidden" name="command" value="invoice" />
			<input type="hidden" name="ex" value="updi" />
			<input type="hidden" name="id" value="${invoice.id}" />
			<div class="form-row align-items-center">
				<div class="col-sm-3 my-1">
					<label class="sr-only" for="status">${iStatus}</label> 
					<input type="text" class="form-control" id="status" name="status" placeholder="status" value="${invoice.status}">
				</div>
				<div class="col-sm-3 my-1">
					<label class="sr-only" for="description">${iDescription}</label>
					<div class="input-group">
						<div class="input-group-prepend">
							<div class="input-group-text">@</div>
						</div>
						<input type="text" class="form-control" id="description" name="comment" placeholder="Description" value="${invoice.comments}">
					</div>
				</div>
				<div class="col-auto my-1">
					<button type="submit" class="btn btn-primary">${iSubmit}</button>
				</div>
			</div>
		</form>

		<hr>
		<br>

		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">${iProdName}</th>
					<th scope="col">${iProdDescription}</th>
					<th scope="col">${iProdStockNum}</th>
					<th scope="col">${iProdInvNum}</th>
					<th scope="col">${iProdPriceInInv}</th>
					<th scope="col">ex</th>
				</tr>
			</thead>
			<tbody>
				<!--   for (Todo todo: todos) {  -->
				<c:forEach var="invoiceLine" items="${invoiceLines}">

					<tr>
						<td scope="row"><c:out value="${invoiceLine.product.id}" /></td>
						<td><c:out value="${invoiceLine.product.name}" /></td>
						<td><c:out value="${invoiceLine.product.description}" /></td>
						<td><c:out value="${invoiceLine.product.stockQuantity}" /></td>
							<td><form name="InvoiceLineUpdate" method="POST" action="Controller">
								<input type="hidden" name="command" value="invoice" />
								<input type="hidden" name="ex" value="updl" />
								<input type="hidden" name="id" value="${invoice.id}" />
								<input type="hidden" name="prod_id" value="${invoiceLine.product.id}" />
								<input type="text" class="form-control" id="status" name="quantity" placeholder="quantity" value="${invoiceLine.quantity}">
								<button type="submit" class="btn btn-primary">${iUpdate}</button>
							</form>
						</td>
						<td><c:out value="${invoiceLine.price}" /></td>
						<td>
						
							<c:if test="${sessionScope.role != 3}"> ${iDelete}	</c:if>
								<c:if test="${sessionScope.role == 3}"> 
								<a href="<%=request.getContextPath()%>/Controller?command=invoice&ex=dell&inv_id=<c:out value='${invoice.id}'/>&prod_id=<c:out value='${invoiceLine.product.id}'/>">${iDelete}</a>
								</c:if>

							</td>
					</tr>
				</c:forEach>
				<!-- } -->

			</tbody>
		</table>

		<div class="container text-left">
			<a
				href="<%=request.getContextPath()%>/Controller?command=invoice&ex=addl&inv_id=<c:out value='${invoice.id}' />"
				class="btn btn-success">${iAddProdToInv}</a>
		</div>

	</div>

</body>
</html>