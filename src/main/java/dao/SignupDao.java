package dao;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import model.LoginModel;  // Assuming your model class is SignupModel
	import UTILS.DBConnection;  // Assuming you have a DBConnection utility class for getting the DB connection

	public class SignupDao {

	    // Method to check if the email already exists in the database
	    public boolean checkEmailExistence(String email) {
	        String sql = "SELECT email FROM USERS WHERE email = ?";
	        
	        try (Connection conn = DBConnection.getConnection(); 
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            
	            // Set the email parameter in the query
	            stmt.setString(1, email);
	            
	            // Execute the query
	            ResultSet rs = stmt.executeQuery();
	            
	            // If email already exists, return true
	            if (rs.next()) {
	                return true;  // Email already exists
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return false;  // Email does not exist
	    }

	    // Method to insert a new user into the database
	    public boolean registerUser(LoginModel loginModel) {
	        String sql = "INSERT INTO USERS (FIRSTNAME, LASTNAME, EMAIL, PASSWORD, STATUS) VALUES (?, ?, ?, ?, ?)";

	        try (Connection conn = DBConnection.getConnection(); 
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            
	            // Set parameters for firstName, lastName, email, and password
	            stmt.setString(1, loginModel.getFirstName());
	            stmt.setString(2, loginModel.getLastName());
	            stmt.setString(3, loginModel.getEmail());
	            stmt.setString(4, loginModel.getPassword());  // For security, use a hashed password here instead of plain text
	            stmt.setString(5, loginModel.getStatus());  
	            // Execute the insert query
	            int result = stmt.executeUpdate();

	            // If the result is 1, the user was successfully inserted
	            if (result > 0) {
	                return true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return false;  // User registration failed
	    }
	}

	
	
