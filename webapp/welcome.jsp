<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<!-- Custom CSS to Increase Text Size -->
<style>
  /* Increase the size of navbar links */
  .navbar-nav > li > a, .dropdown-toggle {
    font-size: 22px; 
  }

  /* Adjust dropdown menu link size */
  .dropdown-menu > li > a {
    font-size: 20px;
    padding: 15px 25px; 
  }

  /* Optional: Adjust dropdown width */
  .dropdown-menu {
    min-width: 240px;
  }
</style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- First Dropdown Menu -->
    <ul class="nav navbar-nav">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Details
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="studentdetails.jsp">Student Details</a></li>
          <li><a href="teachersdetails.jsp">Teacher Details</a></li>
          <li><a href="subjectdetails.jsp">Subject Details</a></li>
        </ul>
      </li>
      
      <!-- Second Dropdown Menu -->
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">More Details
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Class Details</a></li>
          <li><a href="#">Exam Details</a></li>
          <li><a href="#">Result Details</a></li>
        </ul>
      </li>

      <!-- Third Dropdown Menu -->
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Admin Details
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Admin Info</a></li>
          <li><a href="#">Staff Management</a></li>
          <li><a href="#">Reports</a></li>
        </ul>
      </li>
    </ul>
  </div>
</nav>

</body>
</html>
