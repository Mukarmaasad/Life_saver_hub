<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<link rel="stylesheet" href="./CSS/index.css">
  <script type="text/javascript" src="./JS/Signup.js"></script>

<style>
    /* Background image for the body */
    .main {
        background-image: url('./img/rt.png');
        background-size: cover; /* Ensure the image covers the entire page */
        background-position: center; /* Center the image */
        background-repeat: no-repeat; /* Prevent the image from repeating */
    }
     body {
background: linear-gradient(135deg, #6e7dff, #ff9f9f, #D1C4E9, #fff,black); /* Gradient background */

}
</style>
</head>
<body>

<header class="header">
<div class="header-content">
<img src="./img/17.jpg" alt ="Logo" class ="logo">
<b><center><h1>Life Saver Hub</h1></center></b>
</div>

</header>


<div class="container">

<div class="main">
 <div class="loginsignup">
<div>
<label>sign up</label>
<input type="text" id="firstname" name="fir" placeholder="First name" requried="">
<input type="text" id="lastname" name="last" placeholder="Last name" requried="">
<input type="email" id="Semail" name="email" placeholder="Email" requried="">
<input type="password" id="Spassword" name="pass" placeholder="Passsword" requried="">
</div>

<button onClick="Signup();">Sign up</button>

</div>
</div>
</div> 
    <p><b>If you  have an account, click <a href="index.jsp">Back to Login</a> and Login your account.</b></p>

<footer><center>© 2024 Life Saver Hub.All Right Reseverd</center></footer>

</body>
</html>