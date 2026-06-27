<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            background-color: #f5f7fa;
            color: #333;
        }
        .arrow-container {
      width: 1200px;
      height: 250px;
      background-color: #4CAF50;
      color: white;
      font-family: Arial, sans-serif;
      font-size: 18px;
      padding: 20px;
      clip-path: polygon(0 0, 85% 0, 100% 50%, 85% 100%, 0 100%);
      display: flex;
      align-items: center;
      justify-content: center;
      text-align: center;
      margin: 50px;
      border: 3px solid red; /* You can change 'red' to any color */
      
    }
    .circle {
      width: 100px;
      height: 100px;
      background-color: #3498db;
      color: white;
      font-size: 40px;
      font-weight: bold;
      border-radius: 50%;
      display: flex;
      align-items: center;
      justify-content: center;
      font-family: Arial, sans-serif;
      margin: 50px;
 		border: solid white; /* You can change 'red' to any color */
      
    }

        html {
            box-sizing: border-box;
        }

        *, *:before, *:after {
            box-sizing: inherit;
        }

        /* Team Section Styling */
        h2 {
            text-align: center;
            font-size: 2.5em;
            margin-top: 20px;
            color: black;
        }

        .team-row {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 30px;
  padding: 20px;
}

.card {
  width: 300px; /* Set fixed width for 3-in-a-row layout */
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0 4px 10px rgba(0,0,0,0.1);
  background-color: #D1C4E9;
  transition: transform 0.3s ease;
 border:5px solid green; /* You can change 'red' to any color */
  
}

.card:hover {
  transform: scale(1.05);
}

.card img {
  width: 100%;
  height: 200px;
  object-fit: cover;
}

.container {
  padding: 25px;
  text-align: center;
}
.team-img {
    width: 800px;  /* Adjust the width */
    height: 100px;  /* Maintain aspect ratio */
    border-radius: 10px;  /* Rounded corners */
    box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);  /* Shadow around image */
    transition: transform 0.3s ease;  /* Smooth transition for scaling effect */
}

.team-img:hover {
    transform: scale(1.1);  /* Slightly enlarge the image on hover */
}

.about-background{
     background-image: url('./img/s1.png');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  height: 50vh;
  display: flex;
  justify-content: center;
  align-items: center;
  color: blue; /* if text needs to contrast */
  text-align: center;
  font-size:20px;
    }
          


        .container h2 {
            font-size: 1.8em;
            color:white;
            margin-bottom: 10px;
        }

        .title {
            font-size: 1.2em;
            color:white;
            margin-bottom: 10px;
        }

        .button:hover {
            background-color: #d84b3d;
        }

        /* Responsive Design */
        @media screen and (max-width: 768px) {
            .row {
                flex-direction: column;
                align-items: center;
            }

            .left-container, .right-container {
                width: 100%; /* Make both containers full width on smaller screens */
            }
        }

        @media screen and (max-width: 480px) {
            .about-section h1 {
                font-size: 2em;
            }
video {
  border: 3px solid #333;
  border-radius: 10px;
  box-shadow: 0 4px 10px rgba(0,0,0,0.2);
  display: block;
  margin: 30px auto;
}
            .about-section p {
                font-size: 1em;
            }
            
        }

       
    </style>
</head>
<body>

    <!-- About Us Section -->
  
      
      <div class="home-text">
        <br><br>
        
        <div class="about-background">
  <div class="overlay-content">
     <strong><h2>About Us</h2></strong><br>
     
    <h3 class="animate-text"></h3>
  <p class="animate-text delay">
  
   <center><img src="./img/ayyat.png" alt="Team Member 1" class="team-img"></center>
   
    <b>We aim to make the blood donation process easier, faster, and more efficient.<br>
    Join us in making a difference and saving lives.</b>
  </p>
  </div>
  </div>
</div>  
        

<br><br>
<center>
<video width="640" height="360" controls>
  <source src="./vedio/2.mp4" type="video/mp4">
</video>
</center>
       <div class="arrow-container">
       
			<div class="circle">1</div><i>The Life Saver Hub platform has been created to make it easier for people in need. <br>It allows seekers to 
			connect with donors.<br> After donating blood, a donor can update their status,<br> and their donation history is automatically recorded. 
			This platform is also connected with hospital blood banks,<br>
			 so that different hospitals can stay linked. If any hospital needs blood, <br>it can contact another 
 hospital and easily get the required blood</i>  </div>
<div  class="team-row">
<!-- Team Member 1 -->
  <div class="card">
    <img src="./img/Hospital.png" alt="Team Member 1">
    <div class="container">
      <h2>Help people </h2>
      <p>provide blood through simple and easy way . We are obligated to help those in need.</p>
    </div>
  </div>

  <!-- Team Member 2 -->
  <div class="card">
    <img src="./img/Rood.png" alt="Team Member 2">
    <div class="container">
      <h2>Blood is provided free of cost</h2>
      <p>Our aim is solely to help people in emergency cases because this issue has become very serious blood is often not arranged on time, and the patient ends up losing their life</p>
    </div>
  </div>

  <!-- Team Member 3 -->
  <div class="card">
    <img src="./img/Heart.png" alt="Team Member 3">
    <div class="container">
      <h2>Blood Bank</h2>
      <p> A blood bank is a facility where blood  are collected, typed, stored, and distributed for use in transfusions and medical treatments. 
      </p>
    </div>
  </div>
</div>
<div class="arrow-container">
			<div class="circle">2</div><i>Life Saver Hub is a dedicated platform designed to connect blood donors with those in urgent need.
			 <br>Our mission is to make the blood donation process simple, efficient, and accessible for everyone.
			<br> Behind this platform is a passionate team of developers and coordinators who work together to ensure <br>that every request is met quickly and reliably.
			 Our team is committed to<br> saving lives by strengthening the bridge between donors, patients, and hospitals."
</i>  </div>
 <!-- Our Team Section -->


<div class="team-row">

  

  <!-- Team Member 4 -->
  <div class="card">
    <img src="./img/emer.png" alt="Team Member 4">
    <div class="container">
      <h2>Team Member 4</h2>
      <p>Details about Team Member 4</p>
    </div>
  </div>

  <!-- Team Member 5 -->
  <div class="card">
    <img src="./img/nycbs_blood.jpg" alt="Team Member 5">
    <div class="container">
      <h2>Team Member 5</h2>
      <p>Details about Team Member 5</p>
    </div>
  </div>

  <!-- Team Member 7 -->
  <div class="card">
    <img src="./img/Bank.png" alt="Team Member 7">
    <div class="container">
      <h2>Team Member 6</h2>
      <p>Details about Team Member 7</p>
    </div>
  </div>

</div>



</body>
</html>
