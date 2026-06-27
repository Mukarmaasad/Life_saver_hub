package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AddHospitalsModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import dao.AddHospitalsDao;

public class AddHospitalsController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AddHospitalsDao HDao;

    @Override
    public void init() {
        HDao = new AddHospitalsDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        try {
            // Convert JSON request to AddHospitalsModel object
            AddHospitalsModel user = gson.fromJson(request.getReader(), AddHospitalsModel.class);
            
            if (user == null) {
                out.print("{\"success\": false, \"message\": \"Invalid user data\"}");
                return;
            }

            // Register user
            int success = HDao.registerUser(user);

            // Response
            if (success == 1) {
                out.print("{\"success\": true, \"message\": \"User registered successfully\"}");
            } else {
                out.print("{\"success\": false, \"message\": \"Database error occurred while registering user\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print("{\"success\": false, \"message\": \"Exception occurred: " + e.getMessage() + "\"}");
        } finally {
            out.flush();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        try {
            // Get the list of users from the DAO
            List<AddHospitalsModel> userList = HDao.getUserList();

            // Convert the user list to JSON
            String json = gson.toJson(userList);
            out.print(json);
        } catch (Exception e) {
            e.printStackTrace();
            out.print("{\"success\": false, \"message\": \"Failed to retrieve users: " + e.getMessage() + "\"}");
        } finally {
            out.flush();
        }
    }
}
