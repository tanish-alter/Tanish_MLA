<%@page import="java.security.Principal"%>
<%@page import="java.util.Set"%>
<%@page import="javax.security.auth.Subject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	Subject subject = (Subject)session.getAttribute("subject");
    	
    	Set<Principal> principals = subject.getPrincipals();
    	
    	String username = (String)session.getAttribute("username");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome</title>
</head>
<body>
		<h1>Welcome...<%= username %></h1>
			
			<p>Your roles</p>
			
			<ul>
				<%
					for(Principal p : principals)
					{
						if(p.getName().equals(username))
						{
							out.println("<li>"+p.getName()+"</li>");
						}
					}
				%>
			</ul>
		
</body>
</html>