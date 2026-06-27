package controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import dao.LoginDao;
import model.LoginModel;

public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }


    // Handle POST requests (for login validation)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email"); // Get email from form
        String password = request.getParameter("password"); // Get password from form
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        // Create an instance of LoginModel (used as a login bean)
        LoginModel loginModel = new LoginModel();
        loginModel.setEmail(email);
        loginModel.setPassword(password);
        LoginDao loginDAO = new LoginDao();


        // Validate the user's credentials using LoginDao
       // boolean isAuthenticated = loginDao.validateUser(email, password);
        LoginModel loginModel1 = loginDAO.validateUser(loginModel);

        if (loginModel1.getUserId() != null) {
            // If login is successful, set session attribute
        	   out.write(gson.toJson(loginModel1));

        } else {
            // If login fails, show an error message
            String jsonResponse = "{\"success\": false, \"message\": \"Incorrect username or password. Please try again.\"}";
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonResponse);

        }
    }
}
