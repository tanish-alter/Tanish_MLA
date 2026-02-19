package com.test;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletConfig;


//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		ServletContext ctx = getServletContext();
		
		String ct = ctx.getInitParameter("city");
		String st = ctx.getInitParameter("state");
		
		String dt = ct+ " "+st;
		
	
		
		ctx.setAttribute("info", dt);
		
		ServletConfig cfg = getServletConfig();
		
		String usr = cfg.getInitParameter("user");
		String pwd = cfg.getInitParameter("pas");
		
		out.println("config data from login servlet :" +usr + " " +pwd);
		
		out.println("ctx data from login servlet :" +dt);
		
		out.println("<br><a  href = 'Logout'>log out here</a>");
	}

}
