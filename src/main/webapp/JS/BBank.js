/**
 * 
 */
console.log("BBank.js");
fetchBloodbankData();
fetchHospitals();

// Fetch all bloodbank data
function fetchBloodbankData() {
	let userModel = localStorage.getItem("userModel");
let parsedUser = JSON.parse(userModel);
let hospitalId = parsedUser.hospitalId;
    fetch(`http://localhost:8006/Life_Saver_Hub/Insert?action=hospitalId&hospitalId=${hospitalId}`,  { method: "GET" })
        .then(response =>response.json()) 
        .then(text => {
      
              
                let tableBody = document.querySelector("#bloodBankTable tbody");
                tableBody.innerHTML = ""; // Clear existing table rows

                text.forEach(blood => {
                    let row = `
                        <tr>
                          <td>${blood.hospitalName}</td>  <!-- Add hospital name -->

                         <td>${blood.bloodGroupInsert}</td>
                            <td>${blood.quantityInsert}</td>
                            <td><button type="button" class="btn btn-purple me-2"  onclick="bloodbankIdSetINC('${blood.bloodbankid},${blood.quantityInsert}');">+</button>  
                            <button type="button" class="btn btn-purple me-2"  onclick="bloodbankIdMinus('${blood.bloodbankid},${blood.quantityInsert}');">-</button>
                            </td>
                        </tr>`;
                    tableBody.innerHTML += row;
                });
            })        
             .catch(error => console.error("Error fetching users:", error));
}
// Call the function when the page loads
/*document.addEventListener("DOMContentLoaded", fetchBloodData);*/

// Insert new blood data
function Insert() {
	let userModel = localStorage.getItem("userModel");
	let hosp = JSON.parse(userModel);
    let BloodData = {
		hospitalId: hosp.hospitalId,  // Ensure hospital ID is captured

        bloodGroupInsert: document.getElementById("bloodGroupInsert").value,
        quantityInsert: document.getElementById("quantityInsert").value,

    };

    fetch("http://localhost:8006/Life_Saver_Hub/Insert", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(BloodData)
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert("Updated Successfully!");
            fetchBloodbankData();
              
              clearModalFields();
            // Close the modal
            var modal = document.getElementById('insertModal'); // Modal ID (make sure it's correct)
            if (modal) {
                var bootstrapModal = bootstrap.Modal.getInstance(modal);
                bootstrapModal.hide();
                  fetchHospitals();
                 
               
            }
           /* fetchBloodbankData(); */// Refresh blood data after insert
        } else {
            alert("Error: " + data.message);
        }
    })
    .catch(error => console.error("Error updating blood data:", error.message || error));
}

// Fetch hospitals and populate dropdowns
/*function fetchHospitals() {
    fetch("http://localhost:8006/Life_Saver_Hub/Insert?action=hospitalDropdown", { method: "GET" })
    .then(response => response.json())
    .then(hospitals => {
        let dropdown = document.getElementById("HospitalDropdown");
        //let searchDropdown = document.getElementById("searchHospitalDropdown");

        dropdown.innerHTML = ''; 
       // searchDropdown.innerHTML = ''; 

        // Default option for both dropdowns
        dropdown.innerHTML = '<option value="">Select Hospital</option>';
        //searchDropdown.innerHTML = '<option value="">Select Hospital</option>';

        hospitals.forEach(function (hos) {
            let option = document.createElement("option");
            option.value = hos.hospitalId;
            option.textContent = hos.hospitalName;


            dropdown.appendChild(option);
            //searchDropdown.appendChild(searchOption);
        });
    })
    .catch(error => console.error("Error fetching hospitals:", error));
}
*/
function bloodbankIdSetINC(bloodbankid, currentQuantity) {
    const updatedQuantity = parseInt(currentQuantity) + 1;

    const data = {
        bloodbankid: parseInt(bloodbankid),
        quantity: updatedQuantity
    };

    fetch("http://localhost:8006/Life_Saver_Hub/Updatebloodbank", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(result => {
        if (result.success) {
            //alert("Quantity updated successfully!");
            fetchBloodbankData(); // Refresh table
        } else {
            alert("Update failed: " + result.message);
        }
    })
    .catch(error => console.error("Error during update:", error));
}

function bloodbankIdMinus(bloodbankid, currentQuantity) {
    const updatedQuantity = Math.max(0, parseInt(currentQuantity) - 1); // Avoid going below 0

    const data = {
        bloodbankid: parseInt(bloodbankid),
        quantity: updatedQuantity
    };

 
    fetch("http://localhost:8006/Life_Saver_Hub/Updatebloodbank?action=decrease", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(result => {
        if (result.success) {
           // alert("Quantity decreased successfully!");
            fetchBloodbankData(); // Refresh table
        } else {
            alert("Update failed: " + result.message);
        }
    })
    .catch(error => console.error("Error during update:", error));
}

// Function to clear modal fields
function clearModalFields() {
    // Reset each input field in the modal
    document.getElementById("bloodGroupInsert").value = "";
    document.getElementById("quantityInsert").value = "";

    // If you have more fields in the modal, reset them as well
    // Example:
    // document.getElementById("otherField").value = "";
}
    
