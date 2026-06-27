package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import dao.RegisterDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.registrationModel;

public class RegisterController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private RegisterDao registerDao;

    @Override
    public void init() {
        registerDao = new RegisterDao(); // Initialize RegisterDao instance
    }

    // Handle POST requests to process the registration form
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        try {
        	 // Convert JSON request to AddHospitalsModel object
            registrationModel user = gson.fromJson(request.getReader(), registrationModel.class);
            
            if (user == null) {
                out.print("{\"success\": false, \"message\": \"Invalid user data\"}");
                return;
            }

            // Register user
            boolean success = registerDao.registerOrUpdateUser(user);

            // Return response
            if (success) {
                out.print("{\"success\": true}");
            } else {
                out.print("{\"success\": false, \"message\": \"Database error\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print("{\"success\": false, \"message\": \"Exception occurred\"}");
        } finally {
            out.flush(); // Ensure the response is sent
        }
    }

    // Handle GET requests to retrieve the list of users
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();


        try {
            // Get the list of users
            List<registrationModel> userList = registerDao.getUserList();
            String json = gson.toJson(userList);
            out.print(json);
			/*
			 * // Build JSON manually StringBuilder jsonBuilder = new StringBuilder();
			 * jsonBuilder.append("[");
			 * 
			 * for (int i = 0; i < userList.size(); i++) { registrationModel user =
			 * userList.get(i); jsonBuilder.append("{")
			 * .append("\"email\":\"").append(user.getEmail()).append("\",")
			 * .append("\"dateOfBirth\":\"").append(user.getDateOfBirth()).append("\",")
			 * .append("\"phoneNo\":\"").append(user.getPhoneNo()).append("\",")
			 * .append("\"city\":\"").append(user.getCity()).append("\",")
			 * .append("\"address\":\"").append(user.getAddress()).append("\",")
			 * .append("\"bloodGroup\":\"").append(user.getBloodGroup()).append("\",")
			 * .append("\"gender\":\"").append(user.getGender()).append("\"") .append("}");
			 * 
			 * if (i < userList.size() - 1) { jsonBuilder.append(","); } }
			 * 
			 * jsonBuilder.append("]");
			 * 
			 * // Write JSON response out.print(jsonBuilder.toString());
			 */
        } catch (Exception e) {
            e.printStackTrace();
            out.print("{\"success\": false, \"message\": \"Failed to retrieve users\"}");
        } finally {
            out.flush(); // Ensure the response is sent
        }
    }
}
