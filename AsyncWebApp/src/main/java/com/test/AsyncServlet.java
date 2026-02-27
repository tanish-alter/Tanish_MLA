package com.test;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.AsyncEvent;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns="/AsyncServlet",asyncSupported = true)
public class AsyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final long startTime = System.nanoTime();
	
		final AsyncContext asyncContext = request.startAsync(request,response);
		
		new Thread() {
			@Override
			public void run() {
				
				try {
					ServletResponse response = asyncContext.getResponse();
					response.setContentType("text/plain");
					PrintWriter out = response.getWriter();
					Thread.sleep(3500);
					out.println("Work completed time elapsed : " + (System.nanoTime()-startTime));
					out.flush();
					
					asyncContext.complete();
					
				}
				
				catch(Exception e){
					
					e.printStackTrace();
					
				}
				
			}
		}.start();
	
	}

}
