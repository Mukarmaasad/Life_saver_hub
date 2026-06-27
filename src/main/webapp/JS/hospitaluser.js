/**
 * 
 */


console.log("BBank.js");
fetchallusers();
fetchallHospitalsuser();




 // Fetch hospitals and populate dropdowns
function fetchallHospitalsuser() {
    fetch("http://localhost:8006/Life_Saver_Hub/AddHospitaluser?action=UserDropdown", { method: "GET" })
    .then(response => response.json())
    .then(hospitalusers => {
        let dropdown = document.getElementById("userDropdown");
        //let searchDropdown = document.getElementById("searchHospitalDropdown");

        dropdown.innerHTML = ''; 
       // searchDropdown.innerHTML = ''; 

        // Default option for both dropdowns
        dropdown.innerHTML = '<option value="">Select User</option>';
        //searchDropdown.innerHTML = '<option value="">Select Hospital</option>';

        hospitalusers.forEach(function (user) {
            let option = document.createElement("option");
            option.value = user.userId;
            option.textContent = user.firstName;


            dropdown.appendChild(option);
            //searchDropdown.appendChild(searchOption);
        });
    })
    .catch(error => console.error("Error fetching hospitals:", error));
}


// addhospitaluser 

function AddHospitaluser() {
    let  hospitaluser= {
		hospitalid: document.getElementById("hospitalusersDropdown").value,  // Ensure hospital ID is captured
		userid: document.getElementById("userDropdown").value,  // Ensure hospital ID is captured

       

    };

    fetch("http://localhost:8006/Life_Saver_Hub/AddHospitaluser", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(hospitaluser)
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert("Updated Successfully!");
                fetchallHospitalsuser();
        
  
        } else {
            alert("Error: " + data.message);
        }
    })
    .catch(error => console.error("Error updating blood data:", error.message || error));
}


function fetchallusers() {
    fetch("http://localhost:8006/Life_Saver_Hub/AddHospitaluser?action=UserhospitalDropdown", { method: "GET" })
    .then(response => response.json())
    .then(hospitals => {
        let dropdown = document.getElementById("hospitalusersDropdown");
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


