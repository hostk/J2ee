<%@ include file="/WEB-INF/view/common/include.jsp"%>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" action="${pageContext.request.contextPath}/register.htm" modelAttribute="userDTO">
User Name:<form:input path="userName" type="text"/><br>
Password: <form:password path="password" /><br>
Role :	<form:select path="roleId">
<form:options items="${roleList}" itemLabel="roleName" itemValue="id"/>
</form:select>
<input type="submit" value="Submit" />
</form:form>
</body>
</html>