console.log("AddH.js");
fetchUsers();

function fetchUsers() {
    fetch("http://localhost:8006/Life_Saver_Hub/Add?fetchAll=true", { method: "GET" })
        .then(response => response.json())
        .then(users => {
            let tableBody = document.querySelector("#userTable tbody");
            tableBody.innerHTML = ""; // Clear existing table rows
            users.forEach(user => {
                let row = `
                    <tr>
                        <td>${user.hospitalName}</td>
                        <td>${user.Daddress}</td>
                        <td>${user.contactno}</td>
					    <td><button type="button" onclick="sethospitalid('${user.hospitalid}');"  class="btn btn-purple me-2" data-bs-toggle="modal" data-bs-target="#chartModal">
  Blood Detail
</button></td>
                    </tr>`;
                tableBody.innerHTML += row;
            });
        })
        .catch(error => console.error("Error fetching users:", error));
}
function Add() {
    let userData = {
    
        hospitalName: document.getElementById("hospitalName").value,
        Daddress: document.getElementById("Daddress").value,
        contactno: document.getElementById("contactno").value
    };

   fetch("http://localhost:8006/Life_Saver_Hub/Add", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(userData)
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert("Hospital detail Add Successfully!");
            clearModalFields();
            // Close the modal
            var modal = document.getElementById('exampleModal'); // Modal ID (make sure it's correct)
            if (modal) {
                var bootstrapModal = bootstrap.Modal.getInstance(modal);
                bootstrapModal.hide();
                  fetchUsers();
                  fetchHospitals();

               
            }
        } else {
            alert("Error: " + data.message);
        }
    })
.catch(error => console.error("Error Registering : ", error.message || error));}





 let hospitalID = 0; // Store the selected hospital ID globally

    // This function is called when the 'Blood Detail' button is clicked
    function sethospitalid(hospitalId) {
        hospitalID = hospitalId; // Set the hospital ID
        fetchBloodData(hospitalID); // Fetch blood data for this specific hospital
    }

    // Function to fetch blood data based on the hospital ID
    function fetchBloodData(hospitalId) {
        fetch(`http://localhost:8006/Life_Saver_Hub/fetchBloodData?hospitalId=${hospitalId}`) // Adjust URL if needed
            .then(response => response.json())
            .then(data => {
                if (data && data.length > 0) {
                    let bloodTypes = data.map(item => item.bloodType);
                    let quantities = data.map(item => item.quantity);

                    // Call updateChart to render the chart with fetched data
                    updateChart(bloodTypes, quantities);
                } else {
                    console.error('No blood data found for this hospital');
                    alert('No blood data found for this hospital.');
                }
            })
            .catch(error => {
                console.error('Error fetching blood data:', error);
                alert('Error fetching data. Please try again.');
            });
    }

    // This function updates the chart on the canvas
    function updateChart(bloodTypes, quantities) {
        const ctx = document.getElementById('myChart').getContext('2d');

        // If a chart instance exists, destroy it before creating a new one
        if (window.chartInstance) {
            window.chartInstance.destroy();
        }

        // Create a new chart instance
        window.chartInstance = new Chart(ctx, {
            type: 'bar', // Bar chart type
            data: {
                labels: bloodTypes, // X-axis: blood types
                datasets: [{
                    label: 'Blood Stock Quantity',
                    data: quantities, // Y-axis: blood quantities
                    backgroundColor: [
                        '#FF5733', '#33FF57', '#3357FF', '#FF33A8', '#F39C12', '#8E44AD', '#16A085', '#C0392B'
                    ], // Bar colors
                    borderColor: '#333', // Bar border color
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                scales: {
                    y: {
                        beginAtZero: true // Start y-axis from 0
                    }
                }
            }
        });
    }







function logout() {
    // Clear local storage
    localStorage.clear();

    // Then call the logout API
    fetch("http://localhost:8006/Life_Saver_Hub/logout", {
        method: 'GET',
        credentials: 'include' // Send cookies/session info
    })
    .then(response => {
        if (response.redirected) {
            // If redirected by the server
            window.location.href = response.url;
        } else {
            // Fallback in case no redirect
            window.location.href = 'index.jsp';
        }
    })
    .catch(error => {
        console.error('Logout failed:', error);
    });
}





let chartInstance;

function sethospitalid(hospitalId) {
    // Fetch and show chart
    fetch(`http://localhost:8006/Life_Saver_Hub/fetchBloodData?action=fetchByHospital&hospitalId=${hospitalId}`)
        .then(response => response.json())
        .then(data => {
            const chartData = {
                bloodTypes: data.map(item => item.bloodType),
                quantities: data.map(item => item.quantity)
            };

            // If chart already exists, destroy it
            if (chartInstance) {
                chartInstance.destroy();
            }

            const ctx = document.getElementById('myChart').getContext('2d');
            chartInstance = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: chartData.bloodTypes,
                    datasets: [{
                        label: 'Blood Stock Quantity',
                        data: chartData.quantities,
                        backgroundColor: ['#FF5733', '#33FF57', '#3357FF', '#FF33A8'],
                        borderColor: '#333',
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
        .catch(error => {
            console.error("Error fetching chart data:", error);
        });
}

function clearModalFields() {
    // Reset each input field in the modal
    document.getElementById("hospitalName").value = "";
    document.getElementById("Daddress").value = "";
        document.getElementById("contactno").value = "";

}
    
