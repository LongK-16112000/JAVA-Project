/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kase.aptechsaigon.javaproject;

/**
 *
 * @author Admin
 */
public class NV {
    private int maNhanVien;  // Mã chương trình học
    private String tenNhanVien; // Tên chương trình học
    private int ngaySinh; // Thời gian hoàn thành (tháng hoặc năm)

    // Constructor
    public NV(int maNhanVien, String tenNhanVien, int ngaySinh) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.ngaySinh = ngaySinh;
    }

    // Getter và Setter
    public int getMaChuongTrinhHoc() {
        return maNhanVien;
    }

    public void setMaChuongTrinhHoc(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenChuongTrinh() {
        return tenNhanVien;
    }

    public void setTenChuongTrinh(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public int getThoiGianHoanThanh() {
        return ngaySinh;
    }

    public void setThoiGianHoanThanh(int ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    // Phương thức toString để hiển thị thông tin đối tượng
    @Override
    public String toString() {
        return "MaNhanVien: " + maNhanVien + ", TenNhanVien: " + tenNhanVien + ", ngaySinh: " + ngaySinh;
    }
}
