package kase.aptechsaigon.javaproject;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class JAVAProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserCRUD userCRUD = new UserCRUD();

        // Lấy thông tin từ người dùng
        System.out.print("Nhap ho ten nguoi dung: ");
        String hoTen = scanner.nextLine();  // Sử dụng hoTen thay vì username
        System.out.print("Nhap mat khau: ");
        String matKhau = scanner.nextLine(); // Sử dụng matKhau thay vì password

        // Kiểm tra thông tin đăng nhập
        if (userCRUD.checkUserCredentials(hoTen, matKhau)) {
            JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
        } else {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        
        scanner.close();
    }
}
