







<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Donor Blood Stock</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
 <div class="home-text">
        <br><br>
        
        <div class="donor-background">
  <div class="overlay-content">
     <strong><h2>Donor Dashboard</h2></strong><br>
     
    <h3 class="animate-text"></h3>
  <p class="animate-text delay">
  
   
    <b>We aim to make the blood donation process easier, faster, and more efficient.<br>
    Join us in making a difference and saving lives.</b>
  </p>
  </div>
  </div>
</div>  
        
<br>
<body>


    <div style="width: 50%; margin: auto;">
        <canvas id="DonorChart"></canvas>
    </div>

    <script>
        document.addEventListener("DOMContentLoaded", function() {
            fetch('fetchDonorData') // Fetch JSON data from Servlet
                .then(response => response.json())
                .then(data => {
                    let bloodTypes = data.map(item => item.bloodType);
                    let quantities = data.map(item => item.quantity);

                    const ctx = document.getElementById('DonorChart').getContext('2d');
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
                                    beginAtZero: true,
                                    title: {
                                        display: true,
                                        text: 'Number of Donors',
                                        color: '#333',
                                        font: {
                                            size: 16,
                                            weight: 'bold'
                                        }
                                    },
                                    ticks: {
                                        color: '#C0392B', // Dark Red color
                                        font: {
                                            size: 14 // Font size for Y-axis
                                        }
                                    }
                                },
                                x: {
                                    title: {
                                        display: true,
                                        text: 'Blood Group',
                                        color: '#333',
                                        font: {
                                            size: 16,
                                            weight: 'bold'
                                        }
                                    },
                                    ticks: {
                                        color: '#2980B9', // Blue color
                                        font: {
                                            size: 14 // Font size for X-axis
                                        }
                                    }
                                }
                            }
                        }
                    });
                })
                .catch(error => console.error('Error fetching data:', error));
        });
    </script>

</body>
<style>

.donor-background{
     background-image: url('./img/dash.png');
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

</style>
</html>
