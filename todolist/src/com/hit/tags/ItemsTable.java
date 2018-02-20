package com.hit.tags;
import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.hit.model.Item;

public class ItemsTable extends SimpleTagSupport {
	private List<Item> items;
	
	
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public void doTag() throws JspException, IOException
	{
	JspWriter out = getJspContext().getOut();	
	
	
	
	out.println("<table class='table table-striped table-bordered table-list'>");
	out.println("<thead>");
	out.println("<tr>");
	out.println("<th class='hidden-xs'>ID</th>");
	out.println("<th>Title</th>");
	out.println("<th>Task</th>");
	out.println("<th>Date</th>");
	out.println("<th>Status</th>");
	out.println("<th class='text-center'><span class='glyphicon glyphicon-cog'></span></th>");
	out.println("</tr>"); 
	out.println("</thead>");
	
	
	out.println("<tbody>");
      
	for(Item item : items) { 
		out.println("<td>"+item.getId()+"</td>"); 
		out.println("<td>"+item.getContent()+"</td>");
		out.println("<td>"+item.getTitle()+"</td>");
		out.println("<td>"+item.getDateTime()+"</td>");
		out.println("<td>"+item.getStatus()+"</td>");
		out.println("<td align='center'>"
				+ "<a href='edit?id="+item.getId()+" class='btn btn-default' data-toggle='tooltip' title='Edit'>"
						+ "<span class='glyphicon glyphicon-pencil'></span>"
				+ "</a>"
				+ "<a href='delete?id="+item.getId()+"' class='btn btn-danger' data-toggle='tooltip' title='Delete'>"
						+ "<span class='glyphicon glyphicon-trash'></span>"
				+ "</a>" 
				+ "</td>");
		out.println("</tr>");
	}
	
	out.println("</tbody>");
	out.println("</table>");
	
	}
}
