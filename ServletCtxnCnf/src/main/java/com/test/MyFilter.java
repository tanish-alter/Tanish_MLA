package com.test;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;


@WebFilter("/SeesionExp")
public class MyFilter extends HttpFilter {
       
    
    public MyFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		System.out.println("destroy");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("BEFORE SERVLET PRE FILTER");
		
		chain.doFilter(request, response);
		System.out.println("AFTER SERVLET POST FILTER......");
		

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init ()");
	}

}
