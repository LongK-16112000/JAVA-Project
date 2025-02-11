/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kase.aptechsaigon.javaproject;

/**
 *
 * @author Truc
 */
public class MonHoc {
    private int maMonHoc;         // Mã môn học
    private String tenMonHoc;     // Tên môn học
    private int soBuoiHoc;        // Số buổi học
    private int soGioHocMoiBuoi;  // Số giờ học mỗi buổi

    // Constructor
    public MonHoc(int maMonHoc, String tenMonHoc, int soBuoiHoc, int soGioHocMoiBuoi) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soBuoiHoc = soBuoiHoc;
        this.soGioHocMoiBuoi = soGioHocMoiBuoi;
    }

    // Getter and Setter
    public int getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(int maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public int getSoBuoiHoc() {
        return soBuoiHoc;
    }

    public void setSoBuoiHoc(int soBuoiHoc) {
        this.soBuoiHoc = soBuoiHoc;
    }

    public int getSoGioHocMoiBuoi() {
        return soGioHocMoiBuoi;
    }

    public void setSoGioHocMoiBuoi(int soGioHocMoiBuoi) {
        this.soGioHocMoiBuoi = soGioHocMoiBuoi;
    }

    // Method to display information
    @Override
    public String toString() {
        return "MaMonHoc: " + maMonHoc + ", TenMonHoc: " + tenMonHoc + ", SoBuoiHoc: " + soBuoiHoc + ", SoGioHocMoiBuoi: " + soGioHocMoiBuoi;
    }
}

