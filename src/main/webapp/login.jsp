<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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