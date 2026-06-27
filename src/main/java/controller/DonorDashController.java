package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BloodBankofhospitalModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import dao.DonorDashDao;


public class DonorDashController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DonorDashController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 response.setContentType("application/json");
     response.setCharacterEncoding("UTF-8");
     PrintWriter out = response.getWriter();

     DonorDashDao DonorDAO = new DonorDashDao();  // Use DAO to fetch data
     List<BloodBankofhospitalModel> DonorStockList = DonorDAO.getAllBloodStock();  // Get all blood stock

     // Convert data to JSON using Gson
     Gson gson = new Gson();
     String jsonResponse = gson.toJson(DonorStockList);

     out.print(jsonResponse);  // Send the response
     out.flush();
 }
}