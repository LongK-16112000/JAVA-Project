package kase.aptechsaigon.javaproject;

import java.sql.*;


public class UserCRUD {
   // Thông tin kết nối cơ sở dữ liệu
    private static final String URL = "jdbc:mysql://localhost:3307/quanlynhanvien";  // Thay đổi theo cơ sở dữ liệu của bạn
    private static final String USER = "root";  // Thay đổi tên người dùng nếu cần
    private static final String PASSWORD = "123456";  // Thay đổi mật khẩu nếu cần

    // Phương thức lấy kết nối
    public static Connection getConnection() throws SQLException {
        try {
            // Tải driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Trả về kết nối
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new SQLException("Không thể kết nối tới cơ sở dữ liệu", e);
        }
    }
    // Kiểm tra thông tin người dùng
     // Chuyển checkUserCredentials thành phương thức tĩnh
    public static boolean checkUserCredentials(String hoTen, String matKhau) {
        String query = "SELECT * FROM nhanvien WHERE HoTen = ? AND MatKhau = ?";

        try (Connection conn = UserCRUD.getConnection();  // Đảm bảo bạn đã import DatabaseUtils
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, hoTen);
            ps.setString(2, matKhau);

            ResultSet rs = ps.executeQuery();
            return rs.next();  // Nếu có kết quả trả về, người dùng hợp lệ
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}