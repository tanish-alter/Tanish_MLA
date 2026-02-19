<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <center>
        <h1>USER DATA</h1>

        <%
            String usr = request.getParameter("user");
            String pas = request.getParameter("pwd");

            if (usr.equals("admin") && pas.equals("java")) {
        %>
                <jsp:forward page="success.jsp"/></jsp:forward>
        <%
            } else {
                out.println("Invalid Credentials");
        %>
                <jsp:forward page="userform.jsp"/>
        <%
            }
        %>
    </center>
</body>
</html>