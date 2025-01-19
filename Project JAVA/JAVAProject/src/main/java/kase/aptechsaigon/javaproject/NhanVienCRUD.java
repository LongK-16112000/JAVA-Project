/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kase.aptechsaigon.javaproject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class NhanVienCRUD {
    // Thêm Nhân viên
     private Connection conn;
    public static void addNhanVien(String tenNhanVien, Date ngaySinh) {
        String sql = "INSERT INTO NhanVien (HoTen, NgaySinh) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tenNhanVien);
            ps.setDate(2, ngaySinh);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Nhân viên đã được thêm thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy tất cả chương trình học
    public static void getAllNhanVien() {
        String sql = "SELECT * FROM NhanVien";
        
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int maNhanVien = rs.getInt("MaNhanVien");
                String tenNhanVien = rs.getString("HoTen");
                Date ngaySinh = rs.getDate("NgaySinh");

                System.out.println("Mã nhân viên: " + maNhanVien);
                System.out.println("Tên nhân viên: " + tenNhanVien);
                System.out.println("Thời gian hoàn thành: " + ngaySinh + " tháng");
                System.out.println("------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật chương trình học
    public static void updateNhanVien(int maNhanVien, String tenNhanVien, Date ngaySinh) {
        String sql = "UPDATE NhanVien SET HoTen = ?, NgaySinh = ? WHERE MaNhanVien = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tenNhanVien);
            ps.setDate(2, ngaySinh);
            ps.setInt(3, maNhanVien);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Nhân viên đã được cập nhật thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa chương trình học
    public static void deleteNhanVien(int maNhanVien) {
        String sql = "DELETE FROM NhanVien WHERE MaNhanVien = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, maNhanVien);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Nhân viên đã được xóa thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
