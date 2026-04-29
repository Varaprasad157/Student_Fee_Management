package util;

import java.sql.*;

public class DBConnection {
    static final String URL = "jdbc:mysql://localhost:3306/fee_management";
    static final String USER = "root";
    static final String PASSWORD = "Varaprasad@157";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}