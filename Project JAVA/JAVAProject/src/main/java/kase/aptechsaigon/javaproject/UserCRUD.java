package kase.aptechsaigon.javaproject;

import java.sql.*;

public class UserCRUD {
    
    // Lưu trữ kết nối cơ sở dữ liệu (sử dụng instance thay vì static connection)
    private Connection conn;

    // Constructor mở kết nối tới cơ sở dữ liệu
    public UserCRUD() {
        try {
            this.conn = DatabaseConnection.connect();  // Đảm bảo rằng bạn có lớp DatabaseConnection để mở kết nối
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy kết nối từ DatabaseConnection (phương thức tĩnh)
    public static Connection getConnection() throws SQLException {
        return DatabaseConnection.connect();  // Sử dụng DatabaseConnection để kết nối
    }

    // Kiểm tra thông tin người dùng
    public static boolean checkUserCredentials(String hoTen, String matKhau) {
        String query = "SELECT * FROM nhanvien WHERE HoTen = ? AND MatKhau = ?";
        
        try (Connection conn = UserCRUD.getConnection();  // Lấy kết nối từ phương thức getConnection
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            // Thiết lập các tham số trong câu lệnh SQL
            ps.setString(1, hoTen);
            ps.setString(2, matKhau);

            // Thực thi câu lệnh truy vấn
            ResultSet rs = ps.executeQuery();
            
            // Nếu có kết quả trả về, tức là người dùng hợp lệ
            return rs.next();  
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Các phương thức CRUD khác cho các bảng khác sẽ tương tự với cách này
}
