/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kase.aptechsaigon.javaproject;

/**
 *
 * @author Admin
 */
public class BangLuong {
    private int maLuong;          // Mã lương
    private int maChucVu;         // Mã chức vụ
    private double mucLuong;      // Mức lương

    // Constructor
    public BangLuong(int maLuong, int maChucVu, double mucLuong) {
        this.maLuong = maLuong;
        this.maChucVu = maChucVu;
        this.mucLuong = mucLuong;
    }

    // Getter and Setter
    public int getMaLuong() {
        return maLuong;
    }

    public void setMaLuong(int maLuong) {
        this.maLuong = maLuong;
    }

    public int getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(int maChucVu) {
        this.maChucVu = maChucVu;
    }

    public double getMucLuong() {
        return mucLuong;
    }

    public void setMucLuong(double mucLuong) {
        this.mucLuong = mucLuong;
    }

    // Method to display information
    @Override
    public String toString() {
        return "MaLuong: " + maLuong + ", MaChucVu: " + maChucVu + ", MucLuong: " + mucLuong;
    }
}

