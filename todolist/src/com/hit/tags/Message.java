package com.hit.tags;
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Message extends SimpleTagSupport {
	private String msg, status;
	
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void doTag() throws JspException, IOException {
	JspWriter out = getJspContext().getOut();	
	
		if(!msg.isEmpty()) {
			
			if(status.equals("success")) {
				out.println("<div class='alert alert-success alert-dismissible fade in'>");
				out.println("<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>×</span></button>");
				out.println("<strong>Success! </strong>" +msg);
				out.println("</div>");
			}
			
			if(status.equals("error")) {
				out.println("<div class='alert alert-danger alert-dismissible fade in'>");
				out.println("<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>×</span></button>");
				out.println("<strong>Error! </strong>" +msg);
				out.println("</div>");
			}
		}
	
	}
}
