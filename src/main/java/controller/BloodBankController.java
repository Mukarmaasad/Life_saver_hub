package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BloodBankModel;
import model.HospitalDropdownModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import dao.BloodBankDao;

public class BloodBankController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BloodBankDao BBDao;
	private String hospitalId;

    @Override
    public void init() {
        BBDao = new BloodBankDao();
    }

    // POST method to handle blood bank registration
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        try {
            // Convert JSON request to BloodBankModel object
            BloodBankModel blood = gson.fromJson(request.getReader(), BloodBankModel.class);

            if (blood == null) {
                out.print("{\"success\": false, \"message\": \"Invalid user data\"}");
                return;
            }

            // Register user
            int success = BBDao.AddBlood(blood);

            // Response
            if (success == 1) {
                out.print("{\"success\": true, \"message\": \"Add blood detail successfully\"}");
            } else if(success == 0){
            	
            	out.print("{\"success\": true, \"message\": \"bloodgroup already exist quantity update successfully\"}");
            }
            
            else {
                out.print("{\"success\": false, \"message\": \"Database error occurred while registering user\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print("{\"success\": false, \"message\": \"Exception occurred: " + e.getMessage() + "\"}");
        } finally {
            out.flush();
        }
    }

    // GET method to fetch hospital data (for dropdown, etc.)

 
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        String action = request.getParameter("action");

        try {
            if ("hospitalDropdown".equalsIgnoreCase(action)) {
                // ✅ Fetch hospital list
                List<HospitalDropdownModel> hospitalsList = BBDao.getAllHospitals();
                String json = gson.toJson(hospitalsList);
                out.write(json);

            } else if ("hospitalId".equalsIgnoreCase(action)) {
                // ✅ Fetch blood bank data for a specific hospital
                String hospitalId = request.getParameter("hospitalId");

                if (hospitalId != null && !hospitalId.isEmpty()) {
                    List<BloodBankModel> bloodDataList = BBDao.getBloodList(hospitalId);
                    String json = gson.toJson(bloodDataList);
                    out.write(json);
                } else {
                    out.write("[]"); // No hospitalId provided
                }

            } else {
                // Unknown action
                out.write("{\"error\": \"Invalid action parameter\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.write("[]"); // Return empty array on error
        } finally {
            out.close();
        }
    }

}

    
    

