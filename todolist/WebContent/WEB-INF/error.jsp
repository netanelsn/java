<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" isErrorPage="true" %>
<%@ page import ="java.util.*"%>
<%@ taglib uri="/WEB-INF/tlds/message.tld" prefix="m" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    
    <%@ include file = "include/stylesheets.jsp" %>
   
  </head>

  <body>

    <%@ include file = "include/header.jsp" %>

    <div class="container-fluid">
    	<div class="row">
    		
    		
    		<div class="col-sm-12 main">
    		<h1 class="page-header">Sorry an exception occured!</h1>
    		
    		
			<p>Exception is: <%= exception %></p>

    		
    		</div>
    	</div>

    </div><!-- /.container -->


    <%@ include file = "include/javascripts.jsp" %>
  </body>
</html>
