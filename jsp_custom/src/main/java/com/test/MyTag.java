package com.test;

import java.util.Date;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.TagSupport;

public class MyTag extends TagSupport {
	
	private static final long serialVersionUID = 1L;
	
	public int doStartTag() {
		
		JspWriter out = null;
		
		try {
			out = pageContext.getOut();
			
			out.println("JSP CUSTOM TAG :" + new Date());
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}

}
// SKIP_BODY is a part of TagSupport Class

