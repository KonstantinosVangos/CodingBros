

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="error_aueb.jsp" %>

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
        
<meta name="description" content="Lab exercise template 2019-2020">
<title>AUEB PATH</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/exercise_files/css/bootstrap-theme.min.css">
<style>
        .alert-custom {
            background-color:#FFF4E6; /* ÃŽâ€˜ÃŽÂ½ÃŽÂ¿ÃŽÂ¹Ãâ€¡Ãâ€žÃÅ’ ÃŽÂ¼Ãâ‚¬ÃŽÂµÃŽÂ¶ */
            color: #5D4037; /* ÃŽÂ£ÃŽÂºÃŽÂ¿ÃÂÃÂÃŽÂ¿ ÃŽÂºÃŽÂ±Ãâ€ ÃŽÂ­ */
            border: 2px solid #FFF4E6; /* ÃŽÅ¡ÃÅ’ÃŽÂºÃŽÂºÃŽÂ¹ÃŽÂ½ÃŽÂ¿ */
            font-weight: bold; /* ÃŽË†ÃŽÂ½Ãâ€žÃŽÂ¿ÃŽÂ½ÃŽÂ¿ ÃŽÂºÃŽÂµÃŽÂ¯ÃŽÂ¼ÃŽÂµÃŽÂ½ÃŽÂ¿ */
		text-align: center;
        }
 .checkbox {
            color: #00008B; /* Dark Blue */
            font-weight: bold;
        }
    </style>
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
						<li class="active"><a href="register.jsp">Register</a></li>					
						<li><a href="index_aueb.jsp">Home</a></li>					
					</ul>		
		
				</div>
				<!--/.nav-collapse -->
			</div>
		</nav>

		<div class="container theme-showcase" role="main">

			<!-- Main jumbotron for a primary marketing message or call to action -->
			<div class="jumbotron">
				<h1>Become a member!</h1>
			</div>

			<!-- Page Title -->
			<div class="page-header">
				<h1>Registation Form</h1>
			</div>
			
		</div>
  		<div class="alert alert-custom" role="alert">
            		<strong></strong> Please fill in the following form to create an account.
        	</div> 
		<div class="container mt-4">

     <form class="form-horizontal" action="register_auebController.jsp" method="post">
 
    	<!-- Name -->
   	 <div class="form-group">
       	 <label for="name" class="col-sm-2 control-label">Name</label>
      	  <div class="col-sm-10">
      	      <input type="text" class="form-control" id="name" name="name" placeholder="Name">
     	   </div>
   	 </div>

    	<!-- Surname -->
    	<div class="form-group">
        	<label for="surname" class="col-sm-2 control-label">Surname</label>
        	<div class="col-sm-10">
            	<input type="text" class="form-control" id="surname" name="surname" placeholder="Surname">
   	    	 </div>
   	 </div>

  	  <!-- Email -->
   	 <div class="form-group">
      	  <label for="email" class="col-sm-2 control-label">Email</label>
      	  <div class="col-sm-10">
           	 <input type="email" class="form-control" id="email" name="email" placeholder="Email">
      	  </div>
   	 </div>
	<!-- Username -->
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">Username</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="username"  name="username" placeholder="Your username">
                </div>
            </div>

            <!-- Password -->
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">Password</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password"  name="password" placeholder="Your password">
                </div>
            </div>

            <!-- Confirm Password -->
            <div class="form-group">
                <label for="confirm_password" class="col-sm-2 control-label">Confirm</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="confirm_password"  name="confirm_password" placeholder="Confirm your password">
                </div>
            </div>

    <!-- agree to the terms -->
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <div class="checkbox">
                <label>
                    <input type="checkbox" id="updates" name="updates" > I agree to the terms and conditions  </label>
            </div>
        </div>
    </div>
    <!-- Submit and Cancel Buttons -->
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <!-- Submit Button -->
            <button type="submit" class="btn btn-success">
                 <span class="glyphicon glyphicon-ok"></span> Submit
            </button>
            <!-- Cancel Button -->
            <button type="button" class="btn btn-danger">
                 <span class="glyphicon glyphicon-remove"></span> Cancel
            </button>
        </div>
    </div>
</form>
</div>
</div>

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
