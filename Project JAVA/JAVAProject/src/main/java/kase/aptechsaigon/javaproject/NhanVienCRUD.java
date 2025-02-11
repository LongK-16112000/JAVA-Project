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
    public static void addNhanVien(String tenNhanVien, Date ngaySinh, int soCMT, String diaChi, String Email, int dienThoai, Date ngayVaoLam) {
        String sql = "INSERT INTO NhanVien (HoTen, NgaySinh, SoCMT, DiaChi, Email, DienThoai, NgayVaoLam, MatKhau, MaPhucVu, MaPhongBan) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tenNhanVien);
            ps.setDate(2, ngaySinh);
            ps.setInt(3, soCMT);
            ps.setString(4, diaChi);
            ps.setString(5, Email);
            ps.setInt(6, dienThoai);
            ps.setDate(7, ngayVaoLam);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Nhân viên đã được thêm thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy tất cả nhân viên
    public static void getAllNhanVien() {
        String sql = "SELECT * FROM NhanVien";
        
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int maNhanVien = rs.getInt("MaNhanVien");
                String tenNhanVien = rs.getString("HoTen");
                Date ngaySinh = rs.getDate("NgaySinh");
                int soCMT = rs.getInt("SoCMT");
                String diaChi = rs.getString("DiaChi");
                String Email = rs.getString("Email");
                int dienThoai = rs.getInt("DienThoai");
                Date ngayVaoLam = rs.getDate("NgayVaoLam");

                System.out.println("Mã nhân viên: " + maNhanVien);
                System.out.println("Tên nhân viên: " + tenNhanVien);
                System.out.println("Ngày sinh: " + ngaySinh);
                System.out.println("Số CMT: " + soCMT);
                System.out.println("Địa chỉ: " + diaChi);
                System.out.println("Email: " + Email);
                System.out.println("Số điện thoại: " + dienThoai);
                System.out.println("Ngày vào làm: " + ngayVaoLam);
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
