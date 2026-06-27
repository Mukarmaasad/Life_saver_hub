


<!-- About Us Section -->
     <div class="home-text">
        <br><br>
        
        <div class="hospital-background">
  <div class="overlay-content">
    
     
    <h3 class="animate-text"></h3>
  <p class="animate-text delay">
  
   
   
    <b>We aim to make the blood donation process easier, faster, and more efficient.<br>
    Join us in making a difference and saving lives.</b>
  </p>
  </div>
  </div>
</div>  
        
<br><br><br>
<section class="table-section">
<div class="row">



<div class="row">
    <div class="col-md-3">
         <label for="ad" class="form-label"><b><i>Search Hospital Address</i></b></label>
         <input type="text" id="HospitaladdressSearch" class="form-control" placeholder="Search by Address">
         
    </div>
</div>




        <div>
        	<table id="userTable" class="table table-striped-columns">
        		<thead>
        			<tr>
	       				<th>HospitalName</th>
	       				<th>Address</th>
	       				<th>ContactNumber</th>
	       				<th>Stock</th>
	       				
        			</tr>	
        		</thead>
        		<tbody>
        		
        		</tbody>
        	</table>
        </div>
    
</div>
</section>

<div class="modal fade" id="chartModal" tabindex="-1" aria-labelledby="chartModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="chartModalLabel">Blood Detail of Hospital</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <canvas id="myChart" width="400" height="200"></canvas>
      </div>
    </div>
  </div>
</div>
<style>
.hospital-background{
     background-image: url('./img/Hospital.png');
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
<!-- <script>

        document.addEventListener("DOMContentLoaded", function() {
            fetch('fetchBloodData') // Fetch JSON data from Servlet
                .then(response => response.json())
                .then(data => {
                    let bloodTypes = data.map(item => item.bloodType);
                    let quantities = data.map(item => item.quantity);

                    const ctx = document.getElementById('myChart').getContext('2d');
                    new Chart(ctx, {
                        type: 'bar',
                        data: {
                            labels: bloodTypes,
                            datasets: [{
                                label: 'Blood Stock Quantity',
                                data: quantities,
                                backgroundColor: [
                                    '#FF5733', // Red-Orange
                                    '#33FF57', // Green
                                    '#3357FF', // Blue
                                    '#FF33A8', // Pink
                                    '#F39C12', // Yellow-Orange
                                    '#8E44AD', // Purple
                                    '#16A085', // Teal
                                    '#C0392B'  // Dark Red
                                ],
                                borderColor: '#333', // Black border for contrast
                                borderWidth: 1
                            }]
                        },
                        options: {
                            responsive: true,
                            scales: {
                                y: {
                                    beginAtZero: true
                                }
                            }
                        }
                    });
                })
                .catch(error => console.error('Error fetching data:', error));
        });
 


</script> -->

<script type="text/javascript" src="JS/AddH.js"></script>
<script type="text/javascript" src="./JS/FilterSearch.js"></script>
<script type="text/javascript" src="JS/hospitalcharts.js"></script>