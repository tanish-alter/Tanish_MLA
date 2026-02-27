package com.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String usr = request.getParameter("user");
		
		String pas = request.getParameter("pwd");
		
		User obj = new User();
		
		
		String sql = "select username, password from user101 where username = '"+usr+"' and password = '"+pas+"' ";
		
		try {
		
			Connection con = DBDemo.getDbcon();
			
			Statement stmt  = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				obj.setUserName(rs.getString(1));
				obj.setPassword(rs.getString(2));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		if(usr.equals(obj.getUserName()) && pas.equals(obj.getPassword()))
		{
			RequestDispatcher rd = 
					request.getRequestDispatcher("home.html");
			rd.forward(request, response);
		}
		else
		{
			out.println("<center><font color = 'red'> invalid credentials.</font></center>");
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

}
