package dao;

import java.sql.*;
import java.util.*;

import model.Student;
import util.DBConnection;

public class StudentDAO {

    public void addStudent(Student s) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO students VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getCourse());
            ps.setDouble(4, s.getTotalFee());
            ps.setDouble(5, s.getPaidFee());

            ps.executeUpdate();
            System.out.println("Student Added!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Student getStudent(String id) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM students WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("course"),
                        rs.getDouble("total_fee"),
                        rs.getDouble("paid_fee")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateFee(String id, double amount) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "UPDATE students SET paid_fee = paid_fee + ? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, amount);
            ps.setString(2, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(String id) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "DELETE FROM students WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);

            ps.executeUpdate();
            System.out.println("Deleted Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                list.add(new Student(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("course"),
                        rs.getDouble("total_fee"),
                        rs.getDouble("paid_fee")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}