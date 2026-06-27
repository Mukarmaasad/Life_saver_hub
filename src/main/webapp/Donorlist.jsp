


<div class="home-text">
        <br><br>
        
        <div class="class-background">
  <div class="overlay-content">
     <strong><h2>Donor List</h2></strong><br>
     
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


<!-- Search Bar Section -->
<section class="table-section">
<div class="row">
    <div class="col-md-3">
        <label for="BG" class="form-label"><b><i>Search Blood Group</i></b></label>
        <select id="bloodGroupSearch" class="form-control" placeholder="Search by Blood Group">

		 <option selected>BloodGroup</option>
		  <option value="A+">A+</option>
		  <option value="A-">A-</option>
		  <option value="B+">B+</option>
		  <option value="B-">B-</option>
		  <option value="AB+">AB+</option>
		  <option value="AB-">AB-</option>
		  <option value="O-">O-</option>
		</select>
        
    </div>
    <div class="col-md-3">
         <label for="ad" class="form-label"><b><i>Search Address</i></b></label>
         <input type="text" id="addressSearch" class="form-control" placeholder="Search by Address">
         
    </div>
</div>
<br><br>

<div class="row">
    <table id="registerTable" class="table table-striped-columns">
        <thead>
            <tr>
                <th>Name</th>
                <th>Date of Birth</th>
                <th>Phone No</th>
                <th>City</th>
                <th>Address</th>
                <th>Blood Group</th>
                <th>Gender</th>
                <th>Donation Date</th>
                
                <th>Status</th>
            </tr> 
        </thead>
        <tbody id="tableBody">
            <!-- Dynamic table rows will go here -->
        </tbody>
    </table>
</div>
</section>

<!-- Modal Structure -->
<!-- <div class="modal fade" id="donorModal" tabindex="-1" aria-labelledby="donorModalLabel" aria-hidden="true">
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

        Hospital ID Dropdown
        <div class="mb-3">
          <label for="DropdownofHospitals" class="form-label">Hospital ID</label>
          <select class="form-select" id="DropdownofHospitals">
            Options will be populated dynamically
          </select>
        </div>
        
        

        Additional fields
        <div id="donorInfo">
          Donor Info will be populated dynamically
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                  <button class="btn btn-purple" onclick="Donate();">Donate</button>
      </div>
    </div>
  </div>
</div>


 -->


<script type="text/javascript" src="./JS/Donations.js"></script>
<script type="text/javascript" src="./JS/registration.js"></script>
<script type="text/javascript" src="./JS/FilterSearch.js"></script>
    <link rel="stylesheet" href="./CSS/SectionDesign.css">

<style>
    .btn-red {
        background-color: red !important;
        color: white !important;
    }
    .btn-purple {
        background-color: purple;
        color: red;
    }
     .table-section {
    
    background-color: transparent;
    border-radius: 10px;
    margin: 1px auto;
    max-width: 1500px;
  }
  .class-background {
  background-image: url('./img/DD.png');
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
.col-md-3{
    margin: 10px auto;

}
</style>
