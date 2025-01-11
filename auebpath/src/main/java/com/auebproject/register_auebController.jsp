
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="error_aueb.jsp.jsp"%>
<%@ page import="auebproject.UserDAO" %>
<%@ page import="auebproject.User" %>
<%@ page import="java.util.ArrayList" %>
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
        
<title>AUEB PATH </title>

	</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">AUEB PATH</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="register.jsp">Register</a></li>
                <li><a href="index_aueb.jsp">Home</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container theme-showcase" role="main">

    <div class="jumbotron">
        <h1>3rd Exercise</h1>
    </div>
    <%
        // ÃŽâ€ºÃŽÂ®ÃË†ÃŽÂ· Ãâ‚¬ÃŽÂ±ÃÂÃŽÂ±ÃŽÂ¼ÃŽÂ­Ãâ€žÃÂÃâ€°ÃŽÂ½ ÃŽÂ±Ãâ‚¬ÃÅ’ Ãâ€žÃŽÂ¿ request
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm_password");
        String email = request.getParameter("email");
        String agree = request.getParameter("updates");
        ArrayList<String> error = new ArrayList<String>();


        if (name == null || name.length() < 3) {
            error.add("Name must be at least 3 characters long.");
        }
        if (surname == null || surname.length() < 3) {
            error.add("Surname must be at least 3 characters long.");
        }
        if (username == null || username.length() < 3) {
            error.add("Username must be at least 5 characters long.");
        }
        if (password == null || password.length() < 6) {
            error.add("Password must be at least 6 characters long.");
        }
        if (confirm == null || !confirm.equals(password)) {
            error.add("Password and confirm password do not match.");
        }
        if (agree == null || !agree.equals("on")) {
            error.add("You must agree to the terms and conditions.");
        }

   %>
<%

        if (error.isEmpty()) {

try { 
 UserDAO userdao = new UserDAO();
 User nuser = new User(name, surname, email, username, password);
 userdao.register(nuser);
     %>
    <div class="container theme-showcase" role="main">
        <div class="page-header">
            <h1>Registration almost done!</h1>
        </div>

        <div class="alert alert-success">
            <strong>Note:</strong> A verification link has been sent to the email: <%= email %>
        </div>
        <ul class="list-unstyled">
            <li><strong>Name:</strong> <%= name %></li>
            <li><strong>Surname:</strong> <%= surname %></li>
            <li><strong>Username:</strong> <%= username %></li>
            <li><strong>Email:</strong> <%= email %></li>
        </ul>
    </div>

    <% 
} catch(Exception e) { 
%>
<div class="container theme-showcase" role="main">
        <div class="page-header">
            <h1>Registration form has errors</h1>
        </div>
        <div class="alert alert-danger">
           <p> <%= e.getMessage() %></p> 
<li>2</li>   
        </div>
        <p>
            <a href="register.jsp" class="btn btn-primary"
               style="background-color: #5bc0de; border-color: #46b8da; color: white;">
                Back to the form
            </a>
        </p>
      </div>
 <% } 
} else {
    %>
<div class="container theme-showcase" role="main">
        <div class="page-header">
            <h1>Registration form has errors</h1>
        </div>
        <div class="alert alert-danger">
            <ol>
                <% for (String err : error) { %>
                    <li><%= err %></li>
<li>1</li>

                <% } %>
            </ol>
        </div>
        <p>
            <a href="register.jsp" class="btn btn-primary"
               style="background-color: #5bc0de; border-color: #46b8da; color: white;">
                Back to the form
            </a>
        </p>
      </div>

    <% } 
%>
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
