<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, auebproject.User, auebproject.UserDAO" %>
<%@ page errorPage="error_aueb.jsp"%>

<%
User user = (User) session.getAttribute("userObj2024");
           %>

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
<title>AUEB PATH</title>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD57XGKSL3GwOvmWwfYkdpy2Wt4x6cI3HU"></script>

 <script>

    function switchFields() {

      const staticField = document.getElementById("staticField");

      const dynamicField = document.getElementById("dynamicField");


      // ??a??a?? t?µ?? µeta?? t?? ped???

      const tempValue = staticField.value;

      staticField.value = dynamicField.value;

      dynamicField.value = tempValue;


      // ???a?? placeholder st? d??aµ??? ped??

      if (!dynamicField.value) {

        dynamicField.placeholder = "FILL THE GAP";

      }

    }


    function initAutocomplete() {

      const staticField = document.getElementById("staticField");

      const dynamicField = document.getElementById("dynamicField");


      // ??e???p???s? a?t?µat?? s?µp????s??

      new google.maps.places.Autocomplete(staticField);

      new google.maps.places.Autocomplete(dynamicField);

    }


    function getCoordinates(event) {

      event.preventDefault();

      const dynamicField = document.getElementById("dynamicField").value;


      const geocoder = new google.maps.Geocoder();

      geocoder.geocode({ address: dynamicField }, function (results, status) {

        if (status === "OK") {

          const location = results[0].geometry.location;

          alert("S??teta?µ??e?: " + location.lat() + ", " + location.lng());

        } else {

          alert("Sf??µa: " + status);

        }

      });

    }


    window.onload = initAutocomplete;

  </script>
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
														
						<li class="active"><a href="whereto.jsp">About</a></li>
														
					</ul>
					<ul class="nav navbar-nav navbar-right">
					     <li>
							<p class="navbar-text">Signed in as <%= user.getUsername()%></p>
						</li>
						<li>
							<a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Sign out</a>
						</li>									        	
			        </ul>		
		
				</div>
				<!--/.nav-collapse -->
			</div>
		</nav>
  <div class="container theme-showcase" role="main">

			<!-- Main jumbotron for a primary marketing message or call to action -->
			<div class="jumbotron">
				<h1>Move easily & fast !</h1>
			</div>
			
		
     <form class="form-horizontal" ">
 
    	<div class="container">

    <form id="travelForm" onsubmit="getCoordinates(event)">

      <div class="input-group">

        <label for="staticField">STARTING POINT</label>

        <input type="text" id="staticField" name="staticField" value="AUEB">

        <button type="button" class="switch-button" onclick="switchFields()">></button>

      </div>


      <div class="input-group">

        <label for="dynamicField">DESTINATION</label>

        <input type="text" id="dynamicField" name="dynamicField" placeholder="FILL THE GAP" required>

      </div>


      <button type="submit" class="submit-btn">LET'S GO!</button>

    </form>
</div>
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
