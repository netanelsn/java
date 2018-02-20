<%@page language="java" import="com.hit.model.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp" session="true" %>
<%@ page import ="java.util.*"%>
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
    		<h1 class="page-header">Dashboard</h1>
    		
    		
			<m:message msg="${param.message}" status="${param.status}" />
			
			
    		<div class="panel panel-default panel-table">
    		  <div class="panel-heading">
                <div class="row">
                  <div class="col col-xs-6">
                    <h3 class="panel-title">Todo list</h3>
                  </div>
                  <div class="col col-xs-6 text-right">
                    <a href="create" class="btn btn-primary btn-sm btn-create">Create New Task</a>
                  </div>
                </div>
              </div>
              <div class="panel-body">
                <table class="table table-striped table-bordered table-list">
                  <thead>
                    <tr>
                        <th>Title</th>
                        <th>Task</th>
                        <th>Deadline</th>
                        <th>Status</th>
                        <th class="text-center"><span class="glyphicon glyphicon-cog"></span></th>
                    </tr> 
                  </thead>
                  <tbody>
                  <%  
                  
              	 for(Item item : (List<Item>)request.getAttribute("items")) { %> 
              	 <!-- create an html table row -->
               	 <tr>
              	 	<!-- create cells of row -->
              	 	<td><%=item.getTitle()%></td>
              	 	<td><%=item.getContent()%></td>
              	 	<td><%=item.getDateTime()%></td>
              	 	<td><%=item.getStatus()%></td>
              	 	<td align="center">
              	 		<a href="edit?id=<%=item.getId()%>" class="btn btn-default" data-toggle="tooltip" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
    					<a href="delete?id=<%=item.getId()%>" class="btn btn-danger" data-toggle="tooltip" title="Delete"><span class="glyphicon glyphicon-trash"></span></a>
    				</td>
              	 	<!-- close row -->
              	 </tr>
              	 <!-- close the loop -->
              <% } %>
                        
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
