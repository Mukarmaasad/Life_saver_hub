package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import UTILS.DBConnection;
import model.registrationModel;

public class RegisterDao {
	
	
	
	
	// Method to register or update user data based on email
    public boolean registerOrUpdateUser(registrationModel user) {
        boolean isSuccess = false;

        // Check if the email already exists in the database
        String checkEmailQuery = "SELECT COUNT(*) FROM USERS WHERE USERID = ?";
        String updateQuery = "UPDATE USERS SET DATEOFBIRTH = ?, PHONENO = ?, CITY = ?, ADDRESS = ?, BLOODGROUP = ?, GENDER = ?, STATUS = ? WHERE USERID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkEmailQuery)) {

            checkStmt.setString(1, user.getUserId());
            ResultSet resultSet = checkStmt.executeQuery();
            
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                // Email exists, update the user's data
                try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                    updateStmt.setString(1, user.getDateOfBirth());
                    updateStmt.setString(2, user.getPhoneNo());
                    updateStmt.setString(3, user.getCity());
                    updateStmt.setString(4, user.getAddress());
                    updateStmt.setString(5, user.getBloodGroup());
                    updateStmt.setString(6, user.getGender());
                    updateStmt.setString(7, user.getStatus());  
                    updateStmt.setString(8, user.getUserId());
                    isSuccess = updateStmt.executeUpdate() > 0;
                }
            } 

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSuccess;
    }

    // Method to register a new user in the database
	/*
	 * public boolean registerUser(registrationModel user) { boolean isRegistered =
	 * false;
	 * 
	 * // SQL query to insert a new user into the database String sql =
	 * "INSERT INTO USERS (EMAIL, DATEOFBIRTH, PHONENO, CITY, ADDRESS, BLOODGROUP, GENDER) VALUES (?, ?, ?, ?, ?, ?, ?)"
	 * ;
	 * 
	 * 
	 * try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt =
	 * conn.prepareStatement(sql)) {
	 * 
	 * // Set parameters from the registrationModel object stmt.setString(1,
	 * user.getEmail()); // Email stmt.setString(2, user.getDateOfBirth()); // Date
	 * of birth stmt.setString(3, user.getPhoneNo()); // Phone number
	 * stmt.setString(4, user.getCity()); // City stmt.setString(5,
	 * user.getAddress()); // Address stmt.setString(6, user.getBloodGroup()); //
	 * Blood group stmt.setString(7, user.getGender()); // Gender int result =
	 * stmt.executeUpdate();
	 * 
	 * // If the result is greater than 0, the user was successfully registered
	 * isRegistered = result > 0;
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * return isRegistered; // Return the registration status }
	 */

    // Method to retrieve the list of all users from the database
    public List<registrationModel> getUserList() {
    	String sql = "SELECT \r\n"
    			+ "    U.USERID,\r\n"
    			+ "    U.FIRSTNAME,\r\n"
    			+ "    U.DATEOFBIRTH,\r\n"
    			+ "    U.PHONENO,\r\n"
    			+ "    U.CITY,\r\n"
    			+ "    U.ADDRESS,\r\n"
    			+ "    U.BLOODGROUP,\r\n"
    			+ "    U.GENDER,\r\n"
    			+ "    D.DONATIONDATE\r\n"
    			+ "FROM USERS U\r\n"
    			+ "LEFT JOIN (\r\n"
    			+ "    SELECT USERID, MAX(DONATIONDATE) AS DONATIONDATE\r\n"
    			+ "    FROM DONATIONS\r\n"
    			+ "    GROUP BY USERID\r\n"
    			+ ") D ON U.USERID = D.USERID\r\n"
    			+ "WHERE U.STATUS = 1;";
        List<registrationModel> userList = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet result = stmt.executeQuery()) {

            while (result.next()) {
                registrationModel user = new registrationModel();
                user.setId(result.getInt("USERID"));
                user.setFirstname(result.getString("FIRSTNAME"));             // Email
                user.setDateOfBirth(result.getString("DATEOFBIRTH")); // Date of birth
                user.setPhoneNo(result.getString("PHONENO"));         // Phone number
                user.setCity(result.getString("CITY"));               // City
                user.setAddress(result.getString("ADDRESS"));         // Address
                user.setBloodGroup(result.getString("BLOODGROUP"));  // Blood group
                user.setGender(result.getString("GENDER"));           // Gender
                user.setDonationdate(result.getString("DONATIONDATE"));           // Gender
                if(ageLessThanForty(user)) {
                	userList.add(user);
                }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;  // Return the list of users
    }
    
    public Boolean ageLessThanForty(registrationModel user) {
    	Boolean status = true;
    	String dobStr = user.getDateOfBirth(); // e.g. "1990-05-03"
    	if (dobStr != null && !dobStr.isEmpty()) {
    	    LocalDate birthDate = LocalDate.parse(dobStr); // ISO format only
    	    int age = Period.between(birthDate, LocalDate.now()).getYears();
    	    if (age > 40) {
    	        status = false;
    	    }
    	}
    	return status;
    }

    public static registrationModel getUserById(int userId) {
        		String sql = "SELECT \r\n"
            			+ "    U.USERID,\r\n"
            			+ "    U.EMAIL,\r\n"
            			+ "    U.FIRSTNAME,\r\n"
            			+ "    U.LASTNAME,\r\n"
            			+ "    U.DATEOFBIRTH,\r\n"
            			+ "    U.PHONENO,\r\n"
            			+ "    U.CITY,\r\n"
            			+ "    U.ADDRESS,\r\n"
            			+ "    U.BLOODGROUP,\r\n"
            			+ "    U.GENDER,\r\n"
            			+ "    D.DONATIONDATE,\r\n"
            			+ "	   U.STATUS\r\n"
            			+ "FROM USERS U\r\n"
            			+ "LEFT JOIN (\r\n"
            			+ "    SELECT USERID, MAX(DONATIONDATE) AS DONATIONDATE\r\n"
            			+ "    FROM DONATIONS\r\n"
            			+ "    GROUP BY USERID\r\n"
            			+ ") D ON U.USERID = D.USERID\r\n"
            			+ "WHERE U.USERID = ? ";
        registrationModel user = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId); // ✅ Set parameter before executing

            try (ResultSet result = stmt.executeQuery()) {
                if (result.next()) {
                    user = new registrationModel();
                    user.setId(result.getInt("USERID"));
                    user.setFirstname(result.getString("FIRSTNAME"));
                    user.setLastname(result.getString("LASTNAME"));                   
                    user.setEmail(result.getString("EMAIL"));
                    user.setDateOfBirth(result.getString("DATEOFBIRTH"));
                    user.setPhoneNo(result.getString("PHONENO"));
                    user.setCity(result.getString("CITY"));
                    user.setAddress(result.getString("ADDRESS"));
                    user.setBloodGroup(result.getString("BLOODGROUP"));
                    user.setGender(result.getString("GENDER"));
                    user.setDonationdate(result.getString("DONATIONDATE"));
                    user.setStatus(result.getString("STATUS"));
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user; // ✅ Return a single user object
    }
}