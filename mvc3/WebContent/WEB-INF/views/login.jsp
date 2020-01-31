<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${param.message }
${param.error}
<br/>

<form:form action="login" method="post" modelAttribute="user">
	Enter user name : <form:input path="username"/><br/>
	Enter password : <form:password path="password"/><br/>
	<input type="submit">
</form:form>
</body>
</html>