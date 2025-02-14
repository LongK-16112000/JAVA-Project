/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kase.aptechsaigon.javaproject;

/**
 *
 * @author Admin
 */
public class PhongBan {
    private int maPhongBan;      // Mã phòng ban
    private String tenPhongBan;  // Tên phòng ban
    private int maTruongPhong;   // Mã trưởng phòng
    private int maPhoPhong;      // Mã phó phòng

    // Constructor
    public PhongBan(int maPhongBan, String tenPhongBan, int maTruongPhong, int maPhoPhong) {
        this.maPhongBan = maPhongBan;
        this.tenPhongBan = tenPhongBan;
        this.maTruongPhong = maTruongPhong;
        this.maPhoPhong = maPhoPhong;
    }

    // Getter and Setter
    public int getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(int maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public int getMaTruongPhong() {
        return maTruongPhong;
    }

    public void setMaTruongPhong(int maTruongPhong) {
        this.maTruongPhong = maTruongPhong;
    }

    public int getMaPhoPhong() {
        return maPhoPhong;
    }

    public void setMaPhoPhong(int maPhoPhong) {
        this.maPhoPhong = maPhoPhong;
    }

    // Method to display information
    @Override
    public String toString() {
        return "MaPhongBan: " + maPhongBan + ", TenPhongBan: " + tenPhongBan + ", MaTruongPhong: " + maTruongPhong + ", MaPhoPhong: " + maPhoPhong;
    }
}