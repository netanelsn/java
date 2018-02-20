<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="/WEB-INF/tlds/message.tld" prefix="m" %>
<%@ taglib uri="/WEB-INF/tlds/forms.tld" prefix="f" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dashboard Template for Bootstrap</title>
    
    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/libs/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/libs/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/libs/form-elements.css">
	<!-- Custom styles for this template -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/libs/style.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
        
  </head>

  <body>
	<!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                	
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><a href="/application/"><strong>ToDo List Web Application</strong></a></h1>
                            <div class="description">
                            	<p>This is our project in <strong>JAVA Web Application</strong>.</p>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3">
                        	
                        	<div class="form-box">
	                        	<div class="form-top">
	                        		<div class="form-top-left">
	                        			<h3>Login to our site</h3>
	                            		<p>Enter username and password to log on:</p>
	                        		</div>
	                        		<div class="form-top-right">
	                        			<i class="fa fa-lock"></i>
	                        		</div>
	                            </div>
	                            <div class="form-bottom">
	                            
	                            <m:message msg="${errorMsg}" status="error" />
	                            
	                            <f:login />
	                            
			                    </div>
		                    </div>
		                
                        </div>
                        
                    </div>
                    
                </div>
            </div>
            
        </div>

        <!-- Footer -->
        <footer>
        	<div class="container">
        		<div class="row">
        			
        			<div class="col-sm-8 col-sm-offset-2">
        				<div class="footer-border"></div>
        				<p>Made by Netanel snir & Shoval oren at <a href="http://hit.ac.il" target="_blank"><strong>HIT</strong></a> <i class="fa fa-smile-o"></i></p>
        			</div>
        			
        		</div>
        	</div>
        </footer>


    <!-- Javascript -->
    <script src="<%=request.getContextPath()%>/libs/js/jquery-3.2.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/libs/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/libs/js/jquery.backstretch.min.js"></script>
    <script src="<%=request.getContextPath()%>/libs/js/scripts.js"></script>
        
    <!--[if lt IE 10]>
        <script src="<%=request.getContextPath()%>/libs/js/placeholder.js"></script>
    <![endif]-->
  </body>
</html>
