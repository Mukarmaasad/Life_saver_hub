<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Life Saver Hub</title>
 <link href="CSS/bootstrap.min.css" rel="stylesheet">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
 
    <script type="text/javascript"  src="JS/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="JS/AddH.js"></script>
    
</head>
<body>
<header class="header">
<div class="header-content">
<img src="./img/17.jpg" alt ="Logo" class ="logo">
<h1>Life Saver Hub</h1>
<nav>
  <ul class="nav nav-tabs" id="myTab" role="tablist">
    <!-- Home Tab -->
    <li class="nav-item" role="presentation">
      <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" 
      role="tab" aria-controls="home" aria-selected="true">
        <i class="fas fa-home"></i> Home
      </button>
    </li>

    <!-- Donor List Tab -->
    <li class="nav-item" role="presentation">
      <button class="nav-link" id="donorList-tab" data-bs-toggle="tab" data-bs-target="#donorList" type="button" 
      role="tab" aria-controls="donorList" aria-selected="false">
        <i class="fas fa-users"></i> Donor List
      </button>
    </li>

    <!-- Add Hospital User Tab -->
    <li class="nav-item" role="presentation">
      <button class="nav-link" id="hospitaluser-tab" data-bs-toggle="tab" data-bs-target="#hospitaluser" type="button" 
      role="tab" aria-controls="hospitaluser" aria-selected="false">
        <i class="fas fa-hospital"></i> Add Hospital User
      </button>
    </li>

    <!-- Donor History Tab -->
    <li class="nav-item" role="presentation">
      <button class="nav-link" id="DonorHistory-tab" data-bs-toggle="tab" data-bs-target="#DonorHistory" type="button" 
      role="tab" aria-controls="DonorHistory" aria-selected="false">
        <i class="fas fa-history"></i> Donor History
      </button>
    </li>

    <!-- Blood Bank Tab -->
    <li class="nav-item" role="presentation">
      <button class="nav-link" id="Bloodbank-tab" data-bs-toggle="tab" data-bs-target="#Bloodbank" type="button" 
      role="tab" aria-controls="Bloodbank" aria-selected="false">
        <i class="fas fa-tint"></i> Blood Bank
      </button>
    </li>

    <!-- Profile Tab -->
    <li class="nav-item" role="presentation">
      <button class="nav-link" id="Profile-tab" data-bs-toggle="tab" data-bs-target="#Profile" type="button" 
      role="tab" aria-controls="Profile" aria-selected="false">
        <i class="fas fa-user"></i> Profile
      </button>
    </li>

    <!-- Dropdown for Others -->
    <li class="nav-item dropdown">
      <button class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">
        <i class="fas fa-ellipsis-h"></i> Others
      </button>
      <ul class="dropdown-menu">
        <li><a class="dropdown-item" id="Hospitals-tab" data-bs-toggle="tab" data-bs-target="#Hospitals" type="button" 
        role="tab" aria-controls="Hospitals" aria-selected="false">
          <i class="fas fa-hospital"></i> Hospitals
        </a></li>
        <li><a class="dropdown-item" id="AboutUs-tab" data-bs-toggle="tab" data-bs-target="#AboutUs" type="button" 
        role="tab" aria-controls="AboutUs" aria-selected="false">
          <i class="fas fa-info-circle"></i> About Us
        </a></li>
        <li><a class="dropdown-item" id="DonorDash-tab" data-bs-toggle="tab" data-bs-target="#DonorDash" type="button" 
        role="tab" aria-controls="DonorDash" aria-selected="false">
          <i class="fas fa-tachometer-alt"></i> Donor Dashboard
        </a></li>
        <li><hr class="dropdown-divider"></li>
      </ul>
    </li>

    <!-- Logout Button -->
    <button class="btn btn-purple" onclick="logout();"><i class="fas fa-sign-out-alt"></i> Logout</button>

  </ul>
</nav>
</div>

</header>

<div class="tab-content" id="myTabContent">
  <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
  		  	<%@include file="Firstpage.jsp" %>
  		
  </div>
  <div class="tab-pane fade" id="donorList" role="tabpanel" aria-labelledby="donorList-tab">
  	<%@include file="Donorlist.jsp" %>
  </div>
  <div class="tab-pane fade" id="registration" role="tabpanel" aria-labelledby="registration-tab">
    	<%@include file="registration.jsp" %>
  
  </div>
  
  
  
   <div class="tab-pane fade" id="hospitaluser" role="tabpanel" aria-labelledby="hospitaluser-tab">
    	<%@include file="hospitalusers.jsp" %>
  
  </div>
  
 
  <div class="tab-pane fade" id="DonorHistory" role="tabpanel" aria-labelledby="DonorHistory-tab">
    	<%@include file="DonorHistory.jsp" %>
  
  </div>
  <div class="tab-pane fade" id="Bloodbank" role="tabpanel" aria-labelledby="Bloodbank-tab">
    	<%@include file="Bloodbank.jsp" %>
  
  </div>
  <div class="tab-pane fade" id="Hospitals" role="tabpanel" aria-labelledby="Hospitals-tab">
    	<%@include file="AddHospitals.jsp" %>  
</div>

  <div class="tab-pane fade" id="AboutUs" role="tabpanel" aria-labelledby="AboutUs-tab">
    	<%@include file="Aboutus.jsp" %>  
</div>

<div class="tab-pane fade" id="Reviews" role="tabpanel" aria-labelledby="Reviews-tab">
    	<%@include file="Reviews.jsp" %>  
</div>


<div class="tab-pane fade" id="DonorDash" role="tabpanel" aria-labelledby="DonorDash-tab">
    	<%@include file="DonorDashBoard.jsp" %> 
</div>

<div class="tab-pane fade" id="Profile" role="tabpanel" aria-labelledby="Profile-tab">
    	<%@include file="Profile.jsp" %> 
</div>


</div>
     <script type="text/javascript" src="./JS/home.js"></script>

<footer style="background:#341539; color:white; padding:15px; text-align:center; ">
    <div style="margin-bottom: 10px;">
        <a href="#contact" style="color:white; margin: 0 15px;"><i class="fas fa-envelope"></i></a>
        <p style="margin:0; color:green;">CONTACT TO DONOR</p>
        <a href="#hospital" style="color:white; margin: 0 15px;"><i class="fas fa-hospital"></i></a>
        <p style="margin:0; color:green;">LIFE SAVER HUB THAT CONNECT TO DIFFRENT HOSPITAL</p>
        <a href="#bloodbank" style="color:white; margin: 0 15px;"><i class="fas fa-tint"></i></a>
        <p style="margin:0; color:green;">Blood bank available of different hospital</p>
        
        <a href="#profile" style="color:white; margin: 0 15px;"><i class="fas fa-user"></i></a>
        <p style="margin:0; color:green;">generate profile of different users</p>
        <a href="#donor-history" style="color:white;"><i class="fas fa-history"></i></a>
        <p style="margin:5px 0; color:green;">View donor history</p>
        <a href="#donor-list" style="color:white;"><i class="fas fa-list"></i></a>
        <p style="margin:5px 0; color:green;">Check donor list</p>
    </div>
    <p style="margin:0; "  >© 2024 Life Saver Hub. All Rights Reserved</p>
</footer>

</body>

</html>
    <link rel="stylesheet" href="./CSS/Home.css">

