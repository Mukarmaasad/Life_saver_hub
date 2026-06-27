/**
 * 
 */
console.log("NEW.js");
fetchUsers();

function fetchUsers() {
    fetch("http://localhost:8006/Life_Saver_Hub/Register?fetchAll=true", { method: "GET" })
        .then(response => response.json())
        .then(users => {
            let tableBody = document.querySelector("#userTable tbody");
            tableBody.innerHTML = ""; // Clear existing table rows
            users.forEach(user => {
                let row = `
                    <tr>
                        <td>${user.email}</td>
                        <td>${user.dateOfBirth}</td>
                        <td>${user.phoneNo}</td>
	     <td>${user.city}</td>
                        <td>${user.address}</td>
                        <td>${user.bloodGroup}</td>
                        <td>${user.gender}</td>
                    </tr>`;
                tableBody.innerHTML += row;
            });
        })
        .catch(error => console.error("Error fetching users:", error));
}
function Register() {
    let userData = {
    
        email: document.getElementById("email").value,
        dateOfBirth: document.getElementById("dateOfBirth").value,
        phoneNo: document.getElementById("phoneNo").value,
       city: document.getElementById("city").value,
        address: document.getElementById("address").value,
        bloodGroup: document.getElementById("bloodGroup").value,
        gender: document.getElementById("gender").value,
    };

   fetch("http://localhost:8006/Life_Saver_Hub/Register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(userData)
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert("Hospital detail Add Successfully!");
            fetchUsers();
            
        } else {
            alert("Error: " + data.message);
        }
    })
.catch(error => console.error("Error Registering : ", error.message || error));}
