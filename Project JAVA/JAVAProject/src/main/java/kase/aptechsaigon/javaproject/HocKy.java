/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kase.aptechsaigon.javaproject;

/**
 *
 * @author Truc
 */
public class HocKy {
    private int maHocKy;            // Mã học kỳ
    private int maChuongTrinhHoc;   // Mã chương trình học (khóa ngoại)
    private String tenHocKy;        // Tên học kỳ
    private int soMonHoc;           // Số môn học trong học kỳ
    private String tenChungChi;     // Tên chứng chỉ của học kỳ (nếu có)
    private int thoiGianHoanThanh; // Thời gian hoàn thành học kỳ (tháng hoặc năm)
    private int soThuTuChungChi;   // Số thứ tự chứng chỉ của học kỳ

    // Constructor
    public HocKy(int maHocKy, int maChuongTrinhHoc, String tenHocKy, int soMonHoc, 
                 String tenChungChi, int thoiGianHoanThanh, int soThuTuChungChi) {
        this.maHocKy = maHocKy;
        this.maChuongTrinhHoc = maChuongTrinhHoc;
        this.tenHocKy = tenHocKy;
        this.soMonHoc = soMonHoc;
        this.tenChungChi = tenChungChi;
        this.thoiGianHoanThanh = thoiGianHoanThanh;
        this.soThuTuChungChi = soThuTuChungChi;
    }

    // Getter và Setter
    public int getMaHocKy() {
        return maHocKy;
    }

    public void setMaHocKy(int maHocKy) {
        this.maHocKy = maHocKy;
    }

    public int getMaChuongTrinhHoc() {
        return maChuongTrinhHoc;
    }

    public void setMaChuongTrinhHoc(int maChuongTrinhHoc) {
        this.maChuongTrinhHoc = maChuongTrinhHoc;
    }

    public String getTenHocKy() {
        return tenHocKy;
    }

    public void setTenHocKy(String tenHocKy) {
        this.tenHocKy = tenHocKy;
    }

    public int getSoMonHoc() {
        return soMonHoc;
    }

    public void setSoMonHoc(int soMonHoc) {
        this.soMonHoc = soMonHoc;
    }

    public String getTenChungChi() {
        return tenChungChi;
    }

    public void setTenChungChi(String tenChungChi) {
        this.tenChungChi = tenChungChi;
    }

    public int getThoiGianHoanThanh() {
        return thoiGianHoanThanh;
    }

    public void setThoiGianHoanThanh(int thoiGianHoanThanh) {
        this.thoiGianHoanThanh = thoiGianHoanThanh;
    }

    public int getSoThuTuChungChi() {
        return soThuTuChungChi;
    }

    public void setSoThuTuChungChi(int soThuTuChungChi) {
        this.soThuTuChungChi = soThuTuChungChi;
    }

    // Phương thức toString để hiển thị thông tin đối tượng
    @Override
    public String toString() {
        return "MaHocKy: " + maHocKy + ", MaChuongTrinhHoc: " + maChuongTrinhHoc + 
               ", TenHocKy: " + tenHocKy + ", SoMonHoc: " + soMonHoc + 
               ", TenChungChi: " + tenChungChi + ", ThoiGianHoanThanh: " + thoiGianHoanThanh + 
               ", SoThuTuChungChi: " + soThuTuChungChi;
    }
}
