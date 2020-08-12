<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
      <%@ page import="java.io.*,java.sql.*,java.util.*" %>
      <%@ page import="ems.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="DAO" method="post">
<input type="text" name="input">
<input type="submit" name="btn" value="Retrieve">
</form>
<ol>
<c:forEach var="table" items="${list}">
<li><p>${table.name}</p>
<ol>
<c:forEach var="ans" items="${table.answerList }">
<li><input type="checkbox" name="${ans.id}"/>${ans.name}</li>
</c:forEach>
</ol>
</li>
</c:forEach>
</ol>
</body>
</html>