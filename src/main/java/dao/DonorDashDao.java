package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import UTILS.DBConnection;
import model.BloodBankofhospitalModel;

public class DonorDashDao {
	
	// Method to get all blood stock records from the database
    public List<BloodBankofhospitalModel> getAllBloodStock() {
        List<BloodBankofhospitalModel> DonorStockList = new ArrayList<>();

        // Using try-with-resources for automatic resource management
        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement("SELECT BLOODGROUP, COUNT(*) AS quantity FROM USERS WHERE BLOODGROUP IS NOT NULL GROUP BY BLOODGROUP");
             ResultSet rs = stmt.executeQuery()) {

            // Process the result set and populate the bloodStockList
            while (rs.next()) {
                BloodBankofhospitalModel bloodBank = new BloodBankofhospitalModel();
                bloodBank.setBloodType(rs.getString("BLOODGROUP"));
                bloodBank.setQuantity(rs.getInt("QUANTITY"));

                DonorStockList.add(bloodBank);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Return the list of blood stock records
        return DonorStockList;
    }

}
