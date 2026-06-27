package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import UTILS.DBConnection;
import model.HospitalDropdownModel;
import model.LoginModel;
import model.hospitalusersModel;

public class hospitalusersDao {

	
	 // Method to register a user in the database
    public int registerhospitalUsers(hospitalusersModel Hospitaluser) {
        int result = 0;
        String sql = "INSERT INTO ADMINUSER (USERID,HOSPITALID) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
        	
            stmt.setInt(1, Hospitaluser.getUserid());
            stmt.setInt(2, Hospitaluser.getHospitalid());

            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    
    
    
    
//Method to fetch all hospitals for the Dropdown.
public List<HospitalDropdownModel> Dropdownuserhospital() {
    List<HospitalDropdownModel> hospitalsdropdown = new ArrayList<HospitalDropdownModel>();
    String sql = "SELECT * FROM HOSPITALS where HOSPITALNAME <> '' ";

    try (Connection conn = DBConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
        	HospitalDropdownModel hospital = new HospitalDropdownModel();
            hospital.setHospitalId(rs.getString("HOSPITALID"));
            hospital.setHospitalName(rs.getString("HOSPITALNAME"));
            hospitalsdropdown.add(hospital);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return hospitalsdropdown;
}





public List<LoginModel> getAllUsers() {
    List<LoginModel> users = new ArrayList<>();
    String sql = "SELECT * FROM USERS where FIRSTNAME <> '' ";

    try (Connection conn = DBConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
        	LoginModel user = new LoginModel();
            user.setUserId(rs.getString("USERID"));
            user.setFirstName(rs.getString("FIRSTNAME"));  // assuming your model has setUser()
            users.add(user);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return users;
}
}