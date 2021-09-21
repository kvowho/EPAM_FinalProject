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
			<a class="btn btn-primary" href="<%=request.getContextPath()%>/Controller?command=products" class="btn btn-success" " role="button">${iBackToProdList}</a>
			<a class="btn btn-primary" href="Controller?command=logout" role="button" aria-disabled="false">${iLogout}</a> ${iYouAre}
			<c:out value="${sessionScope.user}" />
			${iYourRole}
			<c:out value="${sessionScope.role}" />
		</div>
		<div>
			<form method="POST" action="Controller">
		<input type="hidden" name="command" value="product"/>
		<input type="hidden" name="ex" value="disp" /> 
		<input type="hidden" name="id" value="${product.id}" />
		<select	id="new_lang_loc" name="new_lang_loc" onchange="submit()">
					<option value="US" ${lang_loc == 'US' ? 'selected' : ''}>English</option>
					<option value="UA" ${lang_loc == 'UA' ? 'selected' : ''}>Ukrainian</option>
					<option value="RU" ${lang_loc == 'RU' ? 'selected' : ''}>Russian</option>
				</select>
			</form>
		</div>

		<hr>

	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${product.id != null}">
					<form action="<%=request.getContextPath()%>/Controller?command=product&ex=upd" method="post">
				</c:if>
				<c:if test="${product.id == null}">
					<form action="<%=request.getContextPath()%>/Controller?command=product" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${product.id != null}">
            			${iProdEdit}
            		</c:if>
						<c:if test="${product.id == null}">
            			${iProdAdd}
            		</c:if>
					</h2>
				</caption>

				<c:if test="${product.id != null}">
					<input type="hidden" name="id" value="<c:out value='${product.id}' />" />
				</c:if>
				<c:if test="${product.id == null}">
					<input type="hidden" name="id" value="0" />
				</c:if>

				<fieldset class="form-group">
					<label>${iProdName}</label> <input type="text" value="<c:out value='${product.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>${iProdDescription}</label> <input type="text"
						value="<c:out value='${product.description}' />" class="form-control"
						name="description">
				</fieldset>

				<fieldset class="form-group">
					<label>${iProdStockNum}</label> <input type="text"
						value="<c:out value='${product.stockQuantity}' />" class="form-control"
						name="quantity">
				</fieldset>
				<fieldset class="form-group">
					<label>${iPrice}</label> <input type="text"
						value="<c:out value='${product.price}' />" class="form-control"
						name="price">
				</fieldset>
				<fieldset class="form-group">
					<label>${iStatus}</label> <input type="text"
						value="<c:out value='${product.availabilityStatus}' />" class="form-control"
						name="status">
				</fieldset>

				<button type="submit" class="btn btn-success">${iSubmit}</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>