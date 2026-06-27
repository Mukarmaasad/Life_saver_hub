console.log("Signup.js");

function Signup() {
    // Get values from input fields
    let firstname = document.getElementById("firstname").value.trim();
    let lastname = document.getElementById("lastname").value.trim();
    let email = document.getElementById("Semail").value.trim();
    let password = document.getElementById("Spassword").value.trim();

    // Simple email pattern for validation
    let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    // --------- VALIDATION ---------
    if (firstname === "") {
        alert("Please enter your first name.");
        return;
    }

    if (lastname === "") {
        alert("Please enter your last name.");
        return;
    }

    if (email === "") {
        alert("Please enter your email.");
        return;
    }

    if (!emailPattern.test(email)) {
        alert("Please enter a valid email address.");
        return;
    }

    if (password === "") {
        alert("Please enter your password.");
        return;
    }

    if (password.length < 6) {
        alert("Password must be at least 6 characters long.");
        return;
    }

    // --------- SEND DATA AFTER VALIDATION ---------
    let formData = new URLSearchParams();
    formData.append("firstname", firstname);
    formData.append("lastname", lastname);
    formData.append("email", email);
    formData.append("password", password);
    formData.append("status", 0);

    console.log("Form Data:", formData.toString());

    fetch("http://localhost:8006/Life_Saver_Hub/Signup", {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: formData
    })
    .then(response => response.json())
    .then(data => {
        console.log("Response:", data);
        if (data.success) {
            window.location.href = "index.jsp"; // Redirect on success
        } else {
            alert(data.message || "Signup failed!");
        }
    })
    .catch(error => {
        console.error("Error during signup:", error);
        alert("Something went wrong. Please try again.");
    });
}
