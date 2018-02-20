package com.hit.tags;
import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.hit.model.Status;

public class editItem extends SimpleTagSupport {
	private long id, memberId;
	private String content, title;
	private Date dateTime;
	private Status status;
	
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
		
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void doTag() throws JspException, IOException
	{
	JspWriter out = getJspContext().getOut();	
	
	out.println("<form style='text-align: left' action='edit' method='post'>");
	
	out.println("<div class='form-group'>");
	out.println("<label for='exampleInputTitle'>Title</label>"); 
	out.println("<input type='text' name='title' value='"+title+"' class='form-control' id='exampleInputTitle' placeholder='Title'>");
	out.println("</div>");
	
	out.println("<div class='form-group'>");
	out.println("<label>Task</label>"); 
	out.println("<textarea name='content' class='form-control' rows='3'>"+content+"</textarea>");
	out.println("</div>");
	
	out.println("<div class='form-group'>");
	out.println("<label>Date Time</label>"); 
	out.println("<div class='input-group date' id='datetimepicker1'>");
	out.println("<input type='text' name='dateTime'  class='form-control' />");
	out.println("<span class='input-group-addon'><span class='glyphicon glyphicon-calendar'></span></span>");
	out.println("</div>");
	out.println("</div>");
	
	out.println("<div class='form-group'>");
	out.println("<label>Status</label>");
	out.println("<div class='radio'>");
	out.print("<label><input type='radio' name='status' value='Pending'");
	if(status == Status.Pending) {
		out.print("checked");
	}
	out.print(">Pending</label>");
	out.println("</div>");
	
	out.println("<div class='radio'>");
	out.print("<label><input type='radio' name='status' value='Completed'");
	if(status == Status.Completed) {
		out.print("checked");
	}
	out.print(">Completed</label>");
	out.println("</div>");
	
	out.println("</div>");

	out.println("<input type='hidden' name='memberId' value='"+memberId+"'>");
	out.println("<input type='hidden' name='id' value='"+id+"'>");
	out.println("<button type='submit' class='btn btn-default'>Submit</button>");
	out.println("</form>");

	}
}
