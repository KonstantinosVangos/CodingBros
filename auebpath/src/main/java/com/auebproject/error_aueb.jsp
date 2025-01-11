
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
	<head>        
    
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <meta name="author" content="sofos5@aueb.gr">
        <link rel="icon" href="<%=request.getContextPath() %>/exercise_files/images/favicon.ico">
        
        <link rel="stylesheet" href="<%=request.getContextPath() %>/exercise_files/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/exercise_files/css/bootstrap-theme.min.css">
        <link href="<%=request.getContextPath() %>/exercise_files/css/theme_8220085.css" rel="stylesheet">
        
		<meta name="description" content="2? ?t?ï¿½??? ?s??s? - error page">
<title>3rd error page</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/exercise_files/css/bootstrap-theme.min.css">
</head> 

	<body>

		<!-- Fixed navbar -->
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span> <span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">AUEB PATH</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="index_aueb.jsp">Home</a></li>
						<li><a href="login_aueb_path.jsp">Log in</a></li>	
						<li><a href="register.jsp">Create Account</a></li>
																
					</ul>
					<ul class="nav navbar-nav navbar-right">
                        <li>
							<p class="navbar-text">Signed in as USERNAME</p>
						</li>
						<li>
							<a href="logout_ex3_8220085.jsp"><span class="glyphicon glyphicon-log-out"></span> Sign out</a>
						</li>								        	
			        </ul>		
		
				</div>
				<!--/.nav-collapse -->
			</div>
		</nav>

		<div class="container theme-showcase" role="main">

			<!-- Main jumbotron for a primary marketing message or call to action -->
			<div class="jumbotron">
				<h1>3Î· Î‘Ï„Î¿Î¼Î¹ÎºÎ® Î†ÏƒÎºÎ·ÏƒÎ·</h1>
			</div>

			<!-- Page Title -->
			<div class="page-header">
				<h1>Oops something went wrong</h1>
			</div>
            
            <div class="row">

				<div class="col-xs-12">

					<h2>Description</h2>

					<% if(exception != null) { %>	                  	
						<p><code><%=exception.getMessage() %></code></p>						
					<% } %>		

				</div>

			</div> 
			
		</div>
		<!-- /container -->
        <footer class="navbar-inverse">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<p class="text-center">&copy; Made by CodingBros</p>
					</div>
				</div>
			</div>
		</footer>
<script src="<%=request.getContextPath() %>/exercise_files/js/jquery.min.js"></script>
		<!-- Bootstrap core JavaScript -->
		<script src="<%=request.getContextPath() %>/exercise_files/js/bootstrap.min.js"></script>		

	
		
	</body>
</html>


