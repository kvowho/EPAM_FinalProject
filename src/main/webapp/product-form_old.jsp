<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Product Management Page </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Products</a></li>
			</ul>
		</nav>
	</header>
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
            			Edit User
            		</c:if>
						<c:if test="${product.id == null}">
            			Add New User
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
					<label>Product name</label> <input type="text" value="<c:out value='${product.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Product description</label> <input type="text"
						value="<c:out value='${product.description}' />" class="form-control"
						name="description">
				</fieldset>

				<fieldset class="form-group">
					<label>Quantity</label> <input type="text"
						value="<c:out value='${product.stockQuantity}' />" class="form-control"
						name="quantity">
				</fieldset>
				<fieldset class="form-group">
					<label>Price</label> <input type="text"
						value="<c:out value='${product.price}' />" class="form-control"
						name="price">
				</fieldset>
				<fieldset class="form-group">
					<label>Status</label> <input type="text"
						value="<c:out value='${product.availabilityStatus}' />" class="form-control"
						name="status">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>