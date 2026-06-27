package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class logoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public logoutController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get the session, don't create a new one if it doesn't exist
        HttpSession session = request.getSession(false);
        if (session != null) {
            // Destroy the session
            session.invalidate();
        }

        // Redirect to login page
        response.sendRedirect("index.jsp");
    }

}
