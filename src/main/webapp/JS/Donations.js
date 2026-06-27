
console.log("Donations.js");
fetchDonationsData();
fetchHos();

// Fetch all bloodbank data
function fetchDonationsData() {
	let userModel = localStorage.getItem("userModel");
     let parsedUser = JSON.parse(userModel);
    let userId = parsedUser.userId;
	    fetch(`http://localhost:8006/Life_Saver_Hub/Donate?action=userId&userId=${userId}`,  { method: "GET" })
   // fetch("http://localhost:8006/Life_Saver_Hub/Donate?fetchAll=true", { method: "GET" })
        .then(response =>response.json()) 
        .then(text => {
      
              
                let tableBody = document.querySelector("#DonationsTable tbody");
                tableBody.innerHTML = ""; // Clear existing table rows

                text.forEach(Donor => {
                    let row = `
                        <tr>
                        <td>${Donor.firstname} ${Donor.lastname}</td>
                             <td>${Donor.Unitsofblood}</td>
                             <td>${Donor.hospitalName}</td>
                               <td>${Donor.bloodgroup}</td>
                               <td>${Donor.donationDate}</td>
                             

                        </tr>`;
                    tableBody.innerHTML += row;
                });
            })        
             .catch(error => console.error("Error fetching users:", error));
}
//save donor information
/*function Donate() {
    let DonorData = {
		hospitalid: document.getElementById("DropdownofHospitals").value,  // Ensure hospital ID is captured
		unitsofblood: document.getElementById("quantityInput").value,
		

    };

    fetch("http://localhost:8006/Life_Saver_Hub/Donate", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(DonorData)
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert("Updated Successfully!");
            // Close the modal
            var modal = document.getElementById('donorModal'); // Modal ID (make sure it's correct)
            if (modal) {
                var bootstrapModal = bootstrap.Modal.getInstance(modal);
                bootstrapModal.hide();
            }
            fetchDonationsData(); // Refresh donation data after save changes
        } else {
            alert("Error: " + data.message);
        }
    })
    .catch(error => console.error("Error updating blood data:", error.message || error));
}*/

// Fetch hos and populate dropdowns
function fetchHos() {
    fetch("http://localhost:8006/Life_Saver_Hub/Donate?action1=HOSPITALSDW", { method: "GET" })
    .then(response => response.json())
    .then(hospitals => {
        let dropdown = document.getElementById("DropdownofHospitals");
        //let searchDropdown = document.getElementById("searchHospitalDropdown");

        dropdown.innerHTML = ''; 
       // searchDropdown.innerHTML = ''; 

        // Default option for both dropdowns
        dropdown.innerHTML = '<option value="">Select Hospital</option>';
        //searchDropdown.innerHTML = '<option value="">Select Hospital</option>';

        hospitals.forEach(function (hospital) {
            let option = document.createElement("option");
            option.value = hospital.hospitalid;
            option.textContent = hospital.hospitalName;

            let searchOption = document.createElement("option");
            searchOption.value = hospital.hospitalid;
            searchOption.textContent = hospital.hospitalName;

            dropdown.appendChild(option);
            //searchDropdown.appendChild(searchOption);
        });
    })
    .catch(error => console.error("Error fetching hospitals:", error));
}



