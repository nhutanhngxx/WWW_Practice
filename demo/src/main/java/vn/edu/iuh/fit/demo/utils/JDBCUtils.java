package vn.edu.iuh.fit.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ACER on 9/5/2024.
 */

public class JDBCUtils {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/demo";
    private static String username = "root";
    private static String password = "123456";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
