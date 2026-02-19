<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>JSP TAGS FORWARD SUCCESS...</h1>
	
	<h3>SESSIoN TRACKING.</h3>
	
	<%
	
		String usr = (String)session.getAttribute("info");
		
		out.println("USER FORM SUCCESS PAGE : " +usr);
	
	%>

</body>
</html>