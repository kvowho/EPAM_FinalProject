<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Bootstrap CSS (jsDelivr CDN) -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
  <!-- Bootstrap Bundle JS (jsDelivr CDN) -->
  <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<div>
			<a class="btn btn-primary"
				href="<%=request.getContextPath()%>/Controller?command=invoice&ex=disp&id=${inv_id}" class="btn btn-success" " role="button">${iBackToInvEdit}</a>
			<a class="btn btn-primary" href="Controller?command=logout"
				role="button" >${iLogout}</a> ${iYouAre}
			<c:out value="${sessionScope.user}" />
			${iYourRole}
			<c:out value="${sessionScope.role_name}" />
		</div>
		<div>
			<form method="POST" action="Controller">
		<input type="hidden" name="command" value="invoice" /> 
		<input type="hidden" name="ex" value="addl" /> 
		<input type="hidden" name="inv_id" value="${inv_id}" /> 
		<select id="new_lang_loc" name="new_lang_loc" onchange="submit()">
					<option value="US" ${lang_loc == 'US' ? 'selected' : ''}>English</option>
					<option value="UA" ${lang_loc == 'UA' ? 'selected' : ''}>Ukrainian</option>
					<option value="RU" ${lang_loc == 'RU' ? 'selected' : ''}>Russian</option>
				</select>
			</form>
		</div>

		<hr>

<h3 class="text-center">${iProdToInvAddTitle} ${inv_id}</h3>
			<hr>

			
			<br>
			
			<form name="InvoiceLineUpdate" method="POST" action="Controller">
								<input type="hidden" name="command" value="invoice" />
								<input type="hidden" name="ex" value="addl" />
								<input type="hidden" name="id" value="${inv_id}" />
								<input type="hidden" name="inv_id" value="${inv_id}" />
								<input type="text" class="form-control" id="status" name="search_word" placeholder="search_word">
								<button type="submit" class="btn btn-primary">${iSearch}</button>
							</form>



<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>${iProdName}</th>
						<th>${iProdDescription}</th>
						<th>${iProdStockNum}</th>
						<th>${iPrice}</th>
						<th>${iStatus}</th>
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
							<td><a href="<%=request.getContextPath()%>/Controller?command=invoice&ex=addl&prod_id=<c:out value='${prod.id}'/>&inv_id=<c:out value='${inv_id}' />" class="btn btn-success">${iAddProdToInv}</a></td>
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