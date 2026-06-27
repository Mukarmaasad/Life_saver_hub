console.log("registration.js");
registerUsers();

function registerUsers() {
    fetch("http://localhost:8006/Life_Saver_Hub/Register?fetchAll=true", { method: "GET" })
        .then(response => response.json())
        .then(users => {
            let tableBody = document.querySelector("#registerTable tbody");
            tableBody.innerHTML = ""; // Clear existing table rows
            users.forEach(user => {
				let status = getDonationStatus(user);
				let isDisabled = status ? "disabled" : "";
				let btnText = status ? "Donated" : "Avalible";
                let textClass = status ? "text-red" : "text-green";

                let row = `
                    <tr>
                     

                       <td>${user.firstname}</td>
                        <td>${user.dateOfBirth}</td>
                        <td>${user.phoneNo}</td>
                         <td>${user.city}</td>
                        <td>${user.address}</td>
                        <td>${user.bloodGroup}</td>
                         <td>${user.gender}</td>
                         <td>${user.donationdate}</td>
                 <td><p class="${textClass}" ${isDisabled}>
                ${btnText}
            </p>
  </td>
                    </tr>`;
                tableBody.innerHTML += row;
            });
        })
        .catch(error => console.error("Error fetching users:", error));
}
function Register() {
    // Get input values
    let dateOfBirth = document.getElementById("dateOfBirth").value;
    let phoneNo = document.getElementById("phoneNo").value;
    let city = document.getElementById("city").value;
    let address = document.getElementById("address").value;
    let bloodGroup = document.getElementById("bloodGroup").value;
    let gender = document.getElementById("gender").value;

    // Validate Date of Birth (Age validation)
    if (dateOfBirth === "") {
        alert("Please enter your date of birth.");
        return;
    } else {
        const today = new Date();
        const dob = new Date(dateOfBirth);
        let age = today.getFullYear() - dob.getFullYear();
        const m = today.getMonth() - dob.getMonth();
        if (m < 0 || (m === 0 && today.getDate() < dob.getDate())) {
            age--;
        }
    if (age < 18 || age > 40) {
    alert("You must be at least 18 years old and less than 40 years old to register.");
            return;
        }
    }

    // Validate Phone Number (basic 10-digit check)
    let phonePattern = /^[0-9]{11}$/;
    if (!phonePattern.test(phoneNo)) {
        alert("Please enter a valid 11-digit phone number.");
        return;
    }

    // Validate City
    if (city.trim() === "") {
        alert("Please enter your city.");
        return;
    }

    // Validate Address
    if (address.trim() === "") {
        alert("Please enter your address.");
        return;
    }

    // Validate Blood Group
    if (bloodGroup === "" || bloodGroup === "Blood Group") {
        alert("Please select your blood group.");
        return;
    }

    // Validate Gender
    if (gender === "" || gender === "Gender") {
        alert("Please select your gender.");
        return;
    }

    // Proceed with the registration if all validations pass
    let user = JSON.parse(localStorage.getItem("userModel"));
    let userData = {

        dateOfBirth: dateOfBirth,
        phoneNo: phoneNo,
        city: city,
        address: address,
        bloodGroup: bloodGroup,
        gender: gender,
        status: 1,
        userId: user.userId
    };

    // Send the data to the server
    fetch("http://localhost:8006/Life_Saver_Hub/Register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(userData)
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert("User as a donor updated successfully!");
            
              Cancle();  // This will clear all the input fields
            registerUsers();
            displayUserProfile(userData);
            
            // Close the modal
            var modal = document.getElementById('registrationModal'); // Modal ID (make sure it's correct)
            if (modal) {
                var bootstrapModal = bootstrap.Modal.getInstance(modal);
                bootstrapModal.hide();
            }
            
        } else {
            alert("Error: " + data.message);
        }
    })
    .catch(error => console.error("Error registering: ", error.message || error));
}


 function toggleOtherHospitalInput() {
        var hospitalSelect = document.getElementById('hospitalSelect');
        var otherHospitalContainer = document.getElementById('otherHospitalContainer');
        
        // Show or hide the "Other Hospital" input based on the selected value
        if (hospitalSelect.value === 'other') {
            otherHospitalContainer.style.display = 'block'; // Show the input field
        } else {
            otherHospitalContainer.style.display = 'none'; // Hide the input field
        }
    }
function setuserid(userId) {
    // Step 1: Save userId in localStorage for future use
    localStorage.setItem("userId", userId);

    // Step 2: Also assign to a global variable if needed
    userID = userId;

    // Step 3: Send request to backend to update user status = 0
    fetch("http://localhost:8006/Life_Saver_Hub/donorstatus", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ userid: userId, status: 0 })
    })
    .then(res => res.json())
    .then(data => {
        if (data.success) {
            console.log("Status set to 0 (Donor intent)");
        } else {
            console.error("Failed to insert status 0");
        }
    })
    .catch(error => console.error("Error updating status:", error));
}

 
 function Donate() {
	let userModel = localStorage.getItem("userModel");
	let user = JSON.parse(userModel);

    let DonorData = {
		hospitalid: document.getElementById("DropdownofHospitals").value,  // Ensure hospital ID is captured
		Unitsofblood: document.getElementById("quantityInput").value,
		userid: parseInt(user.userId)

    };

    fetch("http://localhost:8006/Life_Saver_Hub/Donate", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(DonorData)
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
			 localStorage.setItem("userId", data.userId);
            alert("Thanks For Donation!");
             // Clear the modal fields
             
            clearModalFields();
            registerUsers();

            // Close the modal
            var modal = document.getElementById('donorModal'); // Modal ID (make sure it's correct)
            if (modal) {
                var bootstrapModal = bootstrap.Modal.getInstance(modal);
                bootstrapModal.hide();
            }
            
      
            
/*            localStorage.setItem(`lastDonationDate_${userID}`, new Date().toISOString()); // Save donation date
*/            
			             // Update the donor button in table immediately
			let donorButtons = document.querySelectorAll("#registerTable button");
			donorButtons.forEach(btn => {
			    if (btn.getAttribute("onclick") === `setuserid('${user.userId}');`) {
			        btn.textContent = "Donated";
			        btn.classList.remove("btn-purple");
			        btn.classList.add("btn-red");
			        btn.disabled = true;
			    }
});


// ✅ Update profile page button
    const profileButton = document.getElementById("donateBtn");
    if (profileButton) {
        profileButton.textContent = "Donated";
        profileButton.classList.remove("btn-purple");
        profileButton.classList.add("btn-red");
        profileButton.disabled = true;
    }

            fetchDonationsData(); // Refresh donation data after save changes
        } else {
            alert("Error: " + data.message);
        }
    })
    .catch(error => console.error("Error updating blood data:", error.message || error));
}

// Fetch hos and populate dropdowns



function getDonationStatus(user) {
    if (user.hasOwnProperty('donationdate') && user.donationdate) {
        const lastDonation = new Date(user.donationdate);
        const today = new Date();
        const diffInDays = Math.floor((today - lastDonation) / (1000 * 60 * 60 * 24));
        if (diffInDays < 90) {
            return true; // still in cooldown
        }
        else{
			return false	
		}
    }
    else{
		return false
	}
}
 
 function Cancle() {
    document.getElementById("dateOfBirth").value = "";
    document.getElementById("phoneNo").value = "";
    document.getElementById("city").value = "";
    document.getElementById("address").value = "";
    document.getElementById("bloodGroup").value = "";
    document.getElementById("gender").value = "";
}
 
 
 
 // Function to clear modal fields
function clearModalFields() {
    // Reset each input field in the modal
    document.getElementById("DropdownofHospitals").value = "";
    document.getElementById("quantityInput").value = "";

    // If you have more fields in the modal, reset them as well
    // Example:
    // document.getElementById("otherField").value = "";
}
    