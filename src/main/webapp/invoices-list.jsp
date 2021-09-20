<%@ page pageEncoding="UTF-8" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
 <fmt:setLocale value="${language}" />
 <fmt:setBundle basename="com.example.i18n.text" />
 
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
			<a class="btn btn-primary disabled" href="Controller?command=logout"
				role="button" aria-disabled="false">${iLogout}</a> ${iYouAre}
			<c:out value="${sessionScope.user}" />
			${iYourRole}
			<c:out value="${sessionScope.role}" />
		</div>
		<div>
			<form method="POST" action="Controller">
		<input type="hidden" name="command" value="invoices" /> 
		<select	id="new_lang_loc" name="new_lang_loc" onchange="submit()">
					<option value="US" ${lang_loc == 'US' ? 'selected' : ''}>English</option>
					<option value="UA" ${lang_loc == 'UA' ? 'selected' : ''}>Ukrainian</option>
					<option value="RU" ${lang_loc == 'RU' ? 'selected' : ''}>Russian</option>
				</select>
			</form>
		</div>

		<hr>

	<h3 class="text-center">${iInvoiceList}</h3>

			<hr>
			
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/Controller?command=invoice&ex=new" class="btn btn-success">${iAddInv}</a>
			</div>
			

			<br>



<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>${iStatus}</th>
						<th>${iComments}</th>
						<th>${iCreated}</th>
						<th>${iTotalAmount}</th>
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
							<td></td>
							<td><a href="<%=request.getContextPath()%>/Controller?command=invoice&ex=disp&id=<c:out value='${invoice.id}' />">${iEdit}</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="<%=request.getContextPath()%>/Controller?command=invoice&ex=deli&id=<c:out value='${invoice.id}' />">${iDelete}</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>

</body>
</html>