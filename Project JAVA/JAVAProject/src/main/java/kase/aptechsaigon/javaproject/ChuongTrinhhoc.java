/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kase.aptechsaigon.javaproject;

/**
 *
 * @author Truc
 */
public class ChuongTrinhhoc {
    private int maChuongTrinhHoc;  // Mã chương trình học
    private String tenChuongTrinh; // Tên chương trình học
    private int thoiGianHoanThanh; // Thời gian hoàn thành (tháng hoặc năm)

    // Constructor
    public ChuongTrinhhoc(int maChuongTrinhHoc, String tenChuongTrinh, int thoiGianHoanThanh) {
        this.maChuongTrinhHoc = maChuongTrinhHoc;
        this.tenChuongTrinh = tenChuongTrinh;
        this.thoiGianHoanThanh = thoiGianHoanThanh;
    }

    // Getter và Setter
    public int getMaChuongTrinhHoc() {
        return maChuongTrinhHoc;
    }

    public void setMaChuongTrinhHoc(int maChuongTrinhHoc) {
        this.maChuongTrinhHoc = maChuongTrinhHoc;
    }

    public String getTenChuongTrinh() {
        return tenChuongTrinh;
    }

    public void setTenChuongTrinh(String tenChuongTrinh) {
        this.tenChuongTrinh = tenChuongTrinh;
    }

    public int getThoiGianHoanThanh() {
        return thoiGianHoanThanh;
    }

    public void setThoiGianHoanThanh(int thoiGianHoanThanh) {
        this.thoiGianHoanThanh = thoiGianHoanThanh;
    }

    // Phương thức toString để hiển thị thông tin đối tượng
    @Override
    public String toString() {
        return "MaChuongTrinhHoc: " + maChuongTrinhHoc + ", TenChuongTrinh: " + tenChuongTrinh + ", ThoiGianHoanThanh: " + thoiGianHoanThanh;
    }
}