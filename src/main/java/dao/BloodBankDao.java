package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import UTILS.DBConnection;
import model.BloodBankModel;

import model.HospitalDropdownModel;


public class BloodBankDao {

	  // Method to register a user in the database
	public int AddBlood(BloodBankModel blood) {
	    int result = 0;

	    String checkSql = "SELECT COUNT(*) FROM BLOODBANKOFHOSPITAL WHERE HOSPITALID = ? AND BLOODTYPE = ?";
	    String insertSql = "INSERT INTO BLOODBANKOFHOSPITAL (HOSPITALID, BLOODTYPE, QUANTITY) VALUES (?, ?, ?)";
	    String updateSql = "UPDATE BLOODBANKOFHOSPITAL SET QUANTITY = QUANTITY + ? WHERE HOSPITALID = ? AND BLOODTYPE = ?";

	    try (Connection conn = DBConnection.getConnection()) {
	        // Step 1: Check if record exists
	        try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
	            checkStmt.setString(1, blood.getHospitalId());
	            checkStmt.setString(2, blood.getBloodGroupInsert());
	            ResultSet rs = checkStmt.executeQuery();
	            if (rs.next() && rs.getInt(1) > 0) {
	                // Step 2: Record exists, update quantity
	                try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
	                    updateStmt.setInt(1, blood.getQuantityInsert());
	                    updateStmt.setString(2, blood.getHospitalId());
	                    updateStmt.setString(3, blood.getBloodGroupInsert());
	                    if (updateStmt.executeUpdate() > 0) {
	                        result = 0; // Updated
	                    }
	                }
	            } else {
	                // Step 3: Record doesn't exist, insert new
	                try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
	                    insertStmt.setString(1, blood.getHospitalId());
	                    insertStmt.setString(2, blood.getBloodGroupInsert());
	                    insertStmt.setInt(3, blood.getQuantityInsert());
	                    if (insertStmt.executeUpdate() > 0) {
	                        result = 1; // Inserted
	                    }
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return result;
	}

 // Method to fetch all hospitals for the Dropdown
    public List<HospitalDropdownModel> getAllHospitals() {
        List<HospitalDropdownModel> hospitalsList = new ArrayList<HospitalDropdownModel>();
        String sql = "SELECT * FROM HOSPITALS where HOSPITALNAME <> '' ";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
            	HospitalDropdownModel hospital = new HospitalDropdownModel();
                hospital.setHospitalId(rs.getString("HOSPITALID"));
                hospital.setHospitalName(rs.getString("HOSPITALNAME"));
                hospitalsList.add(hospital);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospitalsList;
    }


    public List<BloodBankModel> getHospital(String hospitalname, String hospitalId) {
    	StringBuilder sql = new StringBuilder("SELECT bb.BLOODTYPE, bb.QUANTITY, bb.HOSPITALID, h.HOSPITALNAME ");
    	sql.append("FROM BLOODBANKOFHOSPITAL bb ");
    	sql.append("INNER JOIN HOSPITALS h ON bb.HOSPITALID = h.HOSPITALID WHERE 1=1");

        // Add conditions based on inputs
        if (hospitalId != null && !hospitalId.isEmpty()) {
            sql.append(" AND bb.HOSPITALID = ?");
        }
        if (hospitalname != null && !hospitalname.isEmpty()) {
            sql.append(" AND h.HOSPITALNAME = ?");
        }

        List<BloodBankModel> hospitalList = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

            int index = 1;
            if (hospitalId != null && !hospitalId.isEmpty()) {
                stmt.setString(index++, hospitalId);
            }
            if (hospitalname != null && !hospitalname.isEmpty()) {
                stmt.setString(index++, hospitalname);
            }

            try (ResultSet result = stmt.executeQuery()) { // Properly handle ResultSet
                while (result.next()) {
                    BloodBankModel bloodBankModel = new BloodBankModel();
                    bloodBankModel.setBloodGroupInsert(result.getString("BLOODTYPE")); // Assuming BLOODTYPE is a string
                    bloodBankModel.setQuantityInsert(result.getInt("QUANTITY"));
                    bloodBankModel.setHospitalId(result.getString("HOSPITALID"));
                    bloodBankModel.setHospitalName(result.getString("HOSPITALNAME")); // Make sure to fetch hospital name
                    hospitalList.add(bloodBankModel);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hospitalList;
    }
    
    
    
    // Method to get a list of users from the database
    public List<BloodBankModel> getBloodList(String hospitalId) {
        StringBuilder sql = new StringBuilder("SELECT bb.BLOODBANKID, bb.BLOODTYPE, bb.QUANTITY, bb.HOSPITALID, h.HOSPITALNAME ");
        sql.append("FROM BLOODBANKOFHOSPITAL bb ");
        sql.append("INNER JOIN HOSPITALS h ON bb.HOSPITALID = h.HOSPITALID WHERE bb.HOSPITALID = ?");

        List<BloodBankModel> bloodList = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
            stmt.setString(1, hospitalId);


            // ✅ Set parameter value here, not in try declaration
         

            try (ResultSet result = stmt.executeQuery()) {
                while (result.next()) {
                    BloodBankModel bloodModel = new BloodBankModel();
                    bloodModel.setBloodbankid(result.getInt("BLOODBANKID"));
                    bloodModel.setBloodGroupInsert(result.getString("BLOODTYPE"));
                    bloodModel.setQuantityInsert(result.getInt("QUANTITY"));
                    bloodModel.setHospitalId(result.getString("HOSPITALID"));
                    bloodModel.setHospitalName(result.getString("HOSPITALNAME"));
                    bloodList.add(bloodModel);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bloodList;
    }

    
    public boolean updateBloodQuantityById(int bloodBankId, int newQuantity) {
        String query = "UPDATE BLOODBANKOFHOSPITAL SET QUANTITY = QUANTITY + 1 WHERE BLOODBANKID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, bloodBankId); // ✅ Only one parameter is needed now

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean MinusBloodQuantityById(int bloodBankId, int newQuantity) {
        String query = "UPDATE BLOODBANKOFHOSPITAL SET QUANTITY = QUANTITY - 1 WHERE BLOODBANKID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, bloodBankId); // ✅ Only one parameter is needed now

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    
    
	}


