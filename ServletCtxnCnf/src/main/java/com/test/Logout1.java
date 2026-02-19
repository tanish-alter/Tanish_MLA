package com.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;



@WebServlet("/Logout1")
public class Logout1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Logout1() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
	
		//Cookie[] ck = request.getCookies();
		
		//out.println("from logout page : " + ck[0].getValue());
		
		HttpSession session = request.getSession();
		
		String data = (String)session.getAttribute("info");
		
		out.println("from logout servlet:" + data);
		
		session.invalidate();
		
	}
	

}
