package controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.registrationModel;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import dao.RegisterDao;


public class ProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        registrationModel user = RegisterDao.getUserById(userId); // ✅ call DAO properly

        if (user != null) {
        	 String json = gson.toJson(user);
             out.write(json);
        } else {
            response.getWriter().println("User not found.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
