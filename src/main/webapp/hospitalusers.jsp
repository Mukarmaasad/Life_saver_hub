<div class="home-text">
        <br><br>
        
        <div class="Adduser-background">
  <div class="overlay-content">
     <strong><h2>Add Hospital User</h2></strong><br>
     
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
<div class="col-lg-8 col-md-8 col-sm-4 col-xs-0"></div>
 <div class="col-12 d-flex justify-content-end">	<button type="button" class="btn btn-purple" data-bs-toggle="modal" data-bs-target="#exampleModal">
	  Add Hospital
	</button>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Register a New Hospital</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      
                     <img src="./img/Hospital.png" alt="Donation Banner" style="width: 450px; height: 300px; border-radius: 8px;" />
      
      
        		<div class="mb-3">
                    <label for="hospitalName" class="form-label">HospitalName</label>
                    <input class="form-control" type="text" id="hospitalName" name="HOSPITALNAME" required>
                </div>
                <div class="mb-3">
                    <label for="Daddress" class="form-label">Address</label>
                    <input type="text" class="form-control" id="Daddress" name="ADDRESS" required>
                </div>
                <div class="mb-3">
                    <label for="contactno" class="form-label">ContactNumber</label>
                    <input type="text" class="form-control" id="contactno" name="CONTACTNO" required>
                </div>
                
      </div>
      <div class="modal-footer">
        <button class="btn btn-purple" onClick="Add();">Add</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>





<div class= "form-container">
  <h3 class="mb-4">Add Hospital User</h3>
    <div class="mb-3">
    <div class="mb-3">
  <label for="userDropdown" class="form-label">User</label>
  <select class="form-select" id="userDropdown">
    <option selected disabled>Loading users...</option>
  </select>
</div>
      <div class="mb-3">
  <label for="hospitalusersDropdown" class="form-label">Hospital Name</label>
  <select class="form-select" id="hospitalusersDropdown">
    <option selected disabled>Loading hospitals...</option>
  </select>
</div>
    
                  <button class="btn btn-purple" onclick="AddHospitaluser();">AddHospitaluser</button>
</div>
</div>
<style>

.form-container {
      max-width: 450px;
      margin: 80px auto;
      padding: 40px 30px;
      background-color: #D1C4E9;
      border-radius: 25px;
  box-shadow: 15px 15px 15px 15px #341539;
    }
    .Adduser-background{
     background-image: url('./img/add.png');
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

<script type="text/javascript" src="./JS/hospitaluser.js"></script>
