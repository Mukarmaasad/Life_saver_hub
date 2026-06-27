let chartInstance;

document.addEventListener("DOMContentLoaded", function () {
    fetchHospitalsforDW();  // Fetch hospitals for dropdown
    document.getElementById('Dropdownofhospitals').addEventListener('change', function () {
        const hospitalId = this.value;  // Get selected hospital ID
        if (hospitalId) {
            fetchChartData(hospitalId);  // Fetch and display chart data for the selected hospital
        }
    });
});

// Function to fetch and populate hospitals in dropdown
function fetchHospitalsforDW() {
    fetch("http://localhost:8006/Life_Saver_Hub/fetchBloodData?action=hospitalDropdown", {
        method: "GET"
    })
    .then(response => response.json())
    .then(hospitals => {
        const dropdown = document.getElementById("Dropdownofhospitals");
        dropdown.innerHTML = '<option value="">Select Hospital</option>'; // reset dropdown

        hospitals.forEach(hospital => {
            const option = document.createElement("option");
            option.value = hospital.hospitalId;  // Set hospital ID as the option value
            option.textContent = hospital.hospitalName;  // Set hospital name as the option text
            dropdown.appendChild(option);
        });
    })
    .catch(error => console.error("Error fetching hospitals:", error));
}

// Function to fetch and display chart data for the selected hospital
function fetchChartData(hospitalId) {
    fetch(`http://localhost:8006/Life_Saver_Hub/fetchBloodData?action=fetchByHospital&hospitalId=${hospitalId}`, {
        method: "GET"
    })
    .then(response => response.json())
    .then(data => {
        // Assuming the fetched data is in this format: 
        // [{ bloodType: 'A+', quantity: 50 }, { bloodType: 'O-', quantity: 30 }, ...]
        
        const chartData = {
            bloodTypes: data.map(item => item.bloodType),
            quantities: data.map(item => item.quantity)
        };

        // If chart already exists, destroy it and recreate
        if (chartInstance) {
            chartInstance.destroy();  // Destroy previous chart instance
        }

        // Create a new chart instance
        chartInstance = new Chart(document.getElementById('bloodChart').getContext('2d'), {
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
    .catch(error => console.error("Error fetching chart data:", error));
}
