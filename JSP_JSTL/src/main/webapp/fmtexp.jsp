<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date Time Format</title>
</head>
<body>

	<c:set var="cdate" value="<%= new Date()%>"></c:set>
	<c:out value="${cdate}"></c:out>
	
	<h3>
		Time:<fmt:formatDate type="time" value="${cdate}"/>
	</h3>

	<h3>
		Date:<fmt:formatDate type="date" value="${cdate}"/>
	</h3>
	
	<h3>
		Date & Time:<fmt:formatDate type="both" value="${cdate}"/>
	</h3>
	
	<h3>
		Short-Time:<fmt:formatDate type="both" dateStyle="short" value="${cdate}"/>
	</h3>
	
	<h3>
		Medium-Time:<fmt:formatDate type="both" dateStyle="medium" value="${cdate}"/>
	</h3>
	
	<h3>
		Long-Time:<fmt:formatDate type="both" dateStyle="long" value="${cdate}"/>
	</h3>
	
	<h3>
		Date-pattern:<fmt:formatDate pattern="yyyy-MM-dd" value="${cdate}"/>
	</h3>
</body>
</html>