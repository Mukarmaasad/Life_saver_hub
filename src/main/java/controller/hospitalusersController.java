package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.HospitalDropdownModel;
import model.LoginModel;
import model.hospitalusersModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import dao.hospitalusersDao;


public class hospitalusersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	 private hospitalusersDao HUDao;

	    @Override
	    public void init() {
	    	HUDao = new hospitalusersDao();
	    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("application/json");
	        PrintWriter out = response.getWriter();
	        Gson gson = new Gson();

	        try {
	            // Convert JSON request to BloodBankModel object
	            hospitalusersModel Hospitaluser = gson.fromJson(request.getReader(), hospitalusersModel.class);

	            if (Hospitaluser == null) {
	                out.print("{\"success\": false, \"message\": \"Invalid user data\"}");
	                return;
	            }

	            // Register user
	            int success = HUDao.registerhospitalUsers(Hospitaluser);

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

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        String action = request.getParameter("action");
        if ("UserDropdown".equalsIgnoreCase(action)) {
            List<LoginModel> users = HUDao.getAllUsers();
            out.write(gson.toJson(users));}
            else if ("UserhospitalDropdown".equalsIgnoreCase(action)) {
            try {
                // Get the list of hospitals from the DAO
                List<HospitalDropdownModel> hospitalsList = HUDao.Dropdownuserhospital();

                // Convert the hospital list to JSON
                String json = gson.toJson(hospitalsList);
                out.write(json);
            } catch (Exception e) {
                e.printStackTrace();
                out.write("[]");
            } finally {
                out.close();
            }
	}


}
}
