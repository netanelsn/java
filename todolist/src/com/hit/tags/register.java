package com.hit.tags;
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class register extends SimpleTagSupport {
	private String username;
	private String firstname;
	private String lastname;
	private String rememberme;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setRememberme(String rememberme) {
		if(rememberme.equals("true")) {
			this.rememberme = "checked";
		} else {
			rememberme = "";
		}
	}
	
	public void doTag() throws JspException, IOException
	{
		
	JspWriter out = getJspContext().getOut();	
	
	out.println("<form role='form' action='/todolist/authenticationServlet/register' method='post' class='registration-form'>");
	out.println("<div class='form-group'>");
	out.println("<div class='input-group'>");
	out.println("<div class='input-group-addon'><i class='fa fa-user'></i></div>");
	out.println("<label class='sr-only' for='username'>Username</label>");
	out.println("<input type='text' name='username' value='"+username+"' placeholder='Username' class='username form-control' id='username'>");
	out.println("</div>");
	out.println("</div>");
	out.println("<div class='form-group'>");
	out.println("<div class='input-group'>");
	out.println("<div class='input-group-addon'><i class='fa fa-lock'></i></div>");
	out.println("<label class='sr-only' for='password'>Password</label>");
	out.println("<input type='password' name='password' placeholder='Password' class='password form-control' id='password'>");
	out.println("</div>");
	out.println("</div>");
	out.println("<div class='form-group'>");
	out.println("<label class='sr-only' for='firstname'>First name</label>");
	out.println("<input type='text' name='firstname' value='"+firstname+"' placeholder='First name' class='firstname form-control' id='firstname'>");
	out.println("</div>");
	out.println("<div class='form-group'>");
	out.println("<label class='sr-only' for='lastname'>Last name</label>");
	out.println("<input type='text' name='lastname' value='"+lastname+"' placeholder='Last name' class='lastname form-control' id='lastname'>");
	out.println("</div>");
	out.println("<div class='checkbox'>");
	out.println("<label class='custom-control custom-checkbox'>");
	out.println("<input type='checkbox' name='remember' value='true' class='custom-control-input' style='display: none;' "+rememberme+">");
	out.println("<span class='custom-control-indicator'></span>");
	out.println("</label>");
	out.println("Remember me");
	out.println("</div>");
	out.println("<button type='submit' class='btn'>Sign me up!</button>");
	out.println("</form>");
		
	}
}
