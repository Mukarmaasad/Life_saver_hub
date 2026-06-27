package controller;

import dao.SignupDao;
import model.LoginModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SignupController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SignupController() {
        super();
    }

    // Handle GET request - show the sign-up page (Not needed if it's purely API)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // We can skip forwarding since this is an API-style controller
        response.setStatus(HttpServletResponse.SC_OK);
    }

    // Handle POST request - receive form data and store in database
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data from the request
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String status = request.getParameter("status");

        // Create a SignupModel object and set the user details
        LoginModel loginModel = new LoginModel();
        loginModel.setFirstName(firstName);
        loginModel.setLastName(lastName);
        loginModel.setEmail(email);
        loginModel.setPassword(password); 
        loginModel.setStatus(status);// Make sure to hash the password before saving in a real-world application

        // Create SignupDao object to interact with the database
        SignupDao signupDao = new SignupDao();

        // Initialize a response object
        String jsonResponse = "";

        // Check if email already exists
        if (signupDao.checkEmailExistence(email)) {
            // Email already exists, return error response
            jsonResponse = "{\"success\": false, \"message\": \"Email already exists. Please use a different email.\"}";
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // Bad request status
        } else {
            // Register the user in the database
            boolean isRegistered = signupDao.registerUser(loginModel);

            if (isRegistered) {
                // Registration successful
                jsonResponse = "{\"success\": true, \"message\": \"Registration successful.\"}";
                response.setStatus(HttpServletResponse.SC_OK); // OK status
            } else {
                // Registration failed
                jsonResponse = "{\"success\": false, \"message\": \"Registration failed. Please try again.\"}";
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // Internal server error
            }
        }

        // Set response content type and send the JSON response
        response.setContentType("application/json");
        response.getWriter().write(jsonResponse);
    }
}
