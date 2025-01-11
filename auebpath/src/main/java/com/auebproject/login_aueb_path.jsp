
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="error_aueb.jsp"%>

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
<meta name="description" content="ismgroup5 - login">
<title>AUEB PATH - LG</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/exercise_files/css/bootstrap-theme.min.css">
<style>
.container {
                flex: 1; 
            }

            footer {
                background-color: #f8f9fa;
                text-align: center;
                padding: 10px 0;
                margin-top: auto; 
                border-top: 1px solid #ddd;
            }
					
			.form-signin {
				max-width: 330px;
				padding: 15px;
				margin: 0 auto;
			}
			.form-signin .form-signin-heading,
			.form-signin .checkbox {
				margin-bottom: 10px;
			}
			.form-signin .form-control {
				position: relative;
				height: auto;
				-webkit-box-sizing: border-box;
				-moz-box-sizing: border-box;
				box-sizing: border-box;
				padding: 10px;
				font-size: 16px;
			}
			.form-signin .form-control:focus {
				z-index: 2;
			}
			.form-signin input[type="text"] {
				margin-bottom: 10px;
				border-bottom-right-radius: 0;
				border-bottom-left-radius: 0;
			
			}
			.form-signin input[type="password"] {
				margin-bottom: 10px;
				border-top-left-radius: 0;
				border-top-right-radius: 0;
			}
		</style>
	</head>
	
      	
	<body>
		
		<div class="container" role="main">

            <% if(request.getAttribute("message") != null) { %>		
                <div class="alert alert-danger text-center" role="alert"><%=(String)request.getAttribute("message") %></div>
            <% } %>
    
            <form class="form-signin" method="post" action="login_auebController.jsp">
                <h2 class="form-signin-heading text-center">Please sign in</h2>
                <label for="inputusername" class="sr-only">Username</label> 
                <input type="text" name="username" id="inputusername" class="form-control" placeholder="username" required>
                <label for="inputpassword" class="sr-only">Password</label>
                <input name="password" type="password" id="inputpassword" class="form-control" placeholder="password" required>
    
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>
            <div class="alert alert-info"><strong>Help: </strong>
                    <ul>
                        <li>For Kostas Vaggos: kosvag 1111</li>
                        <li>For Marilia Markou: marmar 2222</li>
                        <li>For Iliana Chona: ilicho 3333</li>
                    </ul>
            </div>
    
        </div>
		<!-- /container --><footer class="navbar-inverse">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<p class="text-center">&copy; Made by the Codingbros </p>
					</div>
				</div>
			</div>
		</footer>
<script src="<%=request.getContextPath() %>/exercise_files/js/jquery.min.js"></script>
		<!-- Bootstrap core JavaScript -->
		<script src="<%=request.getContextPath() %>/exercise_files/js/bootstrap.min.js"></script>	

       	</body>
</html>
