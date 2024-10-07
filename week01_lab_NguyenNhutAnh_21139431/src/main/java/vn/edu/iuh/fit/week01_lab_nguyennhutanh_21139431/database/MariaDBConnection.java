package vn.edu.iuh.fit.week01_lab_nguyennhutanh_21139431.database;

import java.sql.*;

public class MariaDBConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/www_week01";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() throws SQLException {
//        System.out.println("Connecting to MariaDB...");
//        System.out.println("URL: " + URL);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

