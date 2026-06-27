




<div class="home-text">
        <br><br>
        
        <div class="bank-background">
  <div class="overlay-content">
     <strong><h2>Blood Bank</h2></strong><br>
     
    <h3 class="animate-text"></h3>
  <p class="animate-text delay">
  
   
    <b>We aim to make the blood donation process easier, faster, and more efficient.<br>
    Join us in making a difference and saving lives.</b>
  </p>
  </div>
  </div>
</div>
<br><br>


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <br><br><br>
<section class="table-section">
<div class="row">
    <!-- Flexbox container to align buttons in a row -->
    <div class="col-12 d-flex justify-content-end">
        <!-- Insert Button -->
        <button type="button" class="btn btn-purple me-2" data-bs-toggle="modal" data-bs-target="#insertModal">
            ADD BLOOD DETAILS
        </button>
       
    </div>
<br>

<!-- Bootstrap Modal for Insert -->
<div class="modal fade" id="insertModal" tabindex="-1" aria-labelledby="insertModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="insertModalLabel">Insert Blood Donation</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
             
                            <img src="./img/Bank.png" alt="Donation Banner" style="width: 450px; height: 200px; border-radius: 8px;" />
             
             
                   <div class="mb-3">
    <label for="bloodGroupInsert" class="form-label">Blood Group</label>
    <select class="form-control" id="bloodGroupInsert">
        <option value="">Select Blood Group</option>
        <option value="O+">O+</option>
        <option value="O-">O-</option>
        <option value="A+">A+</option>
        <option value="A-">A-</option>
        <option value="B+">B+</option>
        <option value="B-">B-</option>
        <option value="AB+">AB+</option>
        <option value="AB-">AB-</option>
    </select>
</div>

                    <div class="mb-3">
                        <label for="quantityInsert" class="form-label">Quantity</label>
                        <input type="text" class="form-control" id="quantityInsert" placeholder="Enter Quantity">
                    </div>
               <!--   <div class="form-group">
                        <label for="HospitalDropdown" class="form-label">Hospital Name</label>
    
                          <select id="HospitalDropdown" class="form-select form-select-sm" name="HOSPITAL_NAME">
                          <option value="">Select Hospital</option>
                            </select>
                    </div> -->
                    
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                  <button class="btn btn-purple" onclick="Insert();">Insert</button>
           </div>
        </div>
    </div>
</div>


 
<!-- Table displaying blood information -->
   <div>
        <table id="bloodBankTable" class="table table-striped-columns">
            <thead>
                <tr>
                    <th>Hospital Name</th>
                    <th>Blood Group</th>
                    <th>Quantity</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            
            </tbody>
        </table>
     </div>
</div>
</section>
<!-- Custom CSS for Purple Button -->
<style>
    .btn-purple {
        background-color: #341539; /* Purple color */
        color: white;
    }
    .btn-purple:hover {
        background-color: red; /* Darker purple on hover */
        color: white;
    }
    .bank-background{
     background-image: url('./img/bb.png');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  height: 50vh;
  display: flex;
  justify-content: center;
  align-items: center;
  color: white; /* if text needs to contrast */
  text-align: center;
  font-size:20px;
    }
</style>

            <script type="text/javascript" src="./JS/BBank.js"></script>
    <link rel="stylesheet" href="./CSS/SectionDesign.css">
            