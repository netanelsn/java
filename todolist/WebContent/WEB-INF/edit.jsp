<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" errorPage="error.jsp" %>
<%@ page import ="com.hit.model.*"%>
<%@ taglib uri="/WEB-INF/tlds/message.tld" prefix="m" %>
<%@ taglib uri="/WEB-INF/tlds/item_form.tld" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<meta http-equiv="refresh" content="<%=session.getMaxInactiveInterval() %>; url=/todolist/" />
    
    <%@ include file = "include/stylesheets.jsp" %>
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/libs/bootstrap-datetimepicker.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/libs/form-checkbox.css">
  </head>

  <body>

    <%@ include file = "include/header.jsp" %>
    
    <div class="container-fluid">
    	<div class="row">
    		<%@ include file = "include/sidebar.jsp" %>
    		
    		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    		<h1 class="page-header">Delete Task</h1>
    		<m:message msg="${errorMsg}" status="${status}" />
    		
			
    		<c:editform 
	    		id="${item.id}" 
	    		memberId="${item.userId}" 
	    		title="${item.title}" 
	    		content="${item.content}" 
	    		dateTime="${item.dateTime}"
	    		status="${item.status}" />
	    		
	    		
						
    		</div>
    	</div>

    </div><!-- /.container -->

	<%@ include file = "include/javascripts.jsp" %>
	
    <script src="<%=request.getContextPath()%>/libs/js/bootstrap-datetimepicker.js"></script>
    
    <script type="text/javascript">
	$(function () {
    	$('#datetimepicker1').datetimepicker({
    		defaultDate: "${item.dateTime}"
    	});
	});
	</script>
  </body>
</html>
