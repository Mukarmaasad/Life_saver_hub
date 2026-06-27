


package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DonationsModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import dao.DonationsDao;


public class DonationsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DonationsDao DSDao;

    @Override
    public void init() {
    	DSDao = new DonationsDao();
    }

  
    public DonationsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        String action = request.getParameter("action1");
        if ("HOSPITALSDW".equalsIgnoreCase(action)) {
            try {
                // Get the list of hospitals from the DAO
                List<DonationsModel> hospitalsList = DSDao.getAllHospitals();

                // Convert the hospital list to JSON
                String json = gson.toJson(hospitalsList);
                out.write(json);
            } catch (Exception e) {
                e.printStackTrace();
                out.write("[]");
            } finally {
                out.close();
            }
        } String action1 = request.getParameter("action");
        if ("userId".equalsIgnoreCase(action1)) {
            String userIdParam = request.getParameter("userId");

            try {
                int userId = Integer.parseInt(userIdParam);

                // Fetch the data from your database or some source
                List<DonationsModel> donationDataList = DSDao.getDonationList(userId);
                if (donationDataList != null && !donationDataList.isEmpty()) {
                    String json = gson.toJson(donationDataList);
                    out.write(json);
                } else {
                    // If no data, return an empty array
                    out.write("[]");
                }
            } catch (Exception e) {
                e.printStackTrace();
                out.write("[]"); // Return an empty array on error
            } finally {
                out.close();
            }
    }
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        try {
            // Convert JSON request to BloodBankModel object
        	DonationsModel donate = gson.fromJson(request.getReader(), DonationsModel.class);

            if (donate == null) {
                out.print("{\"success\": false, \"message\": \"Invalid user data\"}");
                return;
            }

            // Register user
            int success = DSDao.DonateBlood(donate);

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
	}