package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Success extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Success() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		PrintWriter pw=response.getWriter();
		String f=request.getParameter("fir");
		pw.println("Your First Name" +f);
		String l=request.getParameter("last");
		pw.println("Your First Name" +l);
		String e=request.getParameter("email");
		pw.println("Your First Name" +e);
		String p=request.getParameter("pass");
		pw.println("Your First Name" +p);
        pw.println("<p>If you have an account, click <a href='index.jsp'>Login</a> to log in.</p>");
		pw.close();
		
	}

}
