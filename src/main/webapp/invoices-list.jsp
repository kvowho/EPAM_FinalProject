<%@ page pageEncoding="UTF-8" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
 <fmt:setLocale value="${language}" />
 <fmt:setBundle basename="com.example.i18n.text" />
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form>
             <select id="language" name="language" onchange="submit()">
                 <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                 <option value="nl" ${language == 'nl' ? 'selected' : ''}>Nederlands</option>
                 <option value="es" ${language == 'es' ? 'selected' : ''}>Español</option>
             </select>
         </form>

<h3 class="text-center">Invoices List</h3>

<label for="username"><fmt:message key="login.label.username" />:</label>
			<hr>
			<a href="Controller?command=logout">Logout</a>
			
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/Controller?command=invoice&ex=new" class="btn btn-success">Add New Invoice</a>
			</div>
			
			<c:out value="${sessionScope.role}"/>
			<c:out value="${sessionScope.user}"/>
			
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
							<td><a href="<%=request.getContextPath()%>/Controller?command=invoice&ex=disp&id=<c:out value='${invoice.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="<%=request.getContextPath()%>/Controller?command=invoice&ex=del&id=<c:out value='${invoice.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>

</body>
</html>