

<style>

body {
background: linear-gradient(135deg, #6e7dff, #ff9f9f, #D1C4E9, #fff,black); /* Gradient background */

}

        /* Card Container */
        .card-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            max-width: 1200px;
            padding: 20px;
        }

        /* Card Styling */
        .card {
            width: 300px;
            height: 400px;
            border-radius: 15px;
            overflow: hidden;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2); /* Enhanced shadow */
            transition: all 0.3s ease;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }

        /* Card 1: Multiple Shades of Blue */
        .card-1 {
            background: linear-gradient(135deg, #6e7dff, #5c6bc0, #3f51b5);
        }

        /* Card 2: Multiple Shades of Red */
        .card-2 {
            background: linear-gradient(135deg, #ff9f9f, #ff6f6f, #d32f2f);
        }

        /* Card 3: Multiple Shades of Green */
        .card-3 {
            background: linear-gradient(135deg, #66bb6a, #43a047, #388e3c);
        }

        .card:hover {
            transform: translateY(-10px); /* Hover effect */
            box-shadow: 0 12px 30px rgba(0, 0, 0, 0.25); /* Stronger shadow on hover */
        }

        .card img {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }

        .card-title {
            font-size: 1.5rem;
            font-weight: bold;
            padding: 15px;
            text-align: center;
            color: #fff;
        }

        .card-description {
            padding: 10px 15px;
            font-size: 1rem;
            color: #fff;
            flex-grow: 1;
        }

        .card-footer {
            background-color: #fff;
            color: #333;
            padding: 10px;
            text-align: center;
            font-size: 1.2rem;
            border-radius: 0 0 15px 15px;
        }

        /* Button Styling */
        .card-footer button {
            background-color: #ff6f6f;
            border: none;
            padding: 10px 20px;
            font-size: 1rem;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        
        * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Segoe UI', sans-serif;
}

/* html, body {
    height: 100%;
    background: #f8f9fa;
} */

.hero {
    height: 60vh;
    background: linear-gradient(to left, #e63946, #f1faee );
    clip-path: polygon(0 0, 100% 0, 100% 85%, 0 100%);
    display: flex;
    align-items: center;
    justify-content: left;
    color: white;
    position: relative;
     left-margin:100px;
      gap: 100px; /* adds space between image and text */
       z-index: 1; /* Ensure hero section stays behind the navbar */
}

.hero-container {
    max-width: 600px;
    padding: 40px;
    background: #1d3557;
    border-radius: 30px 5px 30px 5px;
    box-shadow: 0 15px 30px rgba(0, 0, 0, 0.4);
    transform: perspective(1200px) rotateX(3deg);
     z-index: 1; /* Keep it below the navbar */
}

.text-box {
    text-align: center;
}

.main-title {
    font-size: 3rem;
    font-weight: 800; /* Corrected from 80px to 800 */
    margin-bottom: 20px;
    color: #f1faee;
}


.subtext {
    font-size: 1.4rem;
    margin-bottom: 30px;
    color: #a8dadc;
}

.donate-button {
    padding: 15px 35px;
    background: #e63946;
    color: white;
    text-decoration: none;
    font-size: 1.1rem;
    font-weight: bold;
    border-radius: 10px;
    box-shadow: 0 10px 15px rgba(0, 0, 0, 0.3);
    transition: background 0.3s, transform 0.3s;
}

.donate-button:hover {
    background: #c1121f;
    transform: scale(1.05);
}
    
    
    .hero-left {
    flex: 1;
    position: relative;
    background: url('https://images.unsplash.com/photo-1588776814546-ec07b23b0bd8?auto=format&fit=crop&w=1050&q=80') center center/cover no-repeat;
    display: flex;
    align-items: flex-end;
    justify-content: center;
    padding: 30px;
      z-index: 1; /* Keep it below the navbar */
}

.left-text {
    background-color: rgba(0, 0, 0, 0.5);
    color: #f1faee;
    padding: 15px 25px;
    border-radius: 10px;
    font-size: 1.1rem;
    text-align: center;
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.4);
      z-index: 1; /* Keep it below the navbar */
}
        

.hero-flex {
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 50px 20px;
  background-color: #D1C4E9;
  flex-wrap: wrap; /* Makes it responsive */
  gap: 30px;
}

.hero-img img {
  max-width: 1000px;
  width: 100%;
  height:100%;
  border-radius: 20px;
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
   display: flex;
}

.hero-text {
  max-width: 500px;
  color: #341539;
}

.hero-text h2 {
  font-size: 2rem;
  margin-bottom: 10px;
}
.animate-text {
  opacity: 0;
  transform: translateX(-50px);
  animation: slideIn 1s ease-out forwards;
}

.animate-text.delay {
  animation-delay: 0.5s;
}

@keyframes slideIn {
  to {
    opacity: 1;
    transform: translateX(0);
  }
  .hero-right {
  max-width: 500px;
}

.text-box {
  text-align: left;
}

}
.slide-in-right {
  opacity: 0;
  transform: translateX(50px);
  animation: slideRightFade 1.2s ease-out forwards;
}

@keyframes slideRightFade {
  to {
    opacity: 1;
    transform: translateX(0);
  }
}

.heros-container {
    background-color: transparent; /* Light transparent white */
    padding: 80px;
    border: 8px solid black;
    border-radius: 15px;
    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);
    /* You can adjust the transparency with the last value (0 to 1) */
}

.heross-container {
    background-color: transparent; /* Light transparent white */
    padding: 60px;
    border-radius: 15px;
    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.5);
    /* You can adjust the transparency with the last value (0 to 1) */
    color: blue; /* if text needs to contrast */
	  text-align: center;
	  font-size:20px;
  font-weight: 400;
}
.home-background {
  background-image: url('./img/homepic.png');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  height: 80vh;
  display: flex;
  justify-content: center;
  align-items: center;
  color: blue; /* if text needs to contrast */
  text-align: center;
  font-size:20px;
  
}
.overlay-content h2{
color: black; /* if text needs to contrast */
  text-align: center;
  font-size:60px;
  font-weight: 800; /* or 900 for maximum boldness */
  
}

    .simple-container {
      background: linear-gradient(to right,  blue,white, black);
	  background-size: cover;
	  background-position: center;
      border: 1px solid #ddd;
      border-radius: 8px;
      padding: 20px;
      max-width: 690px;
      height: 300px;
      margin: 0 auto;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      display: flex;
      align-items: center;
      justify-content: space-between;
    }
    .mycontainer{
     margin-left:0px;
    }
	.simple-container img {
	     width: 300px;
	  height: 300px;
	  border: 0px solid #ddd;
	  border-radius: 8px;
	  padding: 10px;
	  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	  object-fit: cover;
	       margin-left:0px;
	  
	    }
	.simple-container p {
	      font-size: 20px;
	      color: #333;
	      margin: 0;
	    }
		   .row-container {
		  display: flex;
		  justify-content: space-between;
		  align-items: flex-start;
		  max-width: 1000px;
		  margin: auto;
		  gap: 20px; 
		    
		}
		
		.right-container {
		  flex: 1;
		  padding: 20px;
		  background-color: transparent;
		  border-radius: 8px;
		  		    border: 3px solid red; /* You can change 'red' to any color */
		  
		  
		}
	.heros-right {
	  flex: 1;
	  background: linear-gradient(135deg, #e63946, #1d3557);
	  display: flex;
	  justify-content: center;
	  align-items: center;
	  padding: 40px;
	}ign-items: center;
	}


  
</style>


<body>
<!-- About Us Section -->
   
        <div class="home-text">
        <br><br>
        
        <div class="home-background">
        
  <div class="overlay-content">
  <center><img src="./img/ayyat.png" style="background: transparent;" alt="Team Member 1" class="team-img"></center>
  
     <strong><h2>Welcome to Life Saver Hub</h2></strong><br>
     
    <h3 class="animate-text"></h3>
  <p class="animate-text delay">
  
   
    <b>We aim to make the blood donation process easier, faster, and more efficient.<br>
    Our platform connects blood donors, hospitals, and patients, ensuring that blood is available when needed the most. <br>
    By simplifying registration, tracking blood stock, and providing quick access to potential donors, we help save lives.<br>
    Our mission is to improve the accessibility and availability of blood through technology,<br> while also raising awareness about the importance of donation. 
    Join us in making a difference and saving lives.</b>
  </p>
  </div>
  </div>
</div>
<br><br>
           <!-- best services --> 
            <!-- service 1 --> 
          
           
		<h2 style="font-size: 40px; font-weight: 800;">Our Best Services</h2>
		 <div class="row-container">
		         <div class="simple-container">
		         <img src="./img/s1.png"><h2 style="font-size: 60px; font-weight: 900; color:red; padding: 60px;">01<br><p>Blood Donation</p></h2>
		         </div>
		         <div class="right-container"><br>
			    <p><i>"To donate blood, please first update your information in your donor profile. After donating blood, 
			    kindly update your donation status as well. You will be eligible to donate again after 3 months."</i>
			    </p>
			  </div>
		         </div>
		         <br>
		         
		      <!-- service 2 --> 
		      		 <div class="row-container">
		      		 <div class="right-container">
			    <p><i>"Find the required blood type along with location from the donor list and contact the donor.
			     This is a simple and effective way to quickly arrange a blood donation for your patient."</i></p>
			  </div>
		       <div class="mycontainer">
		        <div class="simple-container"><br>
		         <h2 style="font-size: 60px; font-weight: 900; color:red; padding: 60px;">02<br><p>Donor Contact</p></h2>
		         <img src="./img/s22.png">
		         </div>
		         </div>
		         </div>
		         <br>
		         
		         
		         <!-- service 3 --> 
		         <div class="row-container">
		         <div class="simple-container"><br>
		         <img src="./img/Donor.png"><h2 style="font-size: 60px; font-weight: 900; color:red; padding: 60px;">03<br><p>Donation History</p></h2>
		         </div>
		         <div class="right-container">
			    <p><i>"When you update your status in your profile, your donation history will be generated automatically.
			     Once you fill out the required information, you'll be able to view your complete history,
			      including when and at which hospital you donated blood."</i> </p>
			  </div>
		         </div>
		         <br>
     
           <!-- step 1 --> 
    <section class="hero">
    <div class="hero-img">
    <img src="./img/main.png" alt="Main Image" />
  </div>
 
         
        <div><p>               </p></div>
        
        
    <div class="hero-right slide-in-right">
        <div class="hero-container">
            <div class="text-box">
                <h1 class="main-title">Donate Blood, Save Lives</h1>
                <p class="subtext">Every drop counts. Be someone's hero today.</p>
               <a href="#profile-tab" class="donate-button">Become a Donor</a>

            </div>
        </div>
        </div>
    </section>
    <div class="heross-container">
    <i><p>  <b>Healthy Blood</b> :<br><b>Before donating</b>, basic health checks (blood pressure, hemoglobin, etc.) are done, which can help detect hidden health issues early.<br>
    Make sure to eat a healthy meal and stay well hydrated by drinking plenty of water. Avoid fatty foods, 
    as they can affect the blood test results. Bring a valid ID and be well rested. During the donation, relax, breathe normally, 
    and follow the staff instructions.<br> <b>After donating</b>, rest for a few minutes, drink fluids, and eat a light snack.
     Avoid heavy exercise for the rest of the day and monitor how you feel if you feel dizzy, lie down until it passes.After donating blood, 
     its important to rest for 10 to 15 minutes and drink plenty of fluids to help replenish lost fluids. Eat a light snack provided at the
      donation center to maintain energy levels. Avoid strenuous physical activity or heavy lifting for at least 24 hours. Keep the bandage on for
       a few hours and avoid using that arm for heavy tasks. If you feel dizzy or lightheaded, sit or lie down until it passes.
      Continue drinking water throughout the day and eat iron-rich foods like spinach or meat to help your body recover quickly.</p></i></div>
    <br>
    
    <video width="640" height="360" controls>
  <source src="./vedio/3191572-uhd_3840_2160_25fps.mp4" type="video/mp4">

</video>
    <div class="heros-right slide-in-left">
        <div class="heros-container">
            <div class="text-box">
                <h1 class="main-title">Call Now : 0331 4629463</h1>
                <p class="subtext"> Contact us to connect your hospital's blood bank with our platform.</p>
              

            </div>
        </div>
        </div>
        <link rel="stylesheet" href="./CSS/SectionDesign.css">
        <center>
        		<h2 style="font-size: 40px; font-weight: 800; color:#341539">Check Out Information</h2>
        
        <div class="card-container">
        <!-- Card 1 -->
        <div class="card card-1">
            <img src="./img/profile.png" alt="Card Image">
            <div class="card-title">Profile</div>
            <div class="card-description">
			<p style="font-weight: bold; color: #ffe600; font-size: 1.0rem; margin-top: 20px;">
			    Genrate the profile and update your donor information in your profile.
			</p>            </div>
           
        </div>

        <!-- Card 2 -->
        <div class="card card-2">
            <img src="./img/list.png" alt="Card Image">
            <div class="card-title">Donor List</div>
            <div class="card-description">
				<p style="font-weight: bold; color: #ffe600; font-size: 1.0rem; margin-top: 20px;">
You are now registered as a donor and have been added to the donor list. Your contribution can help save lives by supporting those in need of blood.			
				</p>            </div>
				           
        </div>

        <!-- Card 3 -->
        <div class="card card-3">
            <img src="./img/donordash.png" alt="Card Image">
            <div class="card-title">Donor Dashboard</div>
            <div class="card-description">
<p style="font-weight: bold; color: #ffe600; font-size: 1.0rem; margin-top: 20px;">
Create Automatically dash board of people register as donor show in this ky kitna people add howy hein as a donor with blood group 
</p>            </div>
            
        </div>
    </div>

      
        
    </body>
    </center>