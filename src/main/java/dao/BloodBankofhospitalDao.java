package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import UTILS.DBConnection;
import model.BloodBankofhospitalModel;

public class BloodBankofhospitalDao {

    // Method to get all blood stock records from the database
    public List<BloodBankofhospitalModel> getAllBloodStock() {
        List<BloodBankofhospitalModel> bloodStockList = new ArrayList<>();

        // SQL query to fetch blood stock data with aggregation
        String query = "SELECT bb.BLOODTYPE, SUM(bb.QUANTITY) AS totalQuantity "
                     + "FROM BLOODBANKOFHOSPITAL bb "
                     + "WHERE bb.BLOODTYPE IS NOT NULL "
                     + "AND bb.QUANTITY IS NOT NULL "
                     + "GROUP BY bb.BLOODTYPE;";

        // Using try-with-resources for automatic resource management
        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            // Process the result set and populate the bloodStockList
            while (rs.next()) {
                BloodBankofhospitalModel bloodBank = new BloodBankofhospitalModel();
                bloodBank.setBloodType(rs.getString("BLOODTYPE"));
                bloodBank.setQuantity(rs.getInt("totalQuantity"));
                bloodStockList.add(bloodBank);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Return the list of blood stock records
        return bloodStockList;
    }
    
    
 // Method to fetch all hospitals for the Dropdown
    public List<BloodBankofhospitalModel> getAllHospitals() {
        List<BloodBankofhospitalModel> hospitalsList = new ArrayList<BloodBankofhospitalModel>();
        String sql = "SELECT * FROM HOSPITALS where HOSPITALNAME <> '' ";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
            	BloodBankofhospitalModel hospital = new BloodBankofhospitalModel();
                hospital.setHospitalId(rs.getInt("HOSPITALID"));
                hospital.setHospitalName(rs.getString("HOSPITALNAME"));
                hospitalsList.add(hospital);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospitalsList;
    }

    public List<BloodBankofhospitalModel> getBloodStockByHospital(int hospitalId) {
        List<BloodBankofhospitalModel> bloodStockList = new ArrayList<>();
        
        String query = "SELECT bb.BLOODTYPE, SUM(bb.QUANTITY) AS totalQuantity "
                     + "FROM BLOODBANKOFHOSPITAL bb "
                     + "WHERE bb.HOSPITALID = ? "
                     + "AND bb.BLOODTYPE IS NOT NULL "
                     + "AND bb.QUANTITY IS NOT NULL "
                     + "GROUP BY bb.BLOODTYPE;";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {
            
            stmt.setInt(1, hospitalId);  // Set the hospitalId in the query
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                BloodBankofhospitalModel bloodBank = new BloodBankofhospitalModel();
                bloodBank.setBloodType(rs.getString("BLOODTYPE"));
                bloodBank.setQuantity(rs.getInt("totalQuantity"));
                bloodStockList.add(bloodBank);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return bloodStockList;
    }
    
}
