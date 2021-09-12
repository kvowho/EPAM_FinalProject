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
				<a href="https://www.javaguides.net" class="navbar-brand"> User Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user.id != null}">
					<form action="<%=request.getContextPath()%>/Controller?command=user&ex=upd" method="post">
				</c:if>
				<c:if test="${user.id == null}">
					<form action="<%=request.getContextPath()%>/Controller?command=user" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user.id != null}">
            			Edit User
            		</c:if>
						<c:if test="${user.id == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user.id != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>
				<c:if test="${user.id == null}">
					<input type="hidden" name="id" value="0" />
				</c:if>

				<fieldset class="form-group">
					<label>First name</label> <input type="text" value="<c:out value='${user.firstname}' />" class="form-control"
						name="firstname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Second name</label> <input type="text"
						value="<c:out value='${user.lastname}' />" class="form-control"
						name="lastname">
				</fieldset>

				<fieldset class="form-group">
					<label>Login</label> <input type="text"
						value="<c:out value='${user.login}' />" class="form-control"
						name="login">
				</fieldset>
				<fieldset class="form-group">
					<label>Password</label> <input type="text"
						value="<c:out value='${user.password}' />" class="form-control"
						name="password">
				</fieldset>
				<fieldset class="form-group">
					<label>Role</label> <input type="text"
						value="<c:out value='${user.role}' />" class="form-control"
						name="role">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>