<%@page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" errorPage="error.jsp" %>
<%@ taglib uri="/WEB-INF/tlds/message.tld" prefix="m" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<meta http-equiv="refresh" content="<%=session.getMaxInactiveInterval() %>; url=/todolist/" />
    
    <%@ include file = "include/stylesheets.jsp" %>
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/libs/bootstrap-datetimepicker.css" />
  </head>

  <body>

    <%@ include file = "include/header.jsp" %>
    
    <div class="container-fluid">
    	<div class="row">
    		<%@ include file = "include/sidebar.jsp" %>
    		
    		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    		<h1 class="page-header">Create New Task</h1>
    		
    		<m:message msg="${errorMsg}" status="${status}" />
    		
    		<form style="text-align: left" action="create" method="post">
				<div class="form-group">
					<label for="exampleInputTitle">Title</label> 
					<input type="text" name="title" class="form-control" id="exampleInputTitle" placeholder="Title">
				</div>
				
				<div class="form-group">
					<label for="exampleInputFile">Task</label>
					<textarea name="task" class="form-control" rows="3"></textarea>
				</div>
				
				<div class="form-group">
					<label for="exampleInputFile">Deadline</label>
	                <div class='input-group date' id='datetimepicker1'>
	                    <input type='text' name="dateTime" class="form-control" />
	                    <span class="input-group-addon">
	                        <span class="glyphicon glyphicon-calendar"></span>
	                    </span>
	                </div>
	            </div>
	            
				<button type="submit" class="btn btn-default">Submit</button>
			</form>    
    		
    		</div>
    	</div>

    </div><!-- /.container -->


    <%@ include file = "include/javascripts.jsp" %>
    <script src="<%=request.getContextPath()%>/libs/js/bootstrap-datetimepicker.js"></script>
    
    <script type="text/javascript">
	$(function () {
    	$('#datetimepicker1').datetimepicker();
	});
	</script>
  </body>
</html>
