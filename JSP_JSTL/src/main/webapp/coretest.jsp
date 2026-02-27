<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<c:set var="age" value="${19}" scope="session"></c:set>
		
		<!-- 
		<c:out value="${age}" />
		
		<c:if test="${age > 18}">
			<c:out value=", age is valid"></c:out>
		</c:if>
		 -->
		
		<c:choose>
			<c:when test="${age >= 18}">
				<c:out value = "eligible for Voter ID"></c:out>
			</c:when>
			<c:otherwise>
				<c:out value= "not eligible"></c:out>
			</c:otherwise>
		</c:choose>
		
		<br>
		
		<c:forEach var="dt" begin="1" end="10">
		
			<c:out value ="${dt}"></c:out>
			
		</c:forEach>
		
	</body>
</html>