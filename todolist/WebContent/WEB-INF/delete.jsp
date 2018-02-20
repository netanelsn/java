<%@page language="java" import="com.hit.model.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" errorPage="error.jsp" %>
<%@ page import ="java.util.*"%>
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
    		<h1 class="page-header">Delete Task</h1>
    		
			<form style="text-align: left" action="delete" method="post">
				<div class="form-group">
					<label for="exampleInputTitle">Title</label> 
					<input disabled="disabled" type="text" value="${item.title}" class="form-control" id="exampleInputTitle" placeholder="Title">
				</div>
				
				<div class="form-group">
				<label for="exampleInputFile">Task</label>
				<textarea disabled="disabled" class="form-control" rows="3">${item.content}</textarea>
				</div>
				<input type="hidden" name="id" value="${item.id}">
				<button type="submit" class="btn btn-default">Delete</button>
			</form>
		
    		</div>
    	</div>

    </div><!-- /.container -->

	<%@ include file = "include/javascripts.jsp" %>
	
  </body>
</html>
