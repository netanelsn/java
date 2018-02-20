<%@page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" errorPage="error.jsp" %>
<%@ taglib uri="/WEB-INF/tlds/message.tld" prefix="m" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="refresh" content="<%=session.getMaxInactiveInterval() %>; url=/todolist/" />
    
    <%@ include file = "include/stylesheets.jsp" %>
   
  </head>

  <body>

    <%@ include file = "include/header.jsp" %>

    <div class="container-fluid">
    	<div class="row">
    		<%@ include file = "include/sidebar.jsp" %>
    		
    		
    		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    		<h1 class="page-header">Active Sessions</h1>
    		
    		
			<m:message msg="${param.message}" status="${param.status}" />
			
			
    		
    		<div class="panel panel-default panel-table">
    		  <div class="panel-heading">
                <div class="row">
                  <div class="col col-xs-12">
                    <h3 class="panel-title"><%= "number of active sessions: " + ((Set)application.getAttribute("sessions")).size() %></h3>
                  </div>
                </div>
              </div>
              <div class="panel-body">
                <table class="table table-striped table-bordered table-list">
                  <thead>
                    <tr>
                        <th class="hidden-xs">Member ID</th>
                        <th>Username</th>
                        <th>Creation Time</th>
                        <th>Session ID</th>
                        <th>Action</th>
                    </tr> 
                  </thead>
                  <tbody>
                  
                  <%
		    		  //Traversing elements  
		    		  Iterator<HttpSession> itr=((Set)application.getAttribute("sessions")).iterator();  
		    		  while(itr.hasNext()){  
		    			  HttpSession ses = itr.next();
		    			  out.println("<tr>");
		    			  out.println("<td>"+ ses.getAttribute("member_id") +"</td>");
		    			  out.println("<td>"+ ses.getAttribute("username") +"</td>");
		    			  out.println("<td>"+ ses.getCreationTime() +"</td>");
		    			  out.println("<td>"+ ses.getId() +"</td>");
		    			  out.println("<td><a href='invalidate?id="+ses.getId()+"' class='btn btn-danger' data-toggle='tooltip' title='Invalidate'>Invalidate</a></td>");
		    			  out.println("</tr>");
		    		  }  
		    		%>
	                  
                        
                  </tbody>
                </table>
            
              </div>
              
              <div class="panel-footer">   
					Loading time: ${loadingTime} seconds
				</div>
              
    		</div>    
    		
    		</div>
    	</div>

    </div><!-- /.container -->


    <%@ include file = "include/javascripts.jsp" %>
  </body>
</html>
