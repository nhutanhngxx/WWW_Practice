package vn.edu.iuh.fit.week01_lab_nguyennhutanh_21139431.services;

import org.mariadb.jdbc.Connection;
import vn.edu.iuh.fit.week01_lab_nguyennhutanh_21139431.database.MariaDBConnection;
import vn.edu.iuh.fit.week01_lab_nguyennhutanh_21139431.repositories.GrantAccessRepositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GrantAccessDAO implements GrantAccessRepositories {

    MariaDBConnection mariaDBConnection = new MariaDBConnection();

    /**
     * Phương thức isAdmin(String account_id) giúp kiểm tra tài khoản có phải là admin hay không
     * @param account_id là tên tài khoản
     * @return role_id
     */
    @Override
    public String isAdmin(String account_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String result = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = (Connection) mariaDBConnection.getConnection();
            String sql = "SELECT role_id FROM grant_access WHERE account_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getString("role_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        GrantAccessDAO grantAccessDAO = new GrantAccessDAO();
        System.out.println(grantAccessDAO.isAdmin("teo"));
    }

}
