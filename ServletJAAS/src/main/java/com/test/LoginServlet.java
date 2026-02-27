package com.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.security.auth.login.LoginContext;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.setProperty("java.security.auth.login.config", 
				getServletContext().getRealPath("/WEB-INF/jaas.config"));
		
		try
		{
			LoginContext lc = 
					new LoginContext("SimpleLogin", new SimpleCallBackHandler(username, password));
			
			lc.login();
			
			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("subject", lc.getSubject());
			
			response.sendRedirect("welcome.jsp");
		}
		catch(Exception e)
		{
			response.getWriter().println("Authentication failed : "+e.getMessage());
		}
	}

}
