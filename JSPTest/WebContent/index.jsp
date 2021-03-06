<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${'Welcome to javaTpoint'}"/> 
	<br> 
	<c:set var="income" scope="session" value="${400*4}"/>
	<c:if test="${income >8000 }">
		<p>My income is : <c:out value="${income}"/></p>
	</c:if>
	<br>
	<c:choose>
	<c:when test="${income<=1000}">
	<p>Income is not good</p>
	</c:when>
	<c:when test="${income<=4000}">
	<p>Income is good</p>
	</c:when>
	<c:when test="${income<=5000}">
	<p>Income is very good</p>
	</c:when>
	<c:when test="${income>10000}">
	<p>Income is very very good</p>
	</c:when>
	<c:otherwise>
	<p>Income is undetermined.</p>
	</c:otherwise>
	</c:choose>
	<br>
	<br>
	<c:set var="num" value="10"/>
	<c:choose>
	<c:when test="${num%2==0}">
	<c:out value="${num } is even number"/>
	</c:when>
	<c:otherwise>
	<c:out value="${num } is old number"/>
	</c:otherwise>
	</c:choose>
	<br>
	<c:forEach var="i" begin="1" end="10">
		Item<c:out value="${i}"></c:out>
	</c:forEach>
	<br>
	<c:remove var="income"/>
	<c:out value="After remove${income }"/>
	
	<br>
	<c:forTokens items="Min-Ko-Ko" delims="-" var="name">
		<c:out value="${name }"/>
	</c:forTokens>
	<br>
	<c:url value="/index.jsp" var="completeURL">
		<c:param name="trackingId" value="7886"/>
		<c:param name="user" value="minko"/>
		</c:url>
		${completeURL}
	<br>
	<c:catch var="catchtheException">
		<%int i=20/0; %>
	</c:catch>
	
	<c:if test="${catchtheException	!= null }">
	<p>The type of exception is : ${catchtheException }<br/>
	There is an exception: ${catchtheException.message }</p>
	</c:if>
	<!--
	<c:import var="data" url="https://www.javatpoint.com/jstl-core-import-tag"/>
	<c:out value="${data}"></c:out>
	
	_-->
</body>
</html>