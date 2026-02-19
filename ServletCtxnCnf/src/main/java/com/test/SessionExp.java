package com.test;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/MyFilter")
public class SessionExp extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SessionExp() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String usr = request.getParameter("user");
		
		System.out.println("From login servlet......");
		
		//Cookie ck = new Cookie("info", usr);
		
		//response.addCookie(ck);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("info", usr);
		
		ServletContext ctx = getServletContext();
		
		int t = (int)ctx.getAttribute("tusers");
		int c = (int)ctx.getAttribute("cusers");
		
		out.println("From Login page : "+ usr);
		
		out.println("<br>Total users : " +t);
		out.println("<br>Current users : " +c);
		
		
		out.println("<br> <a href = 'Logout1'>Logout here</a>");
		
		
		
	}

}
