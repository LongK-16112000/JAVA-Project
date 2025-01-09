/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kase.aptechsaigon.javaproject;


/**
 *
 * @author Truc
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserCRUD {
    private static final String URL = "jdbc:mysql://localhost:3307/my_database"; // Co so du lieu my_database
    private static final String USER = "root";  // Thay ten nguoi dung MySQL
    private static final String PASSWORD = "123456";  // Thay mat khau MySQL

    private Connection connection;

    public UserCRUD() throws SQLException {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new SQLException("Khong the ket noi den co so du lieu", e);
        }
    }

    // Create - Them nguoi dung moi
    public void createUser(User user) throws SQLException {
        String sql = "INSERT INTO user (username, password, fullName) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.executeUpdate();
        }
    }

    // Read - Lay tat ca nguoi dung
    public List<User> getAllUsers() throws SQLException {
        List<User> user = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                user.add(new User(username, password, fullName));
            }
        }
        return user;
    }

    // Update - Cap nhat thong tin nguoi dung
    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE user SET password = ?, fullName = ? WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getFullName());
            statement.setString(3, user.getUsername());
            statement.executeUpdate();
        }
    }

    // Delete - Xoa nguoi dung
    public void deleteUser(String username) throws SQLException {
        String sql = "DELETE FROM user WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.executeUpdate();
        }
    }

    // Dong ket noi
    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
            System.out.println("Thêm text tại UserCRUD");
        }
    }

    
}
