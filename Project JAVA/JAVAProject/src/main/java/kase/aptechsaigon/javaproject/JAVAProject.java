/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kase.aptechsaigon.javaproject;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 
 * @author Windows
 */
public class JAVAProject {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        UserCRUD userCRUD = null;

        userCRUD = new UserCRUD();
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them nguoi dung (Create)");
            System.out.println("2. Xem danh sach nguoi dung (Read)");
            System.out.println("3. Cap nhat thong tin nguoi dung (Update)");
            System.out.println("4. Xoa nguoi dung (Delete)");
            System.out.println("5. Thoat");
            System.out.print("Chon chuc nang: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Doc ky tu moi dong
            
            switch (choice) {
                case 1:
                    // Them nguoi dung moi
                    System.out.print("Nhap ten nguoi dung: ");
                    String username = scanner.nextLine();
                    System.out.print("Nhap mat khau: ");
                    String password = scanner.nextLine();
                    System.out.print("Nhap ten day du: ");
                    String fullName = scanner.nextLine();
                    userCRUD.createUser(new User(username, password, fullName));
                    break;
                    
                case 2:
                    // Xem danh sach nguoi dung
                    List<User> users = userCRUD.getAllUsers();
                    if (users.isEmpty()) {
                        System.out.println("Khong co nguoi dung nao.");
                    } else {
                        for (User user : users) {
                            System.out.println(user);
                        }
                    }
                    break;
                    
                case 3:
                    // Cap nhat thong tin nguoi dung
                    System.out.print("Nhap ten nguoi dung can cap nhat: ");
                    String usernameToUpdate = scanner.nextLine();
                    System.out.print("Nhap ten nguoi dung moi: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Nhap mat khau moi: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Nhap ten day du moi: ");
                    String newFullName = scanner.nextLine();
                    userCRUD.updateUser(new User(newUsername, newPassword, newFullName));  // Su dung 'newUsername' thay cho 'new'
                    break;
                    
                case 4:
                    // Xoa nguoi dung
                    System.out.print("Nhap ten nguoi dung can xoa: ");
                    String usernameToDelete = scanner.nextLine();
                    userCRUD.deleteUser(usernameToDelete);
                    break;
                    
                case 5:
                    // Thoat chuong trinh
                    System.out.println("Thoat chuong trinh.");
                    userCRUD.closeConnection();
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        }
    }
}
