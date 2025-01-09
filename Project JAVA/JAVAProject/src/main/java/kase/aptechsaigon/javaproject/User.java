/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kase.aptechsaigon.javaproject;

/**
 *
 * @author Truc
 */
   public class User {
    private String username;
    private String password;
    private String fullName;
    private String address;

    // Constructor để khởi tạo đối tượng User
    public User(String username, String password, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
    }

    // Getter và Setter cho username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
//update
    //update2
    // Getter và Setter cho password
    //update lần 3
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter và Setter cho fullName
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
     // Getter và Setter cho addRess
    public String getAddress() {
        return address;
    }

    public void setAddress(String fullName) {
        this.address = address;
    }

    // Override phương thức toString() để in thông tin User
    @Override
    public String toString() {
        System.out.println("---Thong Tin Nguoi Dung---");
        return "username='" + username + "', password='" + password + "', fullName='" + fullName + "'"
                + "address='" + address;
    }


}
