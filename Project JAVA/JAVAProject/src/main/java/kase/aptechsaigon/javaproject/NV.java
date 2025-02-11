/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kase.aptechsaigon.javaproject;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class NV {
    private int maNhanVien;  // Mã chương trình học
    private String tenNhanVien; // Tên chương trình học
    private Date ngaySinh; // Thời gian hoàn thành (tháng hoặc năm)
    private int soCMT;
    private String diaChi;
    private String Email;
    private int dienThoai;
    private Date ngayVaoLam;
    private String matKhau;
    private int maChucVu;
    private int maPhongBan;

    // Constructor
    public NV(int maNhanVien, String tenNhanVien, Date ngaySinh, int soCMT, String diaChi, String Email, int dienThoai, Date ngayVaoLam, String matKhau, int maChucVu, int maPhongBan) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.ngaySinh = ngaySinh;
        this.soCMT = soCMT;
        this.diaChi = diaChi;
        this.Email = Email;
        this.dienThoai = dienThoai;
        this.ngayVaoLam = ngayVaoLam;
        this.matKhau = matKhau;
        this.maChucVu = maChucVu;
        this.maPhongBan = maPhongBan;
    }

    // Getter và Setter
    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    public int getsoCMT() {
        return soCMT;
    }
    
    public void setsoCMT(int soCMT) {
        this.soCMT = soCMT;
    }
    
    public String getdiaChi() {
        return diaChi;
    }
    
    public void setdiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    public String getEmail() {
        return Email;
    }
    
    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public int getdienThoai() {
        return dienThoai;
    }
    
    public void setdienThoai(String dienThoai) {
        this.diaChi = diaChi;
    }
    
    public Date getngayVaoLam() {
        return ngayVaoLam;
    }
    
    public void setngayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }
    
    public String getmatKhau() {
        return matKhau;
    }
    
    public void setmatKhau(String ngayVaoLam) {
        this.matKhau = matKhau;
    }
    
    public int getmaChucVu() {
        return maChucVu;
    }
    
    public void setmaChucVu(int maChucVu) {
        this.maChucVu = maChucVu;
    }
    
    public int getmaPhongBan() {
        return maChucVu;
    }
    
    public void setmaPhongBan(int maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    // Phương thức toString để hiển thị thông tin đối tượng
    @Override
    public String toString() {
        return "MaNhanVien: " + maNhanVien + ", TenNhanVien: " + tenNhanVien + ", ngaySinh: " + ngaySinh + ", soCMT: " + soCMT + ", diaChi: " + diaChi + ", Email: " + Email + ", dienThoai: " + dienThoai + ", ngayVaoLam: " + ngayVaoLam + ", matKhau: " + matKhau + ", maChucVu: " + maChucVu + ", maPhongBan: " + maPhongBan;
    }
}
