console.log("login.js");

function login() {
    // Get input values using getElementById
    let email = document.getElementById("email").value.trim();
    let password = document.getElementById("password").value.trim();

    // Regular expression for basic email format validation
    let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    // --------- VALIDATION ---------
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
    formData.append("email", email);
    formData.append("password", password);

    console.log("Form Data:", formData.toString());

    fetch("http://localhost:8006/Life_Saver_Hub/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: formData
    })
    .then(response => response.json())
    .then(data => {
        console.log("Response:", data);
        if (data.userId) {
            localStorage.setItem("userModel", JSON.stringify(data));
            window.location.href = "Home.jsp";
        } else {
            alert(data.message || "Login failed!");
        }
    })
    .catch(error => {
        console.error("Error during login:", error);
        alert("Something went wrong. Please try again later.");
    });
}
