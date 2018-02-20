package com.hit.tags;
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class login extends SimpleTagSupport {
	
	public void doTag() throws JspException, IOException
	{
		
	JspWriter out = getJspContext().getOut();	

	out.println("<form role='form' action='/todolist/authenticationServlet/login' method='post' class='login-form'>");
	out.println("<div class='form-group'>");
	out.println("<div class='input-group'>");
	out.println("<div class='input-group-addon'><i class='fa fa-user'></i></div>");
	out.println("<label class='sr-only' for='username'>Username</label>");
	out.println("<input type='text' name='username' placeholder='Username' class='username form-control' id='username'>");
	out.println("</div>");
	out.println("</div>");
	out.println("<div class='form-group'>");
	out.println("<div class='input-group'>");
	out.println("<div class='input-group-addon'><i class='fa fa-lock'></i></div>");
	out.println("<label class='sr-only' for='password'>Password</label>");
	out.println("<input type='password' name='password' placeholder='Password' class='password form-control' id='password'>");
	out.println("</div>");
	out.println("</div>");
	out.println("<div class='checkbox'>");
	out.println("<label class='custom-control custom-checkbox'>");
	out.println("<input type='checkbox' name='remember' value='true' class='custom-control-input' style='display: none;'>");
	out.println("<span class='custom-control-indicator'></span>");
	out.println("</label>");
	out.println("Remember me");
	out.println("</div>");
	out.println("<button type='submit' class='btn'>Sign in!</button>");
	out.println("</form>");

		
	}
}
