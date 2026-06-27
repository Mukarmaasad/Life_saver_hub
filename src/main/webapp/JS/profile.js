
//profile jsp mein hy
console.log("profile.js");

getuserbyid();

function displayUserProfile(userData) {
    // Fetch user data from localStorage

    if (userData) {
        // Display user data in HTML elements
        document.getElementById("userFirstName").textContent = userData.firstname || "Not available";
        document.getElementById("userLastName").textContent = userData.lastname || "Not available";
        document.getElementById("userEmail").textContent = userData.email || "Not available";
        document.getElementById("userDOB").textContent = userData.dateOfBirth || "Not available";
        document.getElementById("userPhoneNo").textContent = userData.phoneNo || "Not available";
        document.getElementById("userCity").textContent = userData.city || "Not available";
        document.getElementById("userAddress").textContent = userData.address || "Not available";
        document.getElementById("userBloodGroup").textContent = userData.bloodGroup || "Not available";
        document.getElementById("userGender").textContent = userData.gender || "Not available";
        document.getElementById("userStatus").textContent = userData.status || "Not available";
        document.getElementById("userDonationDate").textContent = userData.donationdate || "Not available";


        
    } else {
        console.log("No user data found in localStorage.");
        document.getElementById("profile").innerHTML = "<p>No user data found. Please register first.</p>";
    }

	if(userData.status == 1){
		 let isDonated = getDonationStatus(userData); // Get donation status

    // Check if user is registered as a donor (true or "true" based on your logic)
	    if (isDonated === "true" || isDonated === true) { 
	        document.getElementById("donateBtn").style.display = "none"; 
	       	document.getElementById("donatedButton").style.display = "inline-block"; 
	       	document.getElementById("donateText").style.display = "block";


	        
	
	    } else {
	        document.getElementById("donateBtn").style.display = "inline-block"; 
	       document.getElementById("donatedButton").style.display = "none"; 

	
	    }
	}
	else{
		document.getElementById("donateBtn").style.display = "none"; 
        document.getElementById("donatedButton").style.display = "none"; 

	}
    // Check if user is registered as a donor
  
}


    
    // Function to update donation button text and color
function updateDonationButton() {
    let donateBtn = document.getElementById("donateBtn");
    
    // Check donation status from localStorage
    let donatedStatus = localStorage.getItem("donated");

    if (donatedStatus === "true") {
        // Change button text and style to indicate the user has donated
        donateBtn.textContent = "Donated"; // Change text
        donateBtn.classList.remove("btn-purple"); // Remove original color
        donateBtn.classList.add("btn-red"); // Add donated color (or any other color class)
        donateBtn.disabled = true; // Disable the button so it can't be clicked again
    } else {
        // If not donated, keep the original button settings
        donateBtn.textContent = "Donor"; // Original text
        donateBtn.classList.remove("btn-red"); // Remove donated color
        donateBtn.classList.add("btn-purple"); // Keep original color
        donateBtn.disabled = false; // Enable the button for donation
    }
}

// Call this function on page load to update the button status
window.addEventListener("DOMContentLoaded", updateDonationButton);

 function getuserbyid() {
    // Get user model from local storage
    let userModel = localStorage.getItem("userModel");
    let user = JSON.parse(userModel);

    if (!user || !user.userId) {
        alert("User ID not found in localStorage.");
        return;
    }

    // Use template string with backticks ✅
    const url = `http://localhost:8006/Life_Saver_Hub/getUserById?userId=${user.userId}`;

    fetch(url)
        .then(response => response.json())
        .then(data => {
            if (data ) {
                displayUserProfile(data); // Call function to display profile
            } else {
                alert("User not found.");
            }
        })
        .catch(error => {
            console.error("Error fetching user profile:", error);
        });
}
