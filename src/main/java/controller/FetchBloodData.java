package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import dao.BloodBankofhospitalDao;
import model.BloodBankofhospitalModel;

public class FetchBloodData extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BloodBankofhospitalDao BLOODBOHDao;

    @Override
    public void init() {
        BLOODBOHDao = new BloodBankofhospitalDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        try {
            String action = request.getParameter("action");
            String hospitalIdStr = request.getParameter("hospitalId");

            if ("hospitalDropdown".equalsIgnoreCase(action)) {
                List<BloodBankofhospitalModel> hospitalsList = BLOODBOHDao.getAllHospitals();
                out.write(gson.toJson(hospitalsList));

            } else if ("fetchAll".equalsIgnoreCase(action)) {
                List<BloodBankofhospitalModel> bloodDataList = BLOODBOHDao.getAllBloodStock();
                out.write(gson.toJson(bloodDataList));

            } else if ("fetchByHospital".equalsIgnoreCase(action)) {
                if (hospitalIdStr != null) {
                    try {
                        int hospitalId = Integer.parseInt(hospitalIdStr);
                        List<BloodBankofhospitalModel> bloodDataList = BLOODBOHDao.getBloodStockByHospital(hospitalId);
                        if (bloodDataList != null && !bloodDataList.isEmpty()) {
                            out.write(gson.toJson(bloodDataList));
                        } else {
                            out.write("[]");  // No blood data found
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        out.write("{\"success\": false, \"message\": \"Invalid hospital ID\"}");
                    }
                } else {
                    out.write("{\"success\": false, \"message\": \"Missing hospital ID\"}");
                }

            } else {
                out.write("{\"success\": false, \"message\": \"Invalid action\"}");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.write("{\"success\": false, \"message\": \"Server error: " + e.getMessage() + "\"}");
        } finally {
            out.close();
        }
    }
}

/*
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * response.setContentType("application/json");
 * response.setCharacterEncoding("UTF-8"); PrintWriter out =
 * response.getWriter(); Gson gson = new Gson();
 * 
 * String action = request.getParameter("action");
 * 
 * try { if ("hospitalDropdown".equalsIgnoreCase(action)) {
 * List<BloodBankofhospitalModel> hospitalsList = BLOODBOHDao.getAllHospitals();
 * String json = gson.toJson(hospitalsList); out.write(json); } else if
 * ("fetchAll".equalsIgnoreCase(action)) { List<BloodBankofhospitalModel>
 * bloodDataList = BLOODBOHDao.getAllBloodStock(); String json =
 * gson.toJson(bloodDataList); out.write(json); } else if
 * ("fetchByHospital".equalsIgnoreCase(action)) { String hospitalIdStr =
 * request.getParameter("hospitalId"); if (hospitalIdStr != null) { int
 * hospitalId = Integer.parseInt(hospitalIdStr); List<BloodBankofhospitalModel>
 * bloodDataList = BLOODBOHDao.getBloodStockByHospital(hospitalId); String json
 * = gson.toJson(bloodDataList); out.write(json); } else { out.write("[]"); } }
 * else { out.write("[]"); // Default empty response if no valid action } }
 * catch (Exception e) { e.printStackTrace(); out.write("[]"); } finally {
 * out.close(); } } }
 */