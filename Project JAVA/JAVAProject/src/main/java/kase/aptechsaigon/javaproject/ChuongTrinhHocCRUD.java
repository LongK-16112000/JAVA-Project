/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kase.aptechsaigon.javaproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Truc
 */
public class ChuongTrinhHocCRUD {
    // Thêm chương trình học
     private Connection conn;
    public static void addChuongTrinhHoc(String tenChuongTrinh, int thoiGianHoanThanh) {
        String sql = "INSERT INTO ChuongTrinhHoc (TenChuongTrinh, ThoiGianHoanThanh) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tenChuongTrinh);
            ps.setInt(2, thoiGianHoanThanh);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Chương trình học đã được thêm thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy tất cả chương trình học
    public static void getAllChuongTrinhHoc() {
        String sql = "SELECT * FROM ChuongTrinhHoc";
        
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int maChuongTrinhHoc = rs.getInt("MaChuongTrinhHoc");
                String tenChuongTrinh = rs.getString("TenChuongTrinh");
                int thoiGianHoanThanh = rs.getInt("ThoiGianHoanThanh");

                System.out.println("Mã chương trình học: " + maChuongTrinhHoc);
                System.out.println("Tên chương trình học: " + tenChuongTrinh);
                System.out.println("Thời gian hoàn thành: " + thoiGianHoanThanh + " tháng");
                System.out.println("------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật chương trình học
    public static void updateChuongTrinhHoc(int maChuongTrinhHoc, String tenChuongTrinh, int thoiGianHoanThanh) {
        String sql = "UPDATE ChuongTrinhHoc SET TenChuongTrinh = ?, ThoiGianHoanThanh = ? WHERE MaChuongTrinhHoc = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tenChuongTrinh);
            ps.setInt(2, thoiGianHoanThanh);
            ps.setInt(3, maChuongTrinhHoc);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Chương trình học đã được cập nhật thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa chương trình học
    public static void deleteChuongTrinhHoc(int maChuongTrinhHoc) {
        String sql = "DELETE FROM ChuongTrinhHoc WHERE MaChuongTrinhHoc = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, maChuongTrinhHoc);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Chương trình học đã được xóa thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
