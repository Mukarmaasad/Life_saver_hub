package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import UTILS.DBConnection;
import model.DonationsModel;

public class DonationsDao {

	// Method to register a user in the database
    public int DonateBlood(DonationsModel donate) {
        int result = 0;
               // String checkSql = "SELECT COUNT(*) FROM BLOODBANKOFHOSPITAL WHERE HOSPITALID = ? AND BLOODTYPE = ?";
        String sql = "INSERT INTO DONATIONS (USERID,HOSPITALID,UNITSOFBLOOD) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, donate.getUserid());
            stmt.setString(2, donate.getHospitalid());
            stmt.setInt(3, donate.getUnitsofblood());


            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

 // Method to fetch all hospitals for the Dropdown
    public List<DonationsModel> getAllHospitals() {
        List<DonationsModel> hospitalsList = new ArrayList<DonationsModel>();
        String sql = "SELECT * FROM HOSPITALS where HOSPITALNAME <> '' ";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
            	DonationsModel hospital = new DonationsModel();
                hospital.setHospitalid(rs.getString("HOSPITALID"));
                hospital.setHospitalName(rs.getString("HOSPITALNAME"));
                hospitalsList.add(hospital);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospitalsList;
    }


    public List<DonationsModel> getHospital(String hospitalname, String hospitalid) {
        StringBuilder sql = new StringBuilder("SELECT bb.BLOODTYPE, bb.QUANTITY, bb.HOSPITALID, h.HOSPITALNAME ");
        sql.append("FROM BLOODBANKOFHOSPITAL bb ");
        sql.append("INNER JOIN HOSPITAL h ON bb.HOSPITALID = h.HOSPITALID WHERE 1=1");

        // Add conditions based on inputs
        if (hospitalid != null && !hospitalid.isEmpty()) {
            sql.append(" AND bb.HOSPITALID = ?");
        }
        if (hospitalname != null && !hospitalname.isEmpty()) {
            sql.append(" AND h.HOSPITALNAME = ?");
        }

        List<DonationsModel> hospitalList = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

            int index = 1;
            if (hospitalid != null && !hospitalid.isEmpty()) {
                stmt.setString(index++, hospitalid);
            }
            if (hospitalname != null && !hospitalname.isEmpty()) {
                stmt.setString(index++, hospitalname);
            }

            try (ResultSet result = stmt.executeQuery()) { // Properly handle ResultSet
                while (result.next()) {
                	DonationsModel bloodBankModel = new DonationsModel();
                    bloodBankModel.setUnitsofblood(result.getInt("UNITSOFBLOOD"));
                    bloodBankModel.setHospitalid(result.getString("HOSPITALID"));
                    bloodBankModel.setHospitalName(result.getString("HOSPITALNAME"));

                    hospitalList.add(bloodBankModel);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hospitalList;
    }
    
    
 // Method to get a list of donations from the database
    public List<DonationsModel> getDonationList(int userId) {
        String sql = "SELECT D.UNITSOFBLOOD, D.HOSPITALID, D.DONATIONDATE, " +
                     "H.HOSPITALNAME, U.FIRSTNAME, U.LASTNAME, U.BLOODGROUP " +
                     "FROM DONATIONS D " +
                     "INNER JOIN HOSPITALS H ON D.HOSPITALID = H.HOSPITALID " +
                     "INNER JOIN USERS U ON D.USERID = U.USERID " +
                     "WHERE D.USERID = ?";

        List<DonationsModel> donationsList = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, userId);
            try (ResultSet result = stmt.executeQuery()) {
                while (result.next()) {
                    DonationsModel donationsModel = new DonationsModel();
                    donationsModel.setHospitalid(result.getString("HOSPITALID"));
                    donationsModel.setHospitalName(result.getString("HOSPITALNAME"));
                    donationsModel.setUnitsofblood(result.getInt("UNITSOFBLOOD"));
                    donationsModel.setFirstname(result.getString("FIRSTNAME"));
                    donationsModel.setLastname(result.getString("LASTNAME"));
                    donationsModel.setBloodgroup(result.getString("BLOODGROUP"));
                    donationsModel.setDonationDate(result.getString("DONATIONDATE"));

                    donationsList.add(donationsModel);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return donationsList;
    }
}
	/*
	 * public List<DonationsModel> getDonoationList(int userId) { String sql =
	 * "SELECT D.UNITSOFBLOOD, D.HOSPITALID,D.DONATIONDATE, H.HOSPITALNAME, U.FIRSTNAME,  U.LASTNAME,  U.BLOODGROUP FROM  DONATIONS D INNER JOIN HOSPITALS H ON D.HOSPITALID = H.HOSPITALID INNER JOIN USERS U ON D.USERID = U.USERID"
	 * ;
	 * 
	 * List<DonationsModel> donationsList = new ArrayList<>();
	 * 
	 * try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt =
	 * conn.prepareStatement(sql){ stmt.setInt(1, userId);
	 * 
	 * ResultSet result = stmt.executeQuery()) {
	 * 
	 * while (result.next()) { DonationsModel donationsModel = new DonationsModel();
	 * donationsModel.setHospitalid(result.getString("HOSPITALID"));
	 * donationsModel.setHospitalName(result.getString("HOSPITALNAME")); // ✅ Fix
	 * here donationsModel.setUnitsofblood(result.getInt("UNITSOFBLOOD"));
	 * 
	 * donationsModel.setFirstname(result.getString("FIRSTNAME"));
	 * donationsModel.setLastname(result.getString("LASTNAME"));
	 * donationsModel.setBloodgroup(result.getString("BLOODGROUP"));
	 * donationsModel.setDonationDate(result.getString("DONATIONDATE"));
	 * 
	 * 
	 * 
	 * donationsList.add(donationsModel); } } }catch (SQLException e) {
	 * e.printStackTrace(); } return donationsList; } }
	 */



           