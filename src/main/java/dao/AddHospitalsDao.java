package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import UTILS.DBConnection;
import model.AddHospitalsModel;

public class AddHospitalsDao {

    // Method to register a user in the database
    public int registerUser(AddHospitalsModel user) {
        int result = 0;
        String sql = "INSERT INTO HOSPITALS (HOSPITALNAME,ADDRESS,CONTACTNUMBER) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getHospitalName());
            stmt.setString(2, user.getAddress());
            stmt.setString(3, user.getContactNo());

            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Method to get a list of users from the database
    public List<AddHospitalsModel> getUserList() {
        String sql = "SELECT * FROM HOSPITALS";
        List<AddHospitalsModel> userList = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet result = stmt.executeQuery()) {

            while (result.next()) {
                AddHospitalsModel HModel = new AddHospitalsModel();
                HModel.setHospitalid(result.getInt("HOSPITALID"));

                HModel.setHospitalName(result.getString("HOSPITALNAME"));
                HModel.setAddress(result.getString("ADDRESS"));
                HModel.setContactNo(result.getString("CONTACTNUMBER"));

                userList.add(HModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
