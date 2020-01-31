<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Welcome ${user.username }!

<br/>
<a href="logout">logout</a>
<br/>
<br/>
<br/>
<table border="1">
	<thead>
		<tr>
			<th>book id</th>
			<th>isbn</th>
			<th>title</th>
			<th>author</th>
			<th>price</th>
			<th>pub date</th>
			<th>publisher</th>
			<th>pub email</th>
			<c:if test="${user.profile == 'mgr'}">
			<th>delete</th>
			<th>update</th>
			</c:if>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.id}</td>
				<td>${book.isbn}</td>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
				<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${book.pubDate}" /></td>
				<td>${book.publisher}</td>
				<td>${book.pubEmail}</td>
				<c:if test="${user.profile == 'mgr'}">
				<td><a href="deletebook?id=${book.id}">delete</a></td>
				<td><a href="updatebook?id=${book.id}">update</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br/>
<br/>
<c:if test="${user.profile == 'mgr'}">
<a href="addbook">addbook</a>
</c:if>
</body>
</html>