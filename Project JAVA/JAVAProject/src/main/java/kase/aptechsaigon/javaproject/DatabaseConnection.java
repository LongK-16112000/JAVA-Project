/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kase.aptechsaigon.javaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Truc
 */
public class DatabaseConnection {
    public static Connection connect() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/quanlynhanvien";  // Đổi với thông tin CSDL thực tế của bạn
            String user = "root"; // Tên người dùng
            String password = "123456";  // Mật khẩu
            
            System.out.println("Connecting database ...");
            // Kết nối đến CSDL
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}
