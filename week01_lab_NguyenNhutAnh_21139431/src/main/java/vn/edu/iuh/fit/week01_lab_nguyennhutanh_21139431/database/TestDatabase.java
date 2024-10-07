package vn.edu.iuh.fit.week01_lab_nguyennhutanh_21139431.database;

import java.sql.*;

public class TestDatabase{
    public static void main(String[] args) {
        try (Connection connection = MariaDBConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM account");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("account_id"));
                System.out.println(resultSet.getString("full_name"));
                System.out.println(resultSet.getString("password"));
                System.out.println(resultSet.getString("email"));
                System.out.println(resultSet.getString("phone"));
                System.out.println(resultSet.getByte("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}