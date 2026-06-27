<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
 <link rel="stylesheet" href="./CSS/index.css">
 
 <script type="text/javascript" src="./JS/login.js"></script>
 
 <script type="text/javascript">
        // Check if the error message is set and display an alert
        <% if (request.getAttribute("error") != null) { %>
            alert('<%= request.getAttribute("error") %>');
        <% } %>
    </script>
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
<header class="header">
<div class="header-content">
<img src="./img/17.jpg" alt ="Logo" class ="logo">
<h1>Life Saver Hub</h1>
</div>

</header>
<body>

<div><p>The Life Saver Hub is a simple, user friendly and efficient platform that makes the blood donation process easier.<br>
  It helps connect blood donors, seekers, and blood banks to ensure blood is available when needed</p></div>

<div class="container">

<div class="main">
<!-- <input type="checkbox" id="chk" aria-hidden="true">
 -->
<div>

<div class="loginsignup">
<label>Login</label>

<input type ="email" id="email" name="email" placeholder="Email" >
<input type ="password" id="password" name="password" placeholder="Password" required="" >
<div class ="remember-forget">
<!-- <center><a href="#">Forget password?</a></center>
 --></div>
<button onClick="login();">Log in </button>

</div>
</div>

</div>
</div> 

    <p><b>If you don't have an account, click <a href="signup.jsp">Signup</a> and Create new account.</b></p>
<footer><center>© 2024 Life Saver Hub.All Right Reseverd</center></footer>
</body>
</html>
    