<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form name="LoginForm" method="POST" action="Controller">
	<input type="hidden" name="command" value="Login" />
	login: <br/>
	<input type="text" name="login" value=""/>
	<br/> Password:<br/>
	<input type="password" name="password" value=""/>
	<br/>
		${errorLoginPassMessage}
	<br/>
		${wrongAction}
	<br/>
		${nullPage}
	<br/>
	<input type="submit" value="Log in"/>

</form>

</body>
</html>