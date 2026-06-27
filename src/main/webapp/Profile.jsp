<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>
        <h1>Userprofile</h1>
        
        
        
        <div class="home-text">
        
        <div class="profile-background">
  <div class="overlay-content">
     <strong><h2>Profile</h2></strong><br>
     
    <h3 class="animate-text"></h3>
  <p class="animate-text delay">
  
   
    <b> ...................</b>
  </p>
  </div>
  </div>
</div>
        
        
          <div class="row align-items-center">
		   <div class="col"> 
		<div  class="form-container">
		<div id="profile">
        <h3 style="color:green;"><i> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Profile</i></h3>
                            
        
        <p><strong>First Name:</strong> <span id="userFirstName"></span></p>
        <p><strong>Last Name:</strong> <span id="userLastName"></span></p>
        <p><strong>Email:</strong> <span id="userEmail"></span></p>
        <p><strong>Date of Birth:</strong> <span id="userDOB"></span></p>
        <p><strong>Phone Number:</strong> <span id="userPhoneNo"></span></p>
        <p><strong>City:</strong> <span id="userCity"></span></p>
        <p><strong>Address:</strong> <span id="userAddress"></span></p>
        <p><strong>Blood Group:</strong> <span id="userBloodGroup"></span></p>
        <p><strong>Gender:</strong> <span id="userGender"></span></p>
        <p><strong>Status:</strong> <span id="userStatus"></span></p>
    	<p><strong>Donation Date:</strong> <span id="userDonationDate"></span></p>
   
   
  <button id="donateBtn" type="button" onclick="setuserid('${user.userId}');" class="btn btn-purple" data-bs-toggle="modal" data-bs-target="#donorModal" ${isDisabled}>
  Donor</button>

	<button id="donatedButton" class="btn btn-red" >Donated</button>
	<p id="donateText" style="display: none;"><b>After 3 months donate</b></p>
	
   </div></div>
   </div>
   
       <div class="col"><div class="errow-container"><i><b>Register Now</b></i>
       </div>
       </div>
   
    <div class="col">
    <button type="button" class="btn btn-purple" data-bs-toggle="modal" data-bs-target="#registrationModal">
      Update Donor Detail
    </button>
    <br>
    <p><i>Update your at least one time<br> detail as a Donor </i></p>
</div>
   
   
    <div class="modal fade" id="donorModal" tabindex="-1" aria-labelledby="donorModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="donorModalLabel">Donor Details</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
       
               <img src="./img/DH.png" alt="Donation Banner" style="width: 450px; height: 200px; border-radius: 8px;" />
       
       
        <div class="mb-3">
          <label for="quantityInput" class="form-label">Quantity</label>
          <input type="text" class="form-control" id="quantityInput" placeholder="Enter units of blood">
        </div>

        <!-- Hospital ID Dropdown -->
        <div class="mb-3">
          <label for="DropdownofHospitals" class="form-label">Hospital ID</label>
          <select class="form-select" id="DropdownofHospitals">
            <!-- Options will be populated dynamically -->
          </select>
        </div>
        
        

        <!-- Additional fields -->
        <div id="donorInfo">
          <!-- Donor Info will be populated dynamically -->
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-purple" data-bs-dismiss="modal">Close</button>
                  <button class="btn btn-purple" onclick="Donate();">Donate</button>
      </div>
    </div>
  </div>
</div>
    
</div>



<!-- 🧾 Modal -->
<div class="modal fade" id="registrationModal" tabindex="-1" aria-labelledby="registrationModal" aria-hidden="true">
  <div class="modal-dialog modal-lg modal-dialog-centered">
    <div class="modal-content">
    
      <div class="modal-header">
        <h5 class="modal-title" id="registrationModal">Donor Registration</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      
      <div class="modal-body">
       
       

        <img src="./img/Home.png" alt="Donation Banner" style="width: 400px; height: 200px; border-radius: 8px;" />
<br>
        <label for="dateofbirth" class="form-label">Date Of Birth</label>
        <input type="Date" id="dateOfBirth" class="form-control" name="DOB" placeholder="DateOfBirth" required>

        <label for="phoneNo" class="form-label">Phone No</label>
        <input type="tel" id="phoneNo" class="form-control" name="pno" placeholder="Phone no" required>

        <label for="city" class="form-label">City</label>
        <input type="text" id="city" class="form-control" name="Cty" placeholder="City" required>

        <label for="address" class="form-label">Address</label>
        <input type="text" id="address" class="form-control" name="ADD" placeholder="Address" required>

        <label for="bloodgroup" class="form-label">Blood Group</label>
        <select id="bloodGroup" class="form-select" aria-label="Default select example" required>
          <option selected>BloodGroup</option>
          <option value="A+">A+</option>
          <option value="A-">A-</option>
          <option value="B+">B+</option>
          <option value="B-">B-</option>
          <option value="AB+">AB+</option>
          <option value="AB-">AB-</option>
          <option value="O-">O-</option>
        </select>

        <label for="gender" class="form-label">Gender</label>
        <select id="gender" class="form-select" aria-label="Default select example" required>
          <option selected>Gender</option>
          <option value="MALE">MALE</option>
          <option value="FEMALE">FEMALE</option>
          <option value="OTHERS">OTHERS</option>
        </select>

        <div class="button-container mt-3">
          <button onClick="Register();" class="btn btn-purple">Register</button>
          <button onClick="Cancle();" class="btn btn-purple" data-bs-dismiss="modal">Cancel</button>
        </div>
        <!-- 👆 आपका Form यहीं खत्म होता है -->
      </div>

    </div>
  </div>
</div>

<style>
    .profile-container p {
        font-size: 16px;
        margin: 8px 0;
    }
    .profile-container strong {
        color: #333;
    }
    .errow-container {
      width: 400px;
      height: 50px;
      background: linear-gradient(to right, red ,green);
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
      
    }
     .profile-background{
     background-image: url('./img/pro.png');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  height: 50vh;
  display: flex;
  justify-content: center;
  align-items: center;
  color: black; /* if text needs to contrast */
  text-align: center;
  font-size:20px;
    }
    
</style>
</body>
</html>


<script type="text/javascript" src="./JS/registration.js"></script>
<script type="text/javascript" src="./JS/profile.js"></script>

