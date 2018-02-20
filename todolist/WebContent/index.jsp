<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@page import="javax.servlet.http.Cookie"%>

<%@ taglib uri="/WEB-INF/tlds/forms.tld" prefix="f" %>

<%
/* if cookies exists redirect to 'authenticationServlet/cookies' for authentication process */ 

Cookie cookies[] = request.getCookies();
String username = null;
String password = null;

if(cookies != null) {
	for(Cookie cookie : cookies) {
		if(cookie.getName().compareTo("username") == 0) {
			username = cookie.getValue();
		} else if(cookie.getName().compareTo("password") == 0) {
		    password = cookie.getValue();
		}
	}
}

if(username != null && password != null) {
	response.sendRedirect("authenticationServlet/cookies");
}
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ToDo List Web Application</title>
    
    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="libs/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="libs/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="libs/form-elements.css">
	<!-- Custom styles for this template -->
    <link rel="stylesheet" href="libs/style.css">

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
                            <h1><strong>ToDo List Web Application</strong></h1>
                            <div class="description">
                            	<p>This is our project in <strong>JAVA Web Application</strong>.</p>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="col-sm-5">
                        	
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
	                            
	                            	<f:login />
	                            
			                    </div>
		                    </div>
	                        
                        </div>
                        
                        <div class="col-sm-1 middle-border"></div>
                        <div class="col-sm-1"></div>
                        	
                        <div class="col-sm-5">
                        	
                        	<div class="form-box">
                        		<div class="form-top">
	                        		<div class="form-top-left">
	                        			<h3>Sign up now</h3>
	                            		<p>Fill in the form below to get instant access:</p>
	                        		</div>
	                        		<div class="form-top-right">
	                        			<i class="fa fa-pencil"></i>
	                        		</div>
	                            </div>
	                            <div class="form-bottom">
	                            
	                            	<f:register username="" firstname="" lastname="" rememberme="" />
				                    
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
    <script src="libs/js/jquery-3.2.1.min.js"></script>
    <script src="libs/bootstrap/js/bootstrap.min.js"></script>
    <script src="libs/js/jquery.backstretch.min.js"></script>
    <script src="libs/js/scripts.js"></script>
        
    <!--[if lt IE 10]>
        <script src="libs/js/placeholder.js"></script>
    <![endif]-->
  </body>
</html>
