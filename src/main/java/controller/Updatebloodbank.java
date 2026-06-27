package controller;

import com.google.gson.Gson;
import dao.BloodBankDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BloodBankofhospitalModel;

import java.io.IOException;
import java.io.PrintWriter;

public class Updatebloodbank extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BloodBankDao bloodBankDao;

    @Override
    public void init() throws ServletException {
        bloodBankDao = new BloodBankDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print("{\"message\": \"Use POST to update blood quantity.\"}");
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        try {
            BloodBankofhospitalModel requestModel = gson.fromJson(request.getReader(), BloodBankofhospitalModel.class);
            String action = request.getParameter("action");

            boolean isUpdated = false;

            if (requestModel != null && requestModel.getBloodbankid() > 0) {
                if ("decrease".equalsIgnoreCase(action)) {
                    // Call method to subtract 1
                    isUpdated = bloodBankDao.MinusBloodQuantityById(requestModel.getBloodbankid(), requestModel.getQuantity());
                } else {
                    // Default: Call method to add 1
                    isUpdated = bloodBankDao.updateBloodQuantityById(requestModel.getBloodbankid(), requestModel.getQuantity());
                }

                if (isUpdated) {
                    out.print("{\"success\": true, \"message\": \"Blood quantity updated successfully\"}");
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    out.print("{\"success\": false, \"message\": \"Blood bank ID not found or no update\"}");
                }
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.print("{\"success\": false, \"message\": \"Invalid input data\"}");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print("{\"success\": false, \"message\": \"Exception occurred: " + e.getMessage() + "\"}");
        } finally {
            out.flush();
        }
    }
}
