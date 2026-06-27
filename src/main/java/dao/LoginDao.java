package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import UTILS.DBConnection;
import model.LoginModel;

public class LoginDao {

    public LoginModel validateUser(LoginModel login) {
        
        String sql = "SELECT * FROM USERS us left join ADMINUSER au on au.USERID = us.USERID"
        		+ "  WHERE PASSWORD = ? AND EMAIL = ? ";
        LoginModel loginModel = new LoginModel();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);    
            // Set the parameters
            stmt.setString(1, login.getPassword());
            stmt.setString(2, login.getEmail());
            
            // Execute the query
            ResultSet result = stmt.executeQuery();
           
    	 while (result.next()) {
                    
                     loginModel.setEmail(result.getString("EMAIL")); // Assuming BLOODTYPE is a string
                     loginModel.setFirstName(result.getString("FIRSTNAME"));
                     loginModel.setLastName(result.getString("LASTNAME"));
                     loginModel.setUserId(result.getString("USERID")); // Make sure to fetch hospital name
                     loginModel.setAdminId(result.getInt("ADMINID"));
                     loginModel.setHospitalId(result.getInt("HOSPITALID"));
    	 } 
            return loginModel;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return loginModel;
    }
}
