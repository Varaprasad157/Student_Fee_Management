package dao;

import java.sql.*;
import java.util.*;

import model.Receipt;
import util.DBConnection;

public class ReceiptDAO {

    public void addReceipt(String studentId, double amount) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO receipts(student_id, amount) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, studentId);
            ps.setDouble(2, amount);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Receipt> getLast3Receipts(String studentId) {
        List<Receipt> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM receipts WHERE student_id=? ORDER BY date DESC LIMIT 3";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, studentId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Receipt(
                        rs.getInt("id"),
                        rs.getString("student_id"),
                        rs.getDouble("amount"),
                        rs.getString("date")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}